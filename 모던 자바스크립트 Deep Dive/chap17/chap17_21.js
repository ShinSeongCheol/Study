let obj = new Object();
console.log(obj);

obj = Object();
console.log(obj);

let f = new Function('x', 'return x ** x');
console.log(f);

f = Function('x', 'return x ** x');
console.log(f);