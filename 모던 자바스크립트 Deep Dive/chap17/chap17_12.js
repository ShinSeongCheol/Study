function Circle(radius) {
    this.radius = radius;
    this.getDiameter = function () {
        return 2 * this.radius;
    };
    return 100;
}

const circle = new Circle(2);
console.log(circle);