<?php
    class userInfo {

        private $id;
        private $password;
        private $latest;
        private $datetime;
        private $loginCount;
        private $ip;

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

        public function countVar() {
            $array = array("id" => $this -> getId(), "password" => $this -> getPassword(), "latest" => $this -> getLatest(), "datetime" => $this -> getDatetime(), "loginCount" => $this -> getLoginCount(), "ip" => $this -> getIp());
            return count($array);
        }

    }
?>