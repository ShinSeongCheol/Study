<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dynamic Salt</title>
</head>

<body>
    <?php
        $account = $_POST['id'];
        $password = $_POST['pwd'];

        if($con = mysqli_connect("localhost", "root", "seongcheol", "seongcheol")){

            $result = mysqli_query($con, "SELECT * FROM member WHERE account = '$account'");
            $row = mysqli_fetch_row($result);
            
            echo("<h1> 이전 값 </h1>");
            printTable($row);

            $result = mysqli_query($con, "SELECT * FROM member WHERE account = '$account'");
            $row = mysqli_fetch_assoc($result);
            $datetime = $row['datetime'];
            $latest = $row['latest'];
            $login_count = $row['login_count'];

            $password = getSaltString($datetime, $latest, $login_count, $password);

            $result = mysqli_query($con, "SELECT * FROM member WHERE account = '$account'");
            $row = mysqli_fetch_assoc($result);
            
            if($row['account'] == $account && $row['password'] == $password){

                $datetime = $latest;
                $latest = date("Y-m-d").' '.date('H:i:s');
                $login_count = $login_count + 1;
                $ip = $_SERVER['REMOTE_ADDR'];
                $password = $_POST['pwd'];
                
                $password = getSaltString($datetime, $latest, $login_count, $password);
                
                mysqli_query($con, "UPDATE member SET datetime = '$datetime', latest = '$latest', login_count = '$login_count', password = '$password', ip = '$ip'");

                $result = mysqli_query($con, "SELECT * FROM member WHERE account = '$account'");
                $row = mysqli_fetch_row($result);
                
                echo("<h1> 변경된 값 </h1>");
                printTable($row);

            }
            else {
                echo("<h1> 비밀번호 틀림! </h1>");
            }
        };

        function printTable($row){
            echo("<table style='text-align: center; border: 1px solid'>");
    
            echo("<tr>");
            echo("<th style=width:100px;></th>");
            echo("<th style=width:100px;>ID</th>");
            echo("<th style=width:100px;>account</th>");
            echo("<th style=width:100px;>password</th>");
            echo("<th style=width:100px;>datetime</th>");
            echo("<th style=width:100px;>latest</th>");
            echo("<th style=width:100px;>login_count</th>");
            echo("<th style=width:100px;>IP</th>");
            echo("</tr>");
    
            echo("<tr>");
            echo("<td></td>");
            for($i=0; $i<count($row); $i++) {
                echo("<td>$row[$i]</td>");
            }
            echo("</tr>");
    
            echo("</table>");
        }

        function getSaltString($datetime, $latest, $login_count, $password) {
            $mod = unpack("I", $password)[1] % 24;

            $arr = [$datetime, $latest, $login_count, $password];
        
            for($i=0; $i<count($arr); $i++) {
                for($j=0; $j<count($arr); $j++) {
                    for($k=0; $k<count($arr); $k++) {
                        if($i==$j || $j == $k || $k == $i)
                            continue;
                        $saltString[] = $arr[$i].$arr[$j].$arr[$k];
                    }
                }
            }

            return hash('sha256', "$saltString[$mod]");
        }
    ?>
</body>

</html>