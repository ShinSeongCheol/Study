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

### 단방향 암호화
```
const crypto = require('crypto');

console.log('base64:', crypto.createHash('sha512').update('비밀번호').digest('base64'));
console.log('hex:', crypto.createHash('sha512').update('비밀번호').digest('hex'));
console.log('base64:', crypto.createHash('sha512').update('다른 비밀번호').digest('base64'));
```
#### pbkdf2
```
const crypto = require('crypto');

crypto.randomBytes(64, (err, buf) => {
    const salt = buf.toString('base64');
    console.log('salt:', salt);
    crypto.pbkdf2('비밀번호', salt, 100000, 64, 'sha512', (err, key) => {
        console.log('password', key.toString('base64'));
    });
});
```
### 양방향 암호화
```
const crypto = require('crypto');
const algorithm = 'aes-256-cbc';
const key = crypto.randomBytes(32);
const iv = crypto.randomBytes(16);

function encrypt(text){
    let cipher = crypto.createCipheriv(algorithm, Buffer.from(key), iv);
    let encrypted = cipher.update(text);
    encrypted = Buffer.concat([encrypted, cipher.final()]);

    return { iv : iv.toString('hex'),
    encryptedData : encrypted.toString('hex') };
}

function decrypt(text){
    let iv = Buffer.from(text.iv, 'hex');
    let encryptedText = Buffer.from(text.encryptedData, 'hex');

    let decipher = crypto.createDecipheriv(algorithm, Buffer.from(key), iv);

    let decrypted = decipher.update(encryptedText);
    decrypted = Buffer.concat([decrypted, decipher.final()]);

    return decrypted.toString();
}

const output = encrypt('암호화 문장');
console.log(output);
console.log(decrypt(output));
```

### util
- 각종 편의 기능을 모아둔 모듈
```
const util = require('util');
const crypto = require('crypto');

const dontUseMe = util.deprecate((x,y) => {
    console.log(x+y);
}, 'dontUseMe 함수는 deprecated되었으니 더 이상 사용하지 마세요!');
dontUseMe(1,2);

const randomBytesPromise = util.promisify(crypto.randomBytes);
randomByytesPromise(64)
.then((buf) => {
    console.log(buf.toString('base64'));
})
.catch((error) => {
    console.error(error);
});
```
randomBytesPromise는 오류가 발생함

### fs
fs는 파일 시스템에 접근하는 모듈
- readFile(경로, 콜백함수(err, data))
- writeFile()
비동기적으로 실행
- readFileSync(경로)
- writeFileSync(경로, 데이터)
동기적으로 실행

비동기적으로 실행하되 순서를 유지하고 싶으면 콜백함수 안에 넣기. 
콜백 지옥이 펼쳐짐

promise나 async/await로 어느 정도 해결할 수 있다.

### buffer
메모리에 저장된 데이터
버퍼를 직접 다룰 수 있는 클래스는 Buffer

```
const buffer = Buffer.from('저를 버퍼로 바꿔주세요');
console.log('from():', buffer);
console.log('length:', buffer.length);
console.log('toString()', buffer.toString());

const array = [Buffer.from('띄엄 '), Buffer.from('띄엄 '), Buffer.from('띄어쓰기')];
const buffer2 = Buffer.concat(array);
console.log('concat():', buffer2.toString());

const buffer3 = Buffer.alloc(5);
console.log('alloc():', buffer3);

```

### stream
버퍼의 크기를 작게 만들어 여러번 보내는 것
나눠진 조각은 chunck
#### readStream
```
const fs = require('fs');

const readStream = fs.createReadStream('./readme3.txt', {highWaterMark: 16});
const data = [];

readStream.on('data', (chunck) => {
    data.push(chunck);
    console.log('data :', chunck, chunck.length, chunck.toString());
});

readStream.on('end', () => {
    console.log('end :', Buffer.concat(data).toString());
});

readStream.on('error', (err) => {
    console.log('error :', err);
});
```
readStream에는 on 메서드가 사용되고 data, end, error와 같은 이벤트 리스너를 사용한다.

