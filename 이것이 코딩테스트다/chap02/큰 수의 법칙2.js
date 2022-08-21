const fs = require('fs');
const example = fs.readFileSync('큰 수의 법칙.txt').toString().split('\n');


for (i = 0; i < example.length; i = i + 3) {
    let array1 = example[i].trim().split(' ');
    let array2 = example[i+1].trim().split(' ');
    
    let N, M, K;
    N = parseInt(array1[0]);
    M = parseInt(array1[1]);
    K = parseInt(array1[2]);
    
    array2.sort();
    
    let count = (M / (K + 1)) * K;
    count += (M % (K + 1));
    
    let result = 0;
    result += count * array2[N-1];
    result += (M - count) * array2[N-2];

    console.log(result);
}