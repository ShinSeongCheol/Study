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