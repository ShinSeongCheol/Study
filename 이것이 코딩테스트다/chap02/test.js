const fs = require('fs');
const example = fs.readFileSync('숫자 카드 게임.txt').toString().split('\n');

let N, M;
N = parseInt(example[0].split(' ')[0]);
M = parseInt(example[0].split(' ')[1]);