#### writeStream
```
const fs = require('fs');

const writeStream = fs.createWriteStream('./writeme2.txt');
writeStream.on('finish', () => {
    console.log('파일 쓰기 완료');
});

writeStream.write('이 글을 씁니다.\n');
writeStream.write('한 번 더 씁니다.');
writeStream.end();
```
finish 이벤트 리스너는 writeStream.end()가 실행된후 콜백함수가 실행됨.

#### pipe
```
const fs = require('fs');

const readStream = fs.createReadStream('./readme4.txt');
const writeStream = fs.createWriteStream('./writeme3.txt');

readStream.pipe(writeStream);
```

읽은 파일 내용을 연결

#### 압축
```
const zlib = require('zlib');
const fs  = require('fs');

const readStream = fs.createReadStream('./readme4.txt');
const zlibStream = zlib.createGzip();
const writeStream = fs.createWriteStream('./readme4.txt.gz');
readStream.pipe(zlibStream).pipe(writeStream);
```

#### 폴더 만들기 
```
const fs = require('fs');

fs.access('./folder', fs.constants.F_OK | fs.constants.R_OK | fs.constants.W_OK, (err) => {
    if(err){
        if(err.code === 'ENOENT'){
            console.log('폴더 없음');
            fs.mkdir('./folder', (err) => {
                if(err){
                    throw err;
                }
                console.log('폴더 만들기 성공');
                fs.open('./folder/file.js', 'w', (err, fd) => {
                    if(err){
                        throw err;
                    }
                    console.log('빈 파일 만들기 성공', fd);
                    fs.rename('./folder/file.js', './folder/newfile.js', (err) =>{
                        if(err){
                            throw err;
                        }
                        console.log('이름 바꾸기 성공');
                    });
                });
            });
        } else{
            throw err;
        }
    } else {
        console.log('이미 폴더 있음');
    }
});
```
#### 파일 폴더 삭제
```
const fs = require('fs');

fs.readdir('./folder', (err, dir) =>{
    if(err){
        throw err;
    }
    console.log('폴더 내용 확인', dir);
    fs.unlink('./folder/newFile.js', (err) => {
        if(err) {
            throw err;
        }
        console.log('파일 삭제 성공');
        fs.rmdir('./folder', (err) => {
            if(err) {
                throw err;
            }
            console.log('폴더 삭제 성공');
        });
    });
});
```

#### 파일 복사
```
const fs = require('fs');

fs.copyFile('readme4.txt', 'writeme4.txt', (error) => {
    if(error){
        return console.error(error);
    }
    console.log('복사 완료');
});
```

#### 이벤트 
```
const EventEmitter = require('events');

const myEvent = new EventEmitter();
myEvent.addListener('event1', () => {
    console.log('이벤트 1');
});
myEvent.on('event2', () => {
    console.log('이벤트 2');
});

myEvent.emit('event1');
myEvent.emit('event2');

myEvent.once('event3', () => {
    console.log('이벤트 3');
});
myEvent.emit('event3');
myEvent.emit('event3');

myEvent.on('event4', () => {
    console.log('이벤트 4');
});
myEvent.removeAllListeners('event4');

const listener = () => {
    console.log('이벤트 5');
};
myEvent.on('event5', listener);
myEvent.removeListener('event5', listener);
myEvent.emit('event5');

console.log(myEvent.listenerCount('event2'));
```

### 예외 처리하기

```
setInterval(() => {
    console.log('시작');
    try{
        throw new Error('서버를 고장내주마!');
    }catch(err) {
        console.error(err);
    }
}, 1000);
```

```
const fs = require('fs');

setInterval(() => {
    fs.unlink('./abcdefg.js', (err) => {
        if(err) {
            console.error(err);
        }
    });
}, 1000);
```

```
process.on('uncaughtException', (err) => {
    console.error('예기치 못한 에러', err);
});

setInterval(() => {
    throw new Error('서버를 고장내주마!');
}, 1000);

setTimeout(() => {
    console.log('실행됩니다.');
}, 2000);
```