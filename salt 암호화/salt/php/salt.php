<?php
    class salt{
        private $userInfo;
        private $amount = 6;

        //몇개를  salt 암호화 조합으로 사용할지 정하기
        //팩토리얼 구하기
        //조합 구하기
        public function encryptPassword() {

        }

        public function setUserInfo($userInfo) {
            $this -> userInfo = $userInfo;
            $this -> amout = $userInfo -> countVar();
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
?>