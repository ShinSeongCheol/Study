function Circle(radius) {
    console.log(this);

    this.radius = radius;
    this.getDiameter = function () {
        return 2 * this.radius;
    };
}