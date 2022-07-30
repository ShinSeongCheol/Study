<?php

    include_once "./database.php";
    $mariaDb = new mariaDb("localhost", "root", "seongcheol", "seongcheol");

    $mariaDb.setSql("SELECT * FROM member");
    $row = $mariaDb.getResult();
    echo($row["id"]);
    echo($row["password"]);
?>