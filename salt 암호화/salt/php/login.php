<?php
    include_once "database.php";

    $db = new mariaDb("localhost", "root", "seongcheol", "seongcheol");
    $db -> test("SELECT * FROM member");
?>