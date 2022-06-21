<div id="board_box">
    <h3>
        게시판 > 목록보기
    </h3>
    <ul id="board_list">
        <li>
            <span class="col1">번호</span>
            <span class="col2">제목</span>
            <span class="col3">글쓴이</span>
            <span class="col4">첨부</span>
            <span class="col5">등록일</span>
            <span class="col6">조회</span>
        </li>
        <?php
            $con = mysqli_connect("localhost", "user1", "12345", "sample");
            $sql = "SELECT * FROM board ORDER BY num DESC";
            $result = mysqli_query($con,$sql);
            $total_record = mysqli_num_rows($result);

            $scale = 10;

            if($total_record % $scale == 0) {
                $total_page = floor($total_record / $scale);
            }
            else {
                $total_page = floor($total_record / $scale) + 1;
            }

            $start = ($page-1) * $scale;
            $number = $total_record - $start;

            for($i=$start; $i<$start+$scale && $i<$total_record; $i++) {
                mysqli_data_seek($result, $i);
                $row = mysqli_fetch_array($result);
                $num = $row['num'];
                $id = $row["id"];
                $name = $row["name"];
                $subject = $row["subject"];
                $regist_day = $row["regist_day"];
                $hit = $row["hit"];
                if($row["file_name"]) {
                    $file_image = "<img src='./img/file.gif'";
                }
                else {
                    $file_image = " ";
                }
        ?>
        <li>
            <span class="col1"><?=$number?></span>
            <span class="col2"><a href="board_view.php?num=<?=$num?>&page=<?$page?>"><?=$subject?></span>
            <span class="col3"><?=$name?></span>
            <span class="col4"><?=$file_image?></span>
            <span class="col5"><?=$regist_day?></span>
            <span class="col6"><?=$hit?></span>
        </li>
        <?php
            $number--;
            }
            mysqli_close($con);
        ?>
    </ul>
</div>