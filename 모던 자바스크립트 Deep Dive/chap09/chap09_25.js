function getStringLength(str) {
    str = str || '';
    return str.length;
}

console.log(getStringLength());
console.log(getStringLength('hi'));

function getStringLength(str = ''){
    return str.length;
}

console.log(getStringLength());
console.log(getStringLength('hi'));