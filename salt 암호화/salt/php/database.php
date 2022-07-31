<?php
    class mariaDb {
        private $con;
        private $sql;
        private $result;
        public $row;

        public function __construct($hostname, $username, $password, $database) {
           $this -> $con = mysqli_connect($hostname, $username, $password, $database);
        }

        public function finishMariaDb() {
            mysqli_close($con);
        }

        public function setSql($sql){
            $this -> $sql = $sql;
        }

        public function setResult() {
            $this -> $result = mysqli_query($this -> $con, $this -> $sql);
        }
        

        public function getAssoc() {
            return $this -> $row = mysqli_fetch_assoc($result);
        }

    }
?>