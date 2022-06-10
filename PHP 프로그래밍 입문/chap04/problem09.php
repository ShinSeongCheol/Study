<?php
    echo "-----------------------<br>";
    echo "제곱미터 평<br>";
    echo "-----------------------<br>";

    for($squreMeter=10; $squreMeter<=200; $squreMeter = $squreMeter + 10) {
        $flat = $squreMeter * 0.3025;
        echo "$squreMeter $flat<br>";
    }

    echo "-----------------------<br>";
?>