<?php
    include_once "database.php";
    include_once "userInfo.php";
    include_once "salt.php";
    error_reporting(E_ALL^ E_WARNING);

    $db = new mariaDb();

    $registerForm = explode("&", $_POST["registerForm"]);
    $id = explode("=", $registerForm[0])[1];
    $password = explode("=", $registerForm[1])[1];

    if($db -> registerUser($id, $password)){
        echo("[$id]님 회원가입 되었습니다!");
    }
    else{
        echo("회원가입 실패했습니다.");
    }
?>