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