<?php

    class mariaDb {
        private $con;

        public function connect() {
            $this -> con = mysqli_connect("localhost", "root", "1234", "seongcheol");
        }

        public function close() {
            mysqli_close($this -> con);
        }

        public function registerUser($id, $password) {
            $this -> connect();

            $salt = new salt();
            $userInfo = new userInfo();

            $userInfo -> setId($id);
            $userInfo -> setPassword($password);
            $userInfo -> setLatest(date("Y-m-d H:i:s"));
            $userInfo -> setDatetime(date("Y-m-d H:i:s"));
            $userInfo -> setLoginCount(0);
            $userInfo -> setIp($_SERVER["REMOTE_ADDR"]);

            $userInfo -> setPassword($salt -> encryptPassword($userInfo -> userInfoArray(), $password));

            $account = $userInfo -> getId();
            $password  = $userInfo -> getPassword();
            $datetime = $userInfo -> getDatetime();
            $latest = $userInfo -> getLatest();
            $loginCount = $userInfo -> getLoginCount();
            $ip = $userInfo -> getIp();

            try{
                $sql = mysqli_prepare($this -> con, "INSERT INTO member(account, password, datetime, latest, login_count, ip) VALUES (?, ?, ?, ?, ?, ?)");
                mysqli_stmt_bind_param(
                    $sql,
                    "ssssis", 
                    $account, $password, $datetime, $latest, $loginCount, $ip
                );
                mysqli_stmt_execute($sql);
                mysqli_stmt_store_result($sql);
                $row = mysqli_stmt_affected_rows($sql);

                if($row){
                    return true;
                }
                else{
                    return false;
                }
            }
            catch(Exception $e){
                //echo("회원가입 오류<br>");
                echo $e;
            }

            $this -> close();
        }

        
        public function checkUserInfo($id) {
            $this -> connect();
            
            try{
                $sql = mysqli_prepare($this -> con, "SELECT account FROM member WHERE account = ?");
                mysqli_stmt_bind_param(
                    $sql,
                    "s",
                    $id
                );
                mysqli_stmt_execute($sql);
                mysqli_stmt_store_result($sql);
                $row = mysqli_stmt_num_rows($sql);

                if($row == 1) {
                    return true;
                }
                else {
                    return false;
                }
            }
            catch(Exception $e){
                echo ("회원정보 가져오기 오류");
            }
            
            $this -> close();
        }
        
        private function getUserInfo($account){
            $this -> connect();
            
            try{
                $sql = mysqli_prepare($this -> con, "SELECT account, password, datetime, latest, login_count, ip FROM member WHERE account = ?");
                mysqli_stmt_bind_param(
                    $sql,
                    "s",
                    $account
                );
                mysqli_stmt_execute($sql);
                mysqli_stmt_store_result($sql);
                $row = mysqli_stmt_num_rows($sql);
                
                if($row){
                    mysqli_stmt_bind_result($sql, $account, $password, $datetime, $latest, $login_count, $ip);
                    mysqli_stmt_fetch($sql);
                    
                    $userInfo = new userInfo();
                    $userInfo -> setId($account);
                    $userInfo -> setPassword($password);
                    $userInfo -> setDatetime($datetime);
                    $userInfo -> setLatest($latest);
                    $userInfo -> setLoginCount($login_count);
                    $userInfo -> setIp($ip);
                    return $userInfo;
                }
                else {
                    return false;
                }
            }catch(Exception $e) {
                echo("회원 정보를 가져오지 못했습니다.");
            }

            $this -> close();
        }
        
        public function updatePassword($id, $password) {
            $this -> connect();
            
            $userInfo = $this -> getUserInfo($id);
            
            $userInfo -> setId($id);
            $userInfo -> setPassword($password);
            $userInfo -> setDatetime($userInfo -> getLatest());
            $userInfo -> setLatest(date("Y-m-d H:i:s"));
            $userInfo -> setLoginCount($userInfo -> getLoginCount() + 1);
            $userInfo -> setIp($_SERVER["REMOTE_ADDR"]);
            
            $salt = new salt();
            $userInfo -> setPassword($salt -> encryptPassword($userInfo -> userInfoArray(), $password));
            
            $account = $userInfo -> getId();
            $password = $userInfo -> getPassword();
            $datetime = $userInfo -> getDatetime();
            $latest = $userInfo -> getLatest();
            $loginCount = $userInfo -> getLoginCount();
            $ip = $userInfo -> getIp();
            
            try{
                $sql = mysqli_prepare($this -> con, "UPDATE member SET password = ?, datetime = ?, latest = ?, login_count = ?, ip = ? WHERE account = ?");
                mysqli_stmt_bind_param(
                    $sql,
                    "sssiss",
                    $password, $datetime, $latest, $loginCount, $ip, $account
                );
                mysqli_stmt_execute($sql);
                mysqli_stmt_store_result($sql);
                $row = mysqli_stmt_affected_rows($sql);
                
                if($row) {
                    return $newPassword = $userInfo -> getPassword();
                }
                
            }
            catch(Exception $e) {
                echo("회원정보를 업데이트하지 못했습니다.");
            }
            
            
            $this -> close();
        }

        public function checkPassword($id, $password) {
            $this -> connect();
    
            $userInfo = $this -> getUserInfo($id);
            $userInfo -> setPassword($password);
    
            $dbUserInfo = $this -> getUserInfo($id);
    
            $salt = new salt();
            $password = $salt -> encryptPassword($userInfo -> userInfoArray(), $password);
            $encryptedPassword = $dbUserInfo -> getPassword();
    
            if($password == $encryptedPassword) {
                return $encryptedPassword;
            }
    
            $this -> close();
        }
        
    }
?>
