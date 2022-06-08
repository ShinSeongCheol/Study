# chap02
## php 기초 문법
### 출력
```
<?php
    echo '안녕하세요~~~';
?>
```
### 주석문
/**/   
//
### 변수
```
<?php 
$a = 10;
$b = 20;
$c = $a + $b;
echo "$c <br>";

$a = 18.5;
$b = 37.3;
$c = $a + $b;
echo "$c <br>";

$fruit = "사과";
echo "$fruit <br>";
?>
```
### echo문
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <h3>
            <?php
                $filename = "cat.jpg";
                echo "<img src = '$filename'>";
                echo "<br>";

                $filename = "rabbit.jpg";
                echo "<img src = '$filename'>";
            ?>
        </h3>
    </body>
</html>
```
#### quot1
```
<?php
    $name = "홍지수";
    echo $name;
    echo "님 반갑습니다!";
    echo "<br>";
    
    $name = '홍지수';
    echo $name;
    echo '님 반갑습니다!';
?>
```
** 일반적으로 큰따옴표와 작은따옴표는 차이가 없다**
#### 예외 상황
```
<?php
    $name = "홍지수";
    ehco "$name 님 반갑습니다!";
    ehco "<br>";

    $name = '홍지수';
    ehco '$name 님 반갑습니다!';
?>
```
큰 따옴표와 작은 따옴표의 실행결과가 다르다.
```
<?php
    $name = "안지영";
    echo "$name님 반갑습니다!";
?>
```
변수명 뒤에 문자열이 붙을경우 에러가 발생한다.
```
<?php
    $name = "안지영";
    echo "{$name}님 반갑습니다!";
?>
```
중괄호를 붙여 코드를 작성하면 해결할 수 있다.
#### echo문의 약식 표기
```
<?php
    $id = "rubato";
    $name = '루바토';
?>
<h3>회원 정보</h3>
<p>- 아이디 : <?= $id ?></p>
<p>- 이름 : <?= $name ?></p>
```
<?= 표시하고 싶은 문자 ?> 같이 소스 코드를 작성하면 약식으로 echo를 사용할 수 있다.
### 기본 데이터형
- 정수
- 실수
- 배열
- 문자열
- 불
- 배열
php 변수 데이터형은 변수값의 데이터 형에 따라 결정된다.
#### 문자열 연결 연산자
```
<?php
    $num1 = "010";
    $num2 = "1234";
    $num3 = "5678";
    $phone_number = $num1."-".$num2."-".$num3;
    echo "휴대폰 번호 : $phone_number"."<br>";

    $email1 = "admin";
    $email2 = "seongcheol.com";
    $email = $email1."@".$email2;
    echo "이메일 주소 : $email";
?>
```
문자열 연결 연산자는 .(도트)를 사용해서 문자열을 연결한다.