# 배열

## 배열
### 배열을 이용하여 성적의 합계와 평균 구하기
```
<?php

    $score[0] = 90;
    $score[1] = 80;
    $score[2] = 85;
    $score[3] = 95;
    $score[4] = 93;

    $sum = 0;

    for($a=0; $a<=4; $a++) {
        $sum = $sum + $score[$a];
    }

    $avg = $sum/5;

    echo "과목 점수 : $score[0], $score[1], $score[2], $score[3], $score[4]<br>";
    echo "합계 : $sum, 평균 : $avg <br>";
?>
```

### array() 함수를 이용하여 성적의 합계와 평균 구하기
```
<?php
    $scores = array(87, 76, 98, 87, 87, 93, 79, 85, 88, 63, 74, 84, 93, 89, 63, 99, 81, 70, 80, 95);

    $sum = 0;
    for($a=0; $a<20; $a++) {
        $sum = $sum + $scores[$a];
    }

    $avg = $sum/20;

    echo("합계 : $sum, 평균 : $avg");
?>
```

### 배열을 이용하여 구구단 표 만들기
```
<?php
    for($i=0; $i<8; $i++) {
        $a[$i] = $i + 2;
        echo $a[$i]." ";
    }

    echo "<br>";

    for($j=0; $j<9; $j++) {
        $b[$j] = $j + 1;
        echo $b[$j];
    }

    echo "<br>-------------------------<br>";

    for($i=0; $i<9; $i++) {
        $c = $a[0] + $b[$i];
        echo "$a[0] X $b[$i] = $c<br>";
    }

    echo "-------------------------<br>";

    for($i=0; $i<9; $i++) {
        $c = $a[4] * $b[$i];
        echo "$a[4] X $b[$i] = $c<br>";
    }

    echo "-------------------------<br>";
?>
```

### 오름차순으로 버블 정렬하기
```
<?php
    $num = array(15, 13, 9, 7, 6, 12, 19, 30, 28, 26);
    $count = 10;

    echo "정렬 전 : ";

    for($a=0; $a<10; $a++) {
        echo $num[$a]." ";
    }

    echo "<br>";

    for($i=$count-2; $i>=0; $i--) {
        for($j=0; $j<=$i; $j++) {
            if($num[$j] > $num[$j + 1]) {
                $tmp = $num[$j];
                $num[$j] = $num[$j+1];
                $num[$j+1] = $tmp;
            }
        }
    }

    echo "버블 정렬(오름차순) 후 : ";
    for($a=0; $a<10; $a++) {
        echo $num[$a]." ";
    }

?>
```

## 2차원 배열
### 2차원 배열을 이용하여 성적의 합계와 평균 구하기
```
<?php
    $score = array(
        array(88,98,96,77,63),
        array(86, 77, 66, 86, 93),
        array(74, 83, 95, 86, 97)
    );

    for($i=0; $i<3; $i++) {

        for($j=0; $j<5; $j++) {

            echo "\$score[$i][$j] = ".$score[$i][$j]."<br>";

        }

        echo "<br>";

    }

    for($i=0; $i<3; $i++) {
        $sum = 0;

        for($j=0; $j<5; $j++) {

            $sum = $sum + $score[$i][$j];

        }

        $avg = $sum/5;
        $student_num = $i + 1;
        echo "$student_num 번 학생의 점수 => 합계 : $sum,
        평균 : $avg <br>";

    }
    
?>
```
