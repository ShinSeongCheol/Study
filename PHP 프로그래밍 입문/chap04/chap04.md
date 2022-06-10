# 반복문

## while 문
### 1부터 10까지 출력
```
<?php 
    $i = 1;

    while($i <= 10){
        echo "$i<br>";
        $i++;
    }
?>
```

### 1부터 10까지 더하고 출력
```
<?php
    $sum = 0;
    $i = 1;

    while($i <= 10) {
        $sum = $sum + $i;
        echo "\$i : $i -> 합계 : $sum<br>";
        $i++;
    }
?>
```

### 100 ~ 300 까지의 정수 중 3의 배수의 합
```
<?php
    $sum = 0;
    $i = 100;

    while($i <= 300) {
        if($i % 3 == 0) {
            $sum = $sum + $i;
        }

        $i++;
    }

    echo "100 ~ 300 까지의 정수 중 3의 배수의 합 : $sum";
?>
```

### 1 ~ 100 까지의 정수를 한줄에 10개씩 출력
```
<?php
    $i = 1;
    $count = 0;
    while($i <= 100) {
        if($i % 3 != 0) {
            echo "$i ";
            $count++;
        }
        if($count % 10 == 0) {
            echo "<br>";
        }
        $i++;
    }
?>
```

### 인치 센티미터 변환
```
<?php
    $inch = 10;
    echo "<table border='1'>";
    echo "<tr>";
    echo "<th width='100'>인치</th><th width='100'>센티미터</th>";
    echo "</tr>";
    while($inch <= 100) {
        $cm = $inch * 2.54;
        echo "<tr align='center'><td>$inch</td><td>$cm</td></tr>";

        $inch = $inch + 10;
    }
    echo "</table>";
?>
```

### 2단 구구단 표 만들기
```
<h3>2단 구구단 표 만들기</h3>
<table border="1" width="100">
<?php
    $a = 2;
    $b = 1;

    while($b <= 9) {
        $c = $a * $b;
        echo "<tr><td align='center'>$a X $b = $c</td></tr>";
        $b++;
    }
?>
</table>
```

## for 문
### 1부터 10까지 출력
```
<?php
for($i = 1; $i <= 10; $i++) {
    echo "$i<br>";
}
?>
```

### 1~10의 합계 구하기
```
<?php
    $sum = 0;

    for($a = 1; $a <= 10; $a++) {
        $sum = $sum + $a;
    }

    echo "1에서 10까지 정수의 합은 $sum 입니다. <br>";
?>
```

### 1~100 5의 배수 합계 구하기
```
<?php
    $sum = 0;

    for($i=0; $i<=100; $i++) {
        if($i % 5 == 0) {
            $sum = $sum + $i;
        }
    }

    echo "1~100의 정수 중 5의 배수의 합계 : $sum";
?>
```

### 500 ~ 700 중 4의 배수가 아닌 정수 출력하기
```
<?php
    $count = 0;
    $ok = true;
    for($i = 500; $i <= 700; $i++) {
        if($i % 4 != 0) {
            echo $i." ";
            $count++;
            $ok = true;
        }
        if($count != 0 && $count % 10 == 0 && $ok == true) {
            echo "<br>";
            $ok = false;
        }
    }
?>
```

### for 문으로 섭씨를 화씨로 변환하기
```
<h3>섭씨 -> 화씨 온도 변환</h3>
<table border="1" width="300">
    <tr align="center"><td width="150">섭씨</td><td>화씨</td></tr>
    <?php
        for($c = -15; $c <=35; $c = $c + 5) {
            $f = $c * 9 / 5 + 32;
            echo "<tr align='center'><td>$c</td><td>$f</td></tr>";
        }
    ?>
```
## 이중 for 문
### 이중 for 문으로 구구단 표 만들기 1
```
<?php
    echo("--------------------<br>");

    for($a = 2; $a <= 9; $a++) {
        for($b = 1; $b <= 9; $b++) {
            $c = $a * $b;
            echo("$a X $b = $c <br>");
        }
        echo("--------------------<br>");
    }

?>
```

### 이중 for 문으로 구구단 표 만들기 2
```
<style>
    table {border-collapse:collapse; width:600px;}
    td {border:solid 1px gray; text-align:center; padding:5px;}
</style>
<h3>- 구구단 표</h3>
<table>
    <tr>
        <?php
            for($i=2; $i<=9; $i++) { 
                echo "<td>{$i}단</td>";
            }
        ?>
    </tr>
    <?php
        for($b=1; $b<=9; $b++) {
            echo "<tr>";
            for($a=2; $a<=9; $a++) {
                $c = $a * $b;
                echo "<td>{$a}X{$b}=$c</td>";
            }
            echo "</tr>";
        }
    ?>
</table>
```

### 이중 for 문으로 별표 출력하기 1
```
<?php
    for($a=1; $a<=10; $a++) {
        for($b=1; $b<=$a; $b++){
            echo "*";
        }
        echo "<br>";
    }
?>
```

### 이중 for 문으로 별표 출력하기 2
```
<?php
    for($a=1; $a<=10; $a++) {

        for($b=9; $b>=$a; $b--) {
            echo "&nbsp;";
        }

        for($b=1; $b<=$a; $b++){
            echo "*";
        }

        echo "<br>";
    }
?>
```

## do ~ while 문
### while 문으로 정수 1~10의 합계 구하기
```
<?php
    $i = 1;
    $sum = 0;

    while($i <= 10) {
        $sum = $sum + $i;
        $i++;
    }
    
    echo "합계 : $sum";
?>
```

### do ~ while문으로 정수 1~10의 합계 구하기
```
<?php
    $i = 1;
    $sum = 0;

    do {
        $sum = $sum + $i;
        $i++;
    } while ($i <= 10);

    echo "합계 : $sum";
?>
```

### do ~ while 문으로 10의 값 출력하기
```
<?php
    $i = 10;

    do {
        print $i;
    } while ($i <= 1);
?>
```

### while문으로 10의 값 출력하기
```
<?php
    $i = 10;

    while($i <= 1) {
        print $i;
    }
?>
```