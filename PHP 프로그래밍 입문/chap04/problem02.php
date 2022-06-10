<?php
    for($a=100, $count=0; $a<=500; $a++) {
        if($a % 2 == 0) {
            echo "$a ";
            $count++;
        }
        if($count == 2) {
            echo "<br>";
            $count = 0;
        }
    }
?>