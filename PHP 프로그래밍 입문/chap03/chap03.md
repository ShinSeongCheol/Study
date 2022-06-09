# 조건문
- if
- switch
## 짝수 홀수 판별 예제
```
<?php
    $n = 27;
    
    if($n % 2 == 0) {
        echo "$n : 짝수";
    }
    else {
        echo "$n : 홀수";
    }
?>
```
## 나이에 따라 입장료 판별하기
```
<?php
    $age = 66;
    $fee = 5000;

    if($age >= 65) {
        $fee = "무료";
    }

    echo "나이 : $age 세<br>";
    echo "입장료 : $fee";
?>
```

## 배수 판별하기
```
<?php
    $num = 32;
    $result = "3의 배수도 5의 배수도 아니다";

    if($num % 3 == 0) {
        $result = "3의 배수이다";
    }

    if($num % 5 == 0) {
        $result = "5의 배수이다";
    }

    if($num % 3 ==0 && $num % 5 == 0) {
        $result = "3의 배수이면서 5의 배수이다.";
    }

    echo "$num : $result";
?>
```

## 배수 판별하기 2
<?php
    $besu = 3;
    $num = 12;

    if($num % $besu == 0) {
        echo "$num : $besu"."의 배수이다.";
    }
    else {
        echo "$num : $besu"."의 배수가 아니다.";
    }
?>

## 회원 레벨에 따라 로그인 기능 판별하기
```
<?php
    $level = 7;
    echo "회원 레벨 : $level<br>";

    if($level >= 1 and $level <=7){
        echo "로그인 가능합니다!";
    }
    else {
        echo "로그인이 가능하지 않습니다!";
    }
?>
```

## 체중 조절 필요 여부 판별하기
```
<?php
    $h = 170;
    $w = 75;
    $a = ($h - 100) * 0.9;

    echo "키 : $h <br>";
    echo "몸무게 : $w <br>";

    if($w > $a) {
        echo "체중 조절이 필요합니다. <br>";
    }
    else {
        echo "체중 조절이 필요하지 않습니다.<br>";
    }
?>
```

## 점수에 따라 등급 판별하기
```
<?php
    $score = 83;

    if($score >= 95)
        $grade = "A+";
    elseif($score >=90)
        $grade = "A";
    elseif($score >= 85)
        $grade = "B+";
    elseif($score >= 80)
        $grade = "B";
    elseif($score >= 75)
        $grade = "C+";
    elseif($score >= 70)
        $grade = "C";
    elseif($score >= 65)
        $grade = "D+";
    elseif($score >= 60)
        $grade = "D";
    else
        $grade = "F";

    echo "입력된 점수 : $score 점<br>";
    echo "등급 : $grade";
?>
```

## 놀이공원 입장료 계산하기
```
<?php
    $age = 68;

    $welfare = "no";
    $youkong = "yes";
    $after = "no";

    if($age < 3)
        $fee = "무료";
    elseif(($age >= 3 && $age <= 13) || ($after == "yes"))
        $fee = "4,000원";
    elseif(($age >= 14 && $age <= 18) || ($age >= 70) || ($welfare == "yes") || ($youkong == "yes")) 
        $fee = "8,000원";
    else
        $fee = "10,000원";

    echo "복지 카드 소지 : $welfare<br>";
    echo "국가유공자증 소지 : $youkong<br>";
    echo "17시 이후 입장 : $after<br>";
    echo "나이 : $age 세<br><br>";
    echo "입장료 : $fee";
?>
```

## 정수 3개를 값이 큰 수서로 정렬하기
```
<?php
    $a = 2;
    $b = 6;
    $c = 9;

    if($a > $b){
        if($a > $c){
            $max1 = $a;
            if($b > $c) {
                $max2 = $b;
                $max3 = $c;
            }
            else {
                $max2 = $c;
                $max3 = $b;
            }
        }
        else {
            $max1 = $c;
            $max2 = $a;
            $max3 = $b;
        }
    }
    else {
        if($a > $c) {
            $max1 = $b;
            $max2 = $a;
            $max3 = $c;
        }
        else {
            if($b > $c){
                $max1 = $b;
                $max2 = $c;
                $max3 = $a;
            }
            else {
                $max1 = $c;
                $max2 = $b;
                $max3 = $a;
            }
        }
    }

    echo "입력된 세 정수 : $a $b $c<br>";
    echo "입력된 정수를 큰 수대로 배열 : $max1 $max2 $max3<br>";
?>
```

## 만 나이 계산하기
```
<?php
    $now_year = 2019;
    $now_month = 3;
    $now_day = 10;

    $birth_year = 1990;
    $birth_month = 3;
    $birth_day = 30;

    if($birth_month < $now_month)
        $age = $now_year - $birth_year;
    elseif($birth_month == $now_month){
        if($birth_day <= $now_day)
            $age = $now_year - $birth_year;
        else
            $age = $now_year - $birth_year - 1;
    }
    else 
        $age = $now_year - $birth_year - 1;

    echo "오늘 날짜 : $now_year 년 $now_month 월 $now_day 일 <br>";
    echo "출생 연월일 : $birth_year 년 $birth_month 월 $birth_day 일생<br>";
    echo "만 나이 : $age 세";
?>
```

## 학년에 따라 급식비 계산하기
### switch 문
```
<?php
    $grade = 5;

    switch($grade) {
        case 1 :
            echo "$grade 학년 급식비 : 3만원";
            break;
        case 2 :
            echo "$grade 학년 급식비 : 3만 5천원";
            break;
        case 3 :
            echo "$grade 학년 급식비 : 4만원";
            break;
        case 4 :
            echo "$grade 학년 급식비 : 4만 5천원";
            break;
        case 5 :
            echo "$grade 학년 급식비 : 5만원";
            break;
        case 6 :
            echo "$grade 학년 급식비 : 5만 5천원";
            break;
        default :
            echo "학년이 잘못 입력되었어요!";
            break;
    }
?>
```
### if 문
```
<?php
    $grade = 5;

    if($grade == 1)
        echo "$grade 학년 급식비 : 3만원";
    elseif($grade == 2)
        echo "$grade 학년 급식비 : 3만 5천원";
    elseif($grade == 3)
        echo "$grade 학년 급식비 : 4만원";
    elseif($grade == 4)
        echo "$grade 학년 급식비 : 4만 5천원";
    elseif($grade == 5)
        echo "$grade 학년 급식비 : 5만원";
    elseif($grade == 6)
        echo "$grade 학년 급식비 : 5만 5천원";
    else 
        echo "학년이 잘못 입력되었어요!";
?>
```