<?php
    class salt{             
        
        private function getFactorial($num) {
            $result = 1;
            
            for($i=1; $i<=$num; $i++) {
                $result = $result * $i;
            }
            
            return $result;
        }
        
        public function encryptPassword($arr, $password) {
            $count = count($arr);
            $mod = unpack("I", $password)[1] % $this -> getFactorial($count);
            
            //중복없는 순열 알고리즘, 배열의 수만큼 중복없는 순열을 구하는 알고리즘으로 바꿔야 함. (시간 복잡도가 너무 큼)
            for($i1=0; $i1<$count; $i1++) {
                for($i2=0; $i2<$count; $i2++) {
                    for($i3=0; $i3<$count; $i3++) {
                        for($i4=0; $i4<$count; $i4++){
                            for($i5=0; $i5<$count; $i5++){
                                if($i1 == $i2 || $i1 == $i3 || $i1 == $i4 || $i1 == $i5
                                || $i2 == $i3 || $i2 == $i4 || $i2 == $i5
                                || $i3 == $i4 || $i3 == $i5
                                || $i4 == $i5
                                )
                                continue;
                                $saltString[] = $arr[$i1].$arr[$i2].$arr[$i3].$arr[$i4].$arr[$i5];
                            }
                        }
                    }
                }
            }

            return hash('sha256', "$saltString[$mod]");
        }
    }
?>