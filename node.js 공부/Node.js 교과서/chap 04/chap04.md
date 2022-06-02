# http 모듈로 웹서버 만들기
## http 모듈의 createServer 메서드
```
const http = require('http');

http.createServer((req, res) => {
    //여기에 어떻게 응답할지 적어줍니다.
});
```
## 응답 보내고 서버와 연결
```
const http = require('http');

http.createServer((req, res) => {
    res.write('<h1>Hello Node!</h1>');
    res.end('<p>Hello Server!</p>');
}).listen(8080, () => {
    console.log('8080번 포트에서 서버 대기 중입니다.');
});
```
## listen메서드에 콜백함수 넣는 대신 서버에 listening 이벤트 리스닝 붙이기
```
const http = require('http');

const server = http.createServer((req, res) => {
    res.write('<h1>Hello Node!</h1>');
    res.end('<p>Hello Server!');
});
server.listen(8080);
server.on('listening', () => {
    console.log('8080번 포트에서 서버 대기 중입니다!');
});
server.on('error', (error) => {
    console.error(error);
});
```
## html문서 읽어서 클라이언트의 응답요청에 넣어주기
```
const http = require('http');
const fs = require('fs');

http.createServer((req, res) => {
    fs.readFile('./server2.html', (err, data) => {
        if(err){
            throw err;
        }
        res.end(data);
    });
}).listen(8081, () => {
    console.log('8081번 포트에서 서버 대기 중입니다.');
});
```
## 쿠키와 세션
```
 const http = require('http');

const parseCookies = (cookie = '') => 
    cookie
    .split(';')
    .map(v => v.split('='))
    .map(([k, ...vs]) => [k, vs.join('=')])
    .reduce((acc, [k, v]) => {
    acc[k.trim()] = decodeURIComponent(v);
    return acc;
}, {});

http.createServer((req, res) => {
    const cookies = parseCookies(req.headers.cookie);
    console.log(req.url, cookies);
    res.writeHead(200, { 'Set-Cookie' : 'mycookie=test'});
    res.end('Hello Cookie');
})
.listen(8082, () => {
    console.log('8082번 포트에서 서버 대기 중입니다!');
});
```

```
const http = require('http');
const fs = require('fs');
const url = require('url');
const qs = require(querystring);

const parseCookies = (cookie = '') =>
    cookie
    .split(';')
    .map(v => v.split('='))
    .map(([k, ...vs]) => [k, vs.join('=')])
    .reduce((acc, [k, v]) => {
        acc[k.trim()] = decodeURIComponent(v);
        return acc;
}, {});

http.createServer((req, res) => {
    const cookies = parseCookies(req.headers.cookie);
    if(req.url.startsWith('/login')) {
        const { query } = url.parse(req.url);
        const { name } = qs.parse(query);
        const expires = new Date();
        expires.setMinutes(expires.getMinutes() + 5);
        res.writeHead(302, {
            Location: '/',
            'Set-Cookie': `name=${encodeURIComponent(name)};
            Expires=${expires.toGMTString()}; HttpOnly; Path=/`,
        });
        res.end();
    } else if (cookies.name) {
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(`${cookies.name}님 안녕하세요`);
    } else {
        fs.readFile('./server4.html', (err, data) => {
            if(err) {
                throw err;
            }
            res.end(data);
        })
    }
})
.listen(8083, () => {
    console.log('8083번 포트에서 서버 대기 중입니다');
});
```