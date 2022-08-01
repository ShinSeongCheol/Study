<?php

    class mariaDb {
        private $con;

        public function __construct($hostname, $username, $password, $database) {
            $this -> con = mysqli_connect($hostname, $username, $password, $database);
        }

        public function close() {
            mysqli_close($this -> con);
        }

        public function searchAllData($sql) {
            $result = mysqli_query($this -> con, $sql);
            
            while($row = mysqli_fetch_row($result)) {
                for($i=0; $i<count($row); $i++){
                }
                echo("<br />");
            }
        }

        public function registerUser($userInfo) {

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
                
                if(mysqli_stmt_execute($sql)){
                    echo("[$account]님 회원가입 되었습니다!");
            }
            else {
                echo("회원가입 실패했습니다.");
            }
            }
            catch(Exception $e){
                echo("회원가입 오류");
            }
        }

        public function test($sql) {
            $result = mysqli_query($this -> con, $sql);
            $row = mysqli_fetch_fields($result);
            echo($row[0]);
        }

    }
?>