<div id="message_box">
    <h3 class="title">
        <?php
            $mode = $_GET["mode"];
            $num = $_GET["num"];

            $con = mysqli_connect("localhost", "user1", "12345", "sample");
            $sql = "SELECT * FROM message WHERE num=$num";
            $result = mysqli_query($con, $sql);

            $row = mysqli_num_rows($result);
            $rv_id = $row["rv_id"];
            $regist_day = $row["regist_day"];
            $subject = $row["subject"];
            $content = $row["content"];

            $content = str_replace(" ", "&nbsp;", $content);
            $content = str_replace("\n", "<br>", $content);

            if($mode == "send") {
                $result2 = mysqli_query($con, "SELECT name FROM members WHERE id='$rv_id'");
            }
            else {
                $result2 = mysqli_query($con, "SELECT name FROM members WHERE id='$send_id'");
            }

            $record = mysqli_fetch_array($result2);
            $msg_name = $record["name"];

            if($mode=="send") {
                echo "송신 쪽지함 > 내용 보기";
            }
            else {
                echo "수신 쪽지함 > 내용 보기";
            }
        ?>
    </h3>
    <ul id="view_content">
        <li>
            <span class="col1"><b>제목 :</b> <?=$subject?></span>
            <span class="col2"><?=$msg_name?> | <?=$regist_day?></span>
        </li>
        <li>
            <?=$content?>
        </li>
    </ul>
</div>