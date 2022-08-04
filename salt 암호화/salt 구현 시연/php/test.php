<?php
    class userInfo {
        private $id;
        private $password;
        private $latest;
        private $datetime;
        private $loginCount;
        private $ip;
        private $array;

        public function setId($id) {
            $this -> id = $id;
        }

        public function getId(){
            return $this -> id;
        }

        public function setPassword($password) {
            $this -> password = $password;
        }

        public function getPassword(){
            return $this -> password;
        }

        public function setLatest($latest) {
            $this -> latest = $latest;
        }

        public function getLatest(){
            return $this -> latest;
        }

        public function setDatetime($datetime) {
            $this -> datetime = $datetime;
        }

        public function getDatetime(){
            return $this -> datetime;
        }

        public function setLoginCount($loginCount) {
            $this -> loginCount = $loginCount;
        }

        public function getLoginCount(){
            return $this -> loginCount;
        }

        public function setIp($ip) {
            $this -> ip = $ip;
        }

        public function getip(){
            return $this -> ip;
        }

        public function encodeJson() {
            $this -> array = array("id" => $this -> getId(), "password" => $this -> getPassword(), "latest" => $this -> getLatest(), "datetime" => $this -> getDatetime(), "loginCount" => $this -> getLoginCount(), "ip" => $this -> getIp());
            return json_encode($this -> array);
        }

        public function getFactorial($num) {
            if($num == 0 || $num == 1) {
                return 1;
            }
            else {
                return getFactorial($num) * getFactorial($num-1);
            }
        }
    }

    $userInfo = new userInfo();
    $userInfo -> setId("hi");
    $userInfo -> setPassword("hello");
    $userInfo -> setLatest(date("Y-m-d H:i:s"));
    $userInfo -> setDatetime(date("Y-m-d H:i:s"));
    $userInfo -> setLoginCount(0);
    $userInfo -> setIp($_SERVER["REMOTE_ADDR"]);
    
    echo $userInfo -> encodeJson();
    echo($userInfo -> getFactorial(5));
?>