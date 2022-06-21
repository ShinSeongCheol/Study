<?php
    $con = mysqli_connect("localhost", "user1", "12345", "sample");
    $sql = "SELECT * FROM board ORDER BY num DESC LIMIT 5";
    $result = mysqli_query($con, $sql);

    if(!$result) {
        echo "게시판 DB 테이블(board)이 생성 전이거나 아직 게시글이 없습니다!";
    }
    else {
        while($row = mysqli_fetch_array($result)) {
            $regist_day = substr($row["regist_day"], 0, 10);
            ?>

<li>
    <span><?=$row["subject"]?></span>
    <span><?=$row["name"]?></span>
    <span><?=regist_day?></span>
</li>

<?php
        }
    }
?>