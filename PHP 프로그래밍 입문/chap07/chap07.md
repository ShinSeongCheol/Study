# 폼과 PHP
## POST 방식
### 폼 양식 생성
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <form name="form1" method="post" action="view.php">
            <input type="text" name="name1">;
            <br><br>
            <input type="submit" value="확인">
        </form>
    </body>
</html>
```
### 폼 양식에 입력된 데이터 처리하기
```
<html>
    <head>
        <meta charset="utf-8">
</head>
<body>
    <?php
        $name = $_POST["name1"];
        echo $name."님 반갑습니다~~";
    ?>
</body>
</html>
```

### 아이디와 비밀번호 입력 창 생성하기
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="style.css" rel="styleseet">
    </head>
    <body>
        <form name="form1" method="post" action="view2.php">
            <ul>
                <li>아 &nbsp;이 &nbsp;디 : <input type="text" name="id"></li>
                <li>비밀번호 : <input type="password" name="pass"></li>
                <li><input type="submit" value="확인"></li>
            </ul>
        </form>
    </body>
</html>
```

### 아이디와 비밀번호로 입력된 데이터 처리하기
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="style.css" rel="stylesheet">
    </head>
    <body>
        <?php
            $id = $_POST["id"];
            $pass = $_POST["pass"];
        ?>
        <ul>
            <li>아 &nbsp;이 &nbsp;디 : <?= $id ?> </li>
            <li>비밀번호 : <?= $pass ?> </li>
        </ul>
    </body>
</html>
```

### 텍스트 입력창 생성하기
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <bdoy>
        <form name="form1" method="post" action="view3.php">
            글 내용 : <br>
            <textarea rows="5" cols="60" name="content"></textarea>
            <br><br>
            <input type="submit" value="확인">
        </form>
    </bdoy>
</html>
```

### 텍스트 영역에 입력된 데이터 처리하기
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <bdoy>
        <form name="form1" method="post" action="view3.php">
            글 내용 : <br>
            <textarea rows="5" cols="60" name="content"></textarea>
            <br><br>
            <input type="submit" value="확인">
        </form>
    </bdoy>
</html>
```

### 텍스트 영역에 입력된 데이터 처리하기
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="style.css" rel="stylesheet">
    </head>
    <body>
        <?php
            $content = $_POST["content"];
        ?>
        <ul>
            <li>글 내용 : <?= $content ?></li>
        </ul>
    </body>
</html>
```

### 라디오 버튼 생성하기
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="style.css" rel="stylesheet">
    </head>
    <body>
        <form name="form1" method="post" action="view4.php">
            <ul>
                <li>
                    성별 : 남성 <input type="radio" name="gender" value="남" checked>
                    여성 <input type="radio" name="gender" value="여">
                </li>
                <li>
                    이메일 : 수신 <input type="radio" name="email_ok" value="예">
                    비수신 <input type="radio" name="email_ok" value="아니오" checked>
                </li>
                <li><input type="submit" value="확인"></li>
            </ul>
        </form>
    </body>
</html>
```

### 라디오 버튼에서 선택된 데이터 처리하기
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="style.css" rel="stylesheet">
    </head>
    <body>
        <?php
            $gender = $_POST["gender"];
            $email_ok = $_POST["email_ok"];
            if($email_ok == "예")
                $email = "수신";
            else 
                $email = "비수신";
        ?>
        <ul>
            <li>성별 : <?= $gender ?></li>
            <li>이메일 : <?= $email_ok ?></li>
        </ul>
    </body>
</html>
```

### 체크박스 생성하기
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form name="form1" method="post" action="view5.php">
        <h3>당신의 취미는?</h3>
        <ul>
            <li>영화감상 <input type="checkbox" name="hobby[]" value="영화감상"></li>
            <li>맛집탐방 <input type="checkbox" name="hobby[]" value="맛집탐방"></li>
            <li>독서 <input type="checkbox" name="hobby[]" value="독서"></li>
            <li>요가 <input type="checkbox" name="hobby[]" value="요가"></li>
            <li>축구 <input type="checkbox" name="hobby[]" value="축구"></li>
            <li><input type="submit" value="확인"></li>
        </ul>
    </form>
</body>
</html>
```

### 체크박스에서 선택된 데이터 처리하기
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <ul>
        <li>
            나의 취미 :
            <?php
                $num = count($_POST["hobby"]);

                for($i=0; $i<$num; $i++) {
                    echo $_POST["hobby"][$i];
                    if($i != $num -1){
                        echo ", ";
                    }
                }
            ?>
        </li>
    </ul>
</body>
</html>
```

### 이메일 선택 박스 생성하기
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form name="form1" method="post" action="view6.php">
        <ul>
            <li>이메일 : <input type="text" name="email1">
                <select name="email2">
                    <option value="" selected>선택하세요!</option>
                    <option value="naver.com">naver.com</option>
                    <option value="google.com">gmail.com</option>
                    <option value="hanmail.net">hanmail.net</option>
                </select>
            </li>
            <li><input type="submit" value="확인"></li>
        </ul>
    </form>
</body>
</html>
```

### 이메일 선택 박스에서 선택된 데이터 처리하기
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<?php
    $email1 = $_POST["email1"];
    $email2 = $_POST["email2"];
?>
<body>
    <ul>
        <li>이메일 : <?php echo $email1."@".$email2 ?></li>
    </ul>
</body>
</html>
```

### hidden 입력 생성하기
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form name="form1" method="post" action="view7.php">
        <input type="hidden" name="userid" value="admin">
        <input type="submit" value="확인">
    </form>
</body>
</html>
```

### hidden으로 입력된 데이터 처리하기
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<?php
    $userid = $_POST["userid"];
?>
<body>
    <ul>
        <li>관리자 아이디 : <?= $userid ?></li>
    </ul>
</body>
</html>
```

### 이미지 파일 업로드하기
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form name="utf-8" method="post" action="view8.php" enctype="multipart/form-data">
        <ul>
            <li>이미지 업로드 : <input type="file" name="upload"></li>
            <li>설명 : <textarea name="comment" rows="3" cols = "60"></textarea></li>
            <li><input type="submit" value="확인"></li>
        </ul>
    </form>
</body>
</html>
```

### 파일 업로드 처리하기
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        $file_dir = "C:/xampp/htdocs/07/data/";
        $file_path = $file_dir.$_FILES["upload"]["name"];

        if(move_uploaded_file($_FILES["upload"]["tmp_name"], $file_path)) {
            $img_path = "data/".$_FILES["upload"]["name"];
    ?>

    <ul>
        <li><img src="<?= $img_path ?>"></li>
        <li><?= $_POST["comment"] ?> </li>
    </ul>

    <?php
        }
        else {
            echo "파일 업로드 오류가 발생했습니다!!";
        }
    ?>
</body>
</html>
```

## GET 방식
### GET 방식으로 데이터 전달하기
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        $table = $_GET["table"];

        if($table == "free") {
            $board_title = "자유게시판";
        }
        elseif($table == "download") {
            $board_title = "자료실";
        }
        elseif($table == "notice") {
            $board_title = "공지사항";
        }
        else {
            $board_title = "문의게시판";
        }
    ?>
    <h1><?= $board_title ?></h1>
</body>
</html>
```

### 링크 시 GET 방식으로 데이터 전달하기