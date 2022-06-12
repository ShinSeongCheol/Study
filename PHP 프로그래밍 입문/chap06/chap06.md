# 함수
## 함수를 이용하여 문자열 출력하기
```
<?php

    function hello() {
        echo "안녕하세요!";
    }

    hello();
    
?>
```

## 함수의 매개변수를 이용하여 두 수의 합 구하기
```
<?php

    function plus($a, $b) {
        $c = $a + $b;
        echo $c;
    }

    plus(10, 20);
    echo "<br>";
    plus(300, 500);

?>
```

##  함수의 반환값을 이용하여 두 수의 합 구하기
```
<?php
    function plus($a, $b) {
        $c = $a + $b;
        return $c;
    }

    $result1 = plus(10, 20);
    echo $result1."<br>";

    $result2 = plus(300,500);
    echo $result2."<br>";
?>
```

## 함수의 반환 값을 이용하여 정수의 값 구하기
```
<?php

    function sum($a, $b) {
        $sum = 0;
        while($a <= $b) {
            $sum = $sum + $a;
            $a++;
        }
        return $sum;
    }

    $from = 1;
    $to = 100;

    $total = sum($from, $to);
    echo "$from 에서 $to 까지의 합 : $total";

?>
```

## 함수를 이용하여 입장료 계산하기
```
<?php
    function cal_fee1($day, $age) {
        if($day == "주간") {
            if($age > 12 && $age < 65) {
                $money = 26000;
            }
            else {
                $money = 19000;
            }
        }
        else {
            if($age > 12 && $age < 65) {
                $money = 21000;
            }
            else {
                $money = 16000;
            }
        }
        return $money;
    }

    function cal_fee2($day, $age) {
        if($day == "주간") {
            if($age > 12 && $age <65) {
                $money = 33000;
            }
            else {
                $money = 24000;
            }
        }
        else {
            if($age > 12 && $age < 65) {
                $money = 28000;
            }
            else {
                $money = 21000;
            }
        }
        return $money;
    }

    function cal_fee3($age) {
        if($age > 12 && $age < 65) {
            $money = 55000;
        }
        else {
            $money = 40000;
        }
        return $money;
    }

    function cal_fee4($age) {
        if($age > 12 && $age < 65) {
            $money = 54000;
        }
        else {
            $money = 40000;
        }
        return $money;
    }

    $category = 1;
    $age = 13;
    $day = "야간";

    if($category == 1) {
        $fee = cal_fee1($day, $age);
        $cat = "일반 입장권";
    } 
    elseif($category == 2) {
        $fee = cal_fee2($day, $age);
        $cat = "자유 이용권";
    }
    elseif($category == 3 ) {
        $fee = cal_fee3($age);
        $cat = "2일 자유 이용권";
    }
    else {
        $fee = cal_fee4($age);
        $cat = "콤비권";
    }

    echo "- 구분 : $cat<br>";

    if($category == 1 || $category == 2) {
        echo "- 주야간 : $day<br>";
    }
    
    echo "- 나이 : $age 세<br>";
    echo "- 입장료 : $fee 원";
?>
```
## 문자열 관련 내장 함수 사용하기
```
<?php
    $tel = "010-2777-3333";
    echo "\$tel : $tel<br>";
    $num_tel = strlen($tel);

    echo "\$tel의 길이 : $num_tel<br>";

    $tel1 = substr($tel, 0, 3);
    echo "$tel1<br>";
    $tel2 = substr($tel, 4, 4);
    echo "$tel2<br>";
    $tel3 = substr($tel, 9, 4);
    echo "$tel3<br>";

    $phone = explode("-", $tel);

    echo "전화번호 : $phone[0] $phone[1] $phone[2]<br>";
?>
```