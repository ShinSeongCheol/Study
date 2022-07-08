const Person = (function() {
    function Person() {
        this.name = name;
    }

    Person.prototype.sayHello = function () {
        console.log(`Hi! My name is ${this.name}`);
    }

    return Person;
}());

const me = new Person('Lee');
me.sayHello();
delete Person.prototype.sayHello;
me.sayHello();