# 쿠키와 세션
## 쿠키
### 쿠키 생성하기
```
<?php
    $a = setcookie("userid", "rubato");
    $b = setcookie("username", "김채린", time() + 60);

    if($a and $b) {
        echo "쿠키 'userid'와 'username' 생성 완료!<br>";
        echo "쿠키 'username'은 60초(1분)동안 지속됨!";
    }
?>
```
### 쿠키 사용하기
```
<?php
    if(isset($_COOKIE["userid"]) && isset($_COOKIE["username"])) {
        $userid = $_COOKIE["userid"];
        $username = $_COOKIE["username"];

        echo "userid 쿠키 : ".$userid."<br>";
        echo "username 쿠키 : ".$username."<br>";
    }
    else {
        echo "쿠키가 생성되지 않았다!";
    }
?>
```
### 쿠키 삭제하기
```
<?php
    setcookie("userid", "", time() - 3600);
    setcookie("username", "", time() - 3600);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        echo "userid와 username 쿠키가 삭제되었다!";
    ?>
</body>
</html>
```
## 세션
### 세션 시작하고 등록하기
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        session_start();
        echo "세션 시작!!<br>";

        $_SESSION['userid'] = "ocella";
        $_SESSION['username'] = "박영준";
        echo '세션 등록 완료!!!<br>';

        echo $_SESSION['userid']."<br>";
        echo $_SESSION['username']."<br>";
    ?>
</body>
</html>
```
### 세션 사용하기
```
<?php
    session_start();

    $userid = $_SESSION["userid"];
    $username = $_SESSION["username"];
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h3>등록된 세션의 사용</h3>
    <table>
        <ul>
            <li>등록된 세션(userid) : <?=$userid?></li>
            <li>등록된 세션(username) : <?=$username?></li>
        </ul>
    </table>
</body>

</html>
```
### 세션 삭제하기
```
<?php
    session_start();
    unset($_SESSION["username"]);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <ul>
        <li><?= "userid 세션 : ".$_SESSION["userid"]."<br>" ?></li>
        <li><?= "username 세션 : ".$_SESSION["username"]."<br>" ?></li>
        <li><?= "username 세션이 삭제되었습니다!" ?></li>
    </ul>
</body>

</html>
```