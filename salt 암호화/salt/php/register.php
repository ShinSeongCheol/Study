<?php
    include_once "database.php";
    include_once "userInfo.php";
    include_once "salt.php";

    $db = new mariaDb("localhost", "root", "seongcheol", "seongcheol");
    $userInfo = new userInfo();
    $salt = new salt();

    $registerForm = explode("&", $_POST["registerForm"]);

    $userInfo -> setId(explode("=", $registerForm[0])[1]);
    $userInfo -> setPassword(explode("=", $registerForm[1])[1]);
    $userInfo -> setLatest(date("Y-m-d H:i:s"));
    $userInfo -> setDatetime(date("Y-m-d H:i:s"));
    $userInfo -> setLoginCount(0);
    $userInfo -> setIp($_SERVER["REMOTE_ADDR"]);

    $salt -> setUserInfo($userInfo);

    $db -> registerUser($userInfo);
    $db -> close();
?>