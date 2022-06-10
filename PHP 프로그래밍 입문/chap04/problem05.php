<?php

for($num=1; $num<=10; $num++) {
        $calculatedFactorial = 1;

        for($fact=1; $fact <= $num; $fact++) {
            $calculatedFactorial = $calculatedFactorial * $fact;
        }

        echo "{$num}! = $calculatedFactorial<br>";
    }
?>