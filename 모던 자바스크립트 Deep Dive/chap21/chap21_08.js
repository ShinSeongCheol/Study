//Window 환경
console.log(globalThis === this);
console.log(globalThis == window);
console.log(globalThis === self);
console.log(globalThis === frames);

//Node.js 환경
console.log(globalThis === this);
console.log(globalThis === global);