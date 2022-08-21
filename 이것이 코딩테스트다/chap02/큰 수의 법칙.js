const fs = require('fs');
const example = fs.readFileSync('큰 수의 법칙.txt').toString().split('\n');

let array1, array2;
let N, M, K;
let result = 0;

for(i=0; i<example.length; i=i+3){
    array1 = example[i].trim().split(' ');
    array2 = example[i+1].trim().split(' ');
    
    console.log('array1: ', array1);
    console.log('array2: ', array2);
    
    N = array1[0];
    M = array1[1];
    K = array1[2];
    
    array2.sort();
    
    let count = 0;
    let num1 = array2[N - 1];
    let num2 = array2[N - 2];
    
    for (i = 0; i < M; i++) {
        if (count != K) {
            result += parseInt(num1);
            count++;
        }
        else {
            result += parseInt(num2);
            count = 0;
        }
    }
    
    console.log('큰 수의 법칙:', result);
}