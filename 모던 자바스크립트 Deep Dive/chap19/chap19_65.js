const person = {
    name: 'Lee',
    address: 'Seoul'
};

console.log('toString' in person);

for(const key in person) {
    console.log(key + ': ' + person[key]);
}