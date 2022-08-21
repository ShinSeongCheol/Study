const fs = require('fs');
const example = fs.readFileSync('큰 수의 법칙.txt').toString().split('\n');

let array1, array2;

for(i=0; i<example.length; i = i+3) {
    array1 = example[i].trim().split(' ');
    array2 = example[i+1].trim().split(' ');

    console.log('array1: ', array1);
    console.log('array2: ', array2);

    let N = array1[0];
    let M = array1[1];
    let K = array1[2];

    array2.sort();

    let count = 0;
    let result = 0;
    for(j=0; j<M; j++) {
        if(count != K) {
            count++;
            result += parseInt(array2[N-1]);
        }
        else {
            count = 0;
            result += parseInt(array2[N-2]);
        }
    }

    console.log(result);
}