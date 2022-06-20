<?php
    $con = mysqli_connect("localhost", "user1", "12345", "sample");
    $sql = "SELECT * FROM message WHERE send_id='$userid' ORDER BY num DESC";
    $result = mysqli_query($con, $sql);
    $total_record = mysqli_num_rows($result);
    $scale = 10;

    if($total_record % $scale == 0) {
        $total_page = floor($total_record / $scale);
    }
    else {
        $total_page = floor($total_record / $scale);
    }

    $start = ($page - 1) * $scale;

    $number = $total_record - $start;

    for($i=$start; $i<$start+$scale && $i<$total_record; $i++) {
        mysqli_data_seek($result, $i);
        $row = mysqli_fetch_array($result);
        $num = $row["num"];
        $subject = $row["subject"];
        $regist_day = $row["regist_day"];

        if($mode == "send") {
            $msg_id = $row["rv_id"];
        }
        else {
            $msg_id = $row["send_id"];
        }

        $result2 = mysqli_query($con, "SELECT name FROM members WHERE id='$msg_id'");
        $record = mysqli_fetch_array($result2);
        $msg_name = $record["name"];
        $number--;
    }
    mysqli_close($con);
?>