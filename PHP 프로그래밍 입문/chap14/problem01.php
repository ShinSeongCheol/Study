<?php
    $subject = $_POST["subject"];
    $content = $_POST["content"];
    $regist_day = date("y-m-d (H:i)");
    $upload_dir = './data/';

    $upfile_name = $_FILES["upfile"]["name"];
    $upfile_tmp_name = $_FILES["upfile"]["tmp_name"];
    $upfile_type = $_FILES["upfile"]["type"];
    $upfile_size = $_FILES["upfile"]["size"];
    $upfile_error = $_FILES["upfile"]["error"];

    if($upfile_name && !$upfile_error) {
        $file = explode(".", $upfile_name);
        $file_name = $file[0];
        $file_ext = $file[1];

        $new_file_name = date("Y_m_d_H_i_s");
        $new_file_name = $new_file_name;
        $copied_file_name = $new_file_name.".".$file_ext;
        $uploaded_file = $upload_dir.$copied_file_name;

        move_uploaded_file($upfile_tmp_name, $uploaded_file);
    }
    else {
        $upfile_name = "";
        $upfile_type = "";
        $copied_file_name = "";
    }

    $con = mysqli_connect("localhost", "user1", "12345", "sample");
    $sql = "INSERT INTO board(id, name, subject, content, regist_day, hit, file_name, file_type, file_copied) ";
    $sql .= "VALUES('$userid', '$username', '$subject', '$content', '$regist_day', 0, ";
    $sql .= "'$upfile_name', '$upfile_type', '$copied_file_name')";
    mysqli_query($con, $sql);
?>