const person = {
    name: 'Lee',
    address: 'Seoul',
    __proto__: {
        age: 20
    }
};

console.log(Object.values(person));