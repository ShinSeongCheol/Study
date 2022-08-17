function Circle(radius) {
    ????.radius = radius;
}

Circle.prototype.getDiameter = function() {
    return 2 * ????.radius;
};

const circle = new Circle(5);