<?php
    $count = 0;

    for($num=1; $num<=500; $num++) {
        if($num % 5 == 0) {
            echo "$num ";

            $count++;
        }

        if($count != 0 && $count % 10 == 0) {
            $count = 0;
            echo "<br>";
        }
    }
?>