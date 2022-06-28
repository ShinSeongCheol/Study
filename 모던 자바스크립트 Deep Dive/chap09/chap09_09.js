console.log(typeof (+''));
console.log(typeof (+'0'));
console.log(typeof +'1');
console.log(typeof (+'string'));
console.log((+'string'));

console.log(typeof +true);
console.log(typeof +false);

console.log(typeof +null);

console.log(+undefined);

// console.log(+Symbol());
console.log(+{});
console.log(+[]);
console.log(+[10, 20]);
console.log(+function(){});