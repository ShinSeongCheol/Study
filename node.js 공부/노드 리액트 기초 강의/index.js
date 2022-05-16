const express = require('express')
const bodyParser = require('body-parser');
const app = express()
const port = 3000

app.use(bodyParser.urlencoded({ extended: false }));

const mysql = require('mysql')
const connection = mysql.createConnection({
    host : 'localhost',
    user : 'root',
    password : 'seongcheol',
    database : 'seongcheol'
})

connection.connect();

// app.get('/', (req, res) => res.send('<h1>Hello World!, 안녕하세요~~</h1>'))
app.get('/',(req,res) => res.send(`
    <div display : flex; justify-content:center; align-items:center; min-height: 100vh;>
        <h1>Seongcheol Database</h1>
            <a href="/userRegister"><input type="button" value="회원등록"></a>
            <a href="/userAlter"><input type="button" value="회원수정"></a>
            <a href=/userDelete"><input type="button" value="회원삭제"></a>
            <a href="/userList"><input type="button" value="회원조회"></a>
    </div>
            
`))

//회원 등록

app.get('/userRegister', (req,res) => 
    res.send(`
        <h1>회원 등록 창</h1>
        <form action ="/userRegister" method="POST">
            <input type="text" name="name">
            <input type="submit" value="SUBMIT">
        </form>
    `)
)

app.post('/userRegister', function(req,res){
    var params =[req.body.name];
    var sql = `INSERT INTO profile(NAME) VALUES(?)`
    connection.query(sql, params, function(error, results, fields){
    if(error){
        console.log(error);
        return res.send("INTERNAL ERROR");
    }else{
        console.log(results);
        return res.send(`
        <h1>seongcheol DB 회원 등록 성공</h1>
        <a href="/">MainHomePage</a>
        `)
    }
    })
})




//회원 수정
// connection.connect();
// connection.query('select * from profile', function(error, results, fields){
//     if(error){
//         console.log(error);
//     }{
//         console.log(results);
//         app.get('/userList', (req,res) => res.send(results))
//     }
// })
// connection.end();

// //회원 삭제
// connection.connect();
// connection.query('select * from profile', function(error, results, fields){
//     if(error){
//         console.log(error);
//     }{
//         console.log(results);
//         app.get('/userList', (req,res) => res.send(results))
//     }
// })
// connection.end();

//회원 조회
app.get('/userList', function(req,res) {
    connection.query(`SELECT * FROM profile`, function(error, results, fields){
        if(error){
            console.log(error);
            return;
        }else{
            console.log(results);
            return res.send(results);
        }
    });
});

app.listen(port, () => console.log('Example app listening on port ${port}!'))