function Person(name) {
    this.name = name;
}

const me = new Person('Lee');

const parent = {
    sayHello() {
        console.log(`Hi! My name is ${this.name}`);
    }
};

Object.setPrototypeOf(me, parent);

console.log(me.constructor === Person);
console.log(me.constructor === Object);