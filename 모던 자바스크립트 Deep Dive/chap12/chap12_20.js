function add(x, y) {
    console.log(arguments);
    return x + y;
}

console.log(add(2, 5, 10));