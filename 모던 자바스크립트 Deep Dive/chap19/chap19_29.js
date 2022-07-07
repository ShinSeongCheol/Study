function Person(name) {
    this.name = name;
}

Person.prototype.sayHello = function () {
    console.log(`Hi! My name is ${this.name}`);
};

const me = new Person('남건우');
me.sayHello();
console.log(Object.getPrototypeOf(Person.prototype) === Object.prototype);