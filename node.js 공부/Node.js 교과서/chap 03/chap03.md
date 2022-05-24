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