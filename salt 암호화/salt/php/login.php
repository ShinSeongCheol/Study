<?php

    include_once "database.php";
    $mariaDb = new mariaDb("localhost", "root", "1234", "seongcheol");
    echo($mariaDb.$con);
    $mariaDb.setSql("SELECT * FROM member");
    $row = $mariaDb.getResult();
    echo($row["id"]);
    echo($row["password"]);
?>