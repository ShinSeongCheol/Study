<?php
    $send_id = $_GET["send_id"];
    $rv_id = $_POST['rv_id'];
    $subject = $_POST['subject'];
    $content = $_POST['content'];
    $content = htmlspecialchars($content, ENT_QUOTES);
    $regist_day = date("Y-m-d (H:i)");

    $con = mysqli_connect("localhost", "user1", "12345", "sample");
    $sql = "SELECT * FROM members WHERE id='$rv_id'";
    $result = mysqli_query($con, $sql);
    $num_record = mysqli_num_rows($result);

    if($num_record) {
        $sql = "INSERT INTO message(send_id, rv_id, subject, content, regist_day) ";
        $sql .= "values('$sendid', '$rv_id', '$subject', '$content', '$regist_day')";
        mysqli_query($con, $sql);
    }
    else {
        echo("
        <script>
            alert('수신 아이디가 잘못되었습니다!');
            history.go(-1);
            </script>
        ");
        exit;
    }

    mysqli_close($con);
?>