<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>회원가입</title>
</head>

<body>
    <?php

    $account = $_POST['id'];
    $password = $_POST['pwd'];
    $datetime = date('Y-m-d').' '.date('H:i:s');
    $latest = $datetime;
    $login_count = 0;
    $ip = $_SERVER['REMOTE_ADDR'];

    $mod = unpack("I", $password)[1] % 24;

    $arr = [$datetime, $latest, $login_count, $password];

    for($i=0; $i<count($arr); $i++) {
        for($j=0; $j<count($arr); $j++) {
            for($k=0; $k<count($arr); $k++) {
                if($i==$j || $j == $k || $k == $i)
                    continue;
                $saltString[] = $arr[$i].$arr[$j].$arr[$k];
            }
        }
    }

    $password = hash('sha256', "$saltString[$mod]");
    echo("$saltString[$mod]<br>$password");

    if($con = mysqli_connect("localhost", "root", "seongcheol", "seongcheol")){

        $insertQuery = "INSERT INTO member(account, password, datetime, latest, login_count, ip) VALUES('$account', '$password', '$datetime', '$latest', '$login_count', '$ip')";

        if(mysqli_query($con, $insertQuery)){
            echo("회원가입 성공");
            header( 'Location: ./login.html' );
        }else{
            echo("회원가입 실패");
        };

    } else {
        echo("데이터베이스 연결 실패");
    };
    ?>
</body>

</html>