# chap 03
## REPL
**Read Eval Print Loop**   
## 터미널에서 실행하기
node 입력 후 코드 실행
```
const str = 'Hello world, hello node';
console.log(str);
```
## .js 파일로 실행하기
터미널에서 node [자바스크립트 파일경로] 입력 후 실행

## 모듈화
자바스크립트는 코드를 모듈화 할 수 있다.
```
const odd = '홀수 입니다.';
const even = '짝수 입니다.';

module.exports = {
    odd,
    even,
};
```
```
const { odd, even } = require('./var');

function checkOddOrEven(num){
    if(num % 2) {
        return odd;
    }
    else {
        return even;
    }
}

module.exports = checkOddOrEven;
```
```
const { odd, even } =  require('./var');
const checkNumber = require('./func');

function checkStringOddOrEven(str){
    if(str.length % 2) {
        return odd;
    }
    else {
        return even;
    }
}
console.log(checkNumber(10));
console.log(checkStringOddOrEven('Hello'));
```
module.export로 원하는 값을 코드를 모듈화 시킬 수 있다.
변수에 require() 함수를 사용하여 변수 값 지정 가능하다.

## 노드 내장 객체
### global
- 브라우저의 window와 같은 전역객체
- 간단한 데이터를 파일끼리 공유할 때 사용
```
module.exports = () => global.message;
```
```
const A = require('./globalA');

global.message = '안녕하세요';
console.log(A());
```
### console
- console.time(레이블)
- console.timeEnd(레이블)
- console.error(에러 내용)
- console.dir(객체, 옵션)
- console.trace(레이블)

### timer
- setTimeout(콜백함수, 밀리초)
- setInterval(콜백함수, 밀리초)

### filename, dirname
- __filename
- __dirname
현재 파일명과 파일의 위치를 알려준다.
```
console.log(__filename);
console.log(__dirname);
```

### process
코드에 직접 비빌번호를 치는 것은 위험해서 process.env의 SECRET_ID와 SECRET_CODE를 이용하자
```
const secretId = process.env.SECRET_ID;
const secretCode = process.env.SECRET_CODE;
```
### process.nextTick
nextTick은 setTimeout이나 setImmediate보다 먼저 실행된다
promise도 먼저 실행된다.
nextTick과 promise를 마이크로태스크라고 부른다.

### process.exit(코드)
코드 안에 0이나 1을 넣어서 정상정료, 비정상종료를 구분한다.
서버 외의 독립적인 프로그램에서는 수동으로 노드를 멈추기 위해 사용한다.
```
let i = 1;
setInterval(() => {
    if( i === 5){
        console.log('종료!');
        process.exit();
    }
    console.log(i);
    i += 1;
}, 1000)
```
## 노드 내장 모듈 사용하기
### os
```
const os = require('os');

console.log('운영체제 정보---------------------------------');
console.log('os.arch():', os.arch());
console.log('os.platform():', os.platform());
console.log('os.type():', os.type());
console.log('os.uptime():', os.uptime());
console.log('os.hostname9)', os.hostname());
console.log('os.release():', os.release());

console.log('경로-----------------------------------------');
console.log('os.homedir():', os.homedir());
console.log('os.tmpdir()', os.tmpdir());

console.log('cpu 정보-------------------------------------');
console.log('os.cpus():', os.cpus());
console.log('os.cpus().length:', os.cpus().length);

console.log('메모리 정보----------------------------------');
console.log('os.freemem():', os.freemem());
console.log('os.totalmem():', os.totalmem());
```
os 별로 다른 서비스를 제공할 때 유용

### path
```
const path = require('path');

const string = __filename;

console.log('path.sep:', path.sep);
console.log('path.delimiter:', path.delimiter);
console.log('--------------------------------');
console.log('path.dirname():', path.dirname(string));
console.log('path.extname()', path.extname(string));
console.log('path.basename()', path.basename(string));
console.log('path.basename():', path.basename(string, path.extname(string)));
console.log('--------------------------------');
console.log('path.parse()', path.parse(string));
console.log('path.format():', path.format({
    dir: 'C:\\Users\\Shinseongcheol',
    name: 'path',
    ext: '.js',
}));
console.log('path.normalize():', path.normalize('C://Users\\\\Shinseongcheol\\\path.js'));
console.log('--------------------------------');
console.log('path.isAbsolute():', path.isAbsolute('C:\\'));
console.log('path.isAbsolute():', path.isAbsolute('./home'));
console.log('--------------------------------');
console.log('path.relative():', path.relative('C:\\users\\Shinseongcheol\\path.js', 'C:\\'));
console.log('path.join():', path.join(__dirname, '..', '..', '/users', '.', '/Shinseongcehol'));
console.log('path.resolve()', path.resolve(__dirname, '..', 'users', '.', '/Shinseongcheol'));
```
### url
```
const url = require('url');

const URL = url.URL;
const myURL = new URL('http://www.gilbut.co.kr/book/bookList.aspx?sercate1=001001000#anchor');
console.log('new URL():', myURL);
console.log('url.format():', url.format(myURL));
console.log('--------------------------------');
const parsedUrl = url.parse('http://www.gilbut.co.kr/book/bookList.aspx?sercate1=001001000#anchor');
console.log('url.parse():', parsedUrl);
console.log('url.format():', url.format(parsedUrl));
```
- WHATWG의 url
- 기존 노드의 url
```
const { URL } = require('url');
const myURL = new URL('http://www.gilbut.co.kr/?page=3&limit=10&category=nodejs&category=javascript');
console.log('searchParams:', myURL.searchParams);
console.log('searchParams.getAll():', myURL.searchParams.getAll('category'));
console.log('searchParams.get():', myURL.searchParams.get('limit'));
console.log('searchParams.has():', myURL.searchParams.has('page'));

console.log('searchParams.keys():', myURL.searchParams.keys());
console.log('searchParams.values():', myURL.searchParams.values());

myURL.searchParams.append('filter', 'es3');
myURL.searchParams.append('filter', 'es5');
console.log(myURL.searchParams.getAll('filter'));

myURL.searchParams.set('filter', 'es6');
console.log(myURL.searchParams.getAll('filter'));

console.log('searchParams.toString():', myURL.searchParams.toString());
myURL.search = myURL.searchParams.toString();
```
### querystring
```
const url = require('url');
const querystring = require('querystring');

const parsedUrl = url.parse('http://www.gilbut.co.kr/?page=3&limit=10&category=nodejs&category=javascript');
const query = querystring.parse(parsedUrl.query);
console.log('querystring.parse():', query);
console.log('querystring.stringify():', querystring.stringify(query));
```