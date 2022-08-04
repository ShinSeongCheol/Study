<?php

    class mariaDb {
        private $con;

        public function connect() {
            $this -> con = mysqli_connect("localhost", "root", "seongcheol", "seongcheol");
        }

        public function close() {
            mysqli_close($this -> con);
        }

        public function registerUser($userInfo) {
            $this -> connect();

            $salt = new salt();
            $userInfo -> setPassword($salt -> encryptPassword($userInfo -> userInfoArray(), $userInfo -> getPassword()));

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
                    echo("[$account]님 회원가입 되었습니다!");
                }
                else{
                    echo("회원가입 실패했습니다.");
                }
            }
            catch(Exception $e){
                echo("회원가입 오류");
            }

            $this -> close();
        }

        public function checkPassword($userInfo) {
            $this -> connect();

            $dbUserInfo = $this -> getUserInfo($userInfo -> getId());

            $salt = new salt($userInfo);
            $password = $salt -> encryptPassword($userInfo -> userInfoArray(), $userInfo -> getPassword());
            $encryptedPassword = $dbUserInfo -> getPassword();

            if($password == $encryptedPassword) {
                return $encryptedPassword;
            }

            $this -> close();
        }

        public function getUserInfo($account){
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
                echo($e);
            }

            $this -> close();
        }

        public function updatePassword($userInfo) {
            $this -> connect();

            $salt = new salt();
            $userInfo -> setDatetime($userInfo -> getLatest());
            $userInfo -> setLatest(date("Y-m-d H:i:s"));
            $userInfo -> setLoginCount($userInfo -> getLoginCount() + 1);
            $userInfo -> setIp($_SERVER["REMOTE_ADDR"]);
            $userInfo -> setPassword($salt -> encryptPassword($userInfo -> userInfoArray(), $userInfo -> getPassword()));

            $password = $userInfo -> getPassword();
            $datetime = $userInfo -> getDatetime();
            $latest = $userInfo -> getLatest();
            $loginCount = $userInfo -> getLoginCount();
            $ip = $userInfo -> getIp();

            try{
                $sql = mysqli_prepare($this -> con, "UPDATE member SET password = ?, datetime = ?, latest = ?, login_count = ?, ip = ?");
                mysqli_stmt_bind_param(
                    $sql,
                    "sssis",
                    $password, $datetime, $latest, $loginCount, $ip
                );
                mysqli_stmt_execute($sql);
                mysqli_stmt_store_result($sql);
                $row = mysqli_stmt_affected_rows($sql);

                if($row) {
                   return $newPassword = $userInfo -> getPassword();
                }

            }
            catch(Exception $e) {
                echo($e);
            }


            $this -> close();
        }
    }
?>