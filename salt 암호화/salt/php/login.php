<?php
    include_once "database.php";
    include_once "userInfo.php";
    include_once "salt.php";

    $db = new mariaDb();
    $userInfo = new userInfo();

    $loginForm = explode("&", $_POST["loginForm"]);
    $id = explode("=", $loginForm[0])[1];
    $password = explode("=", $loginForm[1])[1];
    
    if($userInfo = $db -> getUserInfo($id)){

        $userInfo -> setPassword($password);

        if($encryptedPassword = $db -> checkPassword($userInfo)){
            if($newPassword = $db -> updatePassword($userInfo)){
                $result["success"] = true;
                $result["oldPassword"] = $encryptedPassword;
                $result["newPassword"] = $newPassword;
                echo(json_encode($result));
            }
            else {
                echo("로그인 실패");
            }
        }
        else {
            echo ("비밀번호가 틀렸습니다.");
        }
    }
    else {
        echo("아이디가 없습니다.");
        return false;
    }
?>