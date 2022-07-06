<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>

<body>
    <?php
    $account = $_POST['id'];
    $password = $_POST['pwd'];

    $con = mysqli_connect('localhost', 'root', 'seongcheol', 'seongcheol');
    $select_query = "SELECT * FROM member WHERE account = '$account'";

    $result = mysqli_query($con, $select_query);
    $row = mysqli_fetch_assoc($result);

    $password = hash('sha256', $row['latest'].$row['login_count'].$row['ip'].$password);

    if($account == $row['account'] && $password == $row['password']){
?>
    <table border='1' style="text-align: center;">
        <tr>
            <th style=width:100px;></th>
            <th style=width:100px;>ID</th>
            <th style=width:100px;>account</th>
            <th style=width:100px;>password</th>
            <th style=width:100px;>datetime</th>
            <th style=width:100px;>latest</th>
            <th style=width:100px;>login_count</th>
            <th style=width:100px;>IP</th>
        </tr>
        <?php
            // while($row = mysqli_fetch_row($result)) {
                $result = mysqli_query($con, $select_query);
                $row = mysqli_fetch_row($result);
                echo("<tr>");
                echo("<td></td>");
                for($i=0; $i<count($row); $i++) {
                    echo("<td>$row[$i]</td>");
                }
                echo("</tr>");
            // }
        ?>
    </table>

    <?php
    $result = mysqli_query($con, $select_query);
    $row = mysqli_fetch_assoc($result);

    $newYMD = date("Y-m-d");
    $newHIS = date("H:i:s");
    $newDatetime = "$newYMD $newHIS";

    $login_count = $row['login_count'] + 1;
    $ip = $_SERVER['REMOTE_ADDR'];
    
    $password = $_POST['pwd'];
    $totalString = $newDatetime.$login_count.$ip.$password;
    
    $newPassword = hash('sha256', $totalString);
    
    $update_query = "UPDATE member SET password = '$newPassword', datetime = '".$row['latest']."', latest = '$newDatetime',  login_count = '$login_count', ip = '$ip'";
    mysqli_query($con, $update_query);
    }
    else{
        echo('비밀번호 틀림!');
    }
?>
</body>

</html>