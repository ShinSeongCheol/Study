<?php
    echo "<table border=1>";
    echo "<tr align=center>";

    for($i=2; $i<10; $i++) {
        echo "<th>{$i}단</th>";
    }

    echo "</tr>";

    for($i=0; $i<=7; $i++) {

        for($j=0; $j<=8; $j++) {

            $result[$i][$j] = ($i+2) * ($j+1);

        }

    }

    for($j=0; $j<=8; $j++) {

        echo "<tr align=center>";

        for($i=0; $i<=7; $i++) {

            $a = $i + 2;
            $b = $j + 1;
            $c = $result[$i][$j];
            echo "<td>$a X $b = $c</td>";
        }

        echo "</tr>";

    }
    
    echo "</table>";
?>