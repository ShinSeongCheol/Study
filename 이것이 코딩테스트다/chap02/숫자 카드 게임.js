const fs = require('fs');
const example = fs.readFileSync('숫자 카드 게임.txt').toString().split('\n');

let i=0;
while(true) {
    if(i == example.length){
        break;
    }

    console.log(example[i]);
    i++;
}