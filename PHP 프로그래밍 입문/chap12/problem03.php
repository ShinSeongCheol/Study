<?php
    $id = $_GET["id"];

    $pass = $_POST["pass"];
    $name = $_POST["name"];
    $email1 = $_POST["email1"];
    $email2 = $_POST["email2"];

    $email = $email1."@".$email2;

    $con = mysqli_connect("localhost", "user1", "12345", "sample");
    $sql = "UPDATE members SET pass='$pass', name='$name', email='$email'";
    $sql .= "WHERE id='$id'";

    mysqli_query($con, $sql);
    mysqli_close($con);
?>