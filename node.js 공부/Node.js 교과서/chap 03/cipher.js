const crypto = require('crypto');
const key = crypto.randomBytes(32);
const iv = crypto.randomBytes(16);
const cipher = crypto.createCipheriv('aes-256-cbc', Buffer.from(key), iv);
let result = cipher.update('암호화 문장');
result += cipher.final('base64');
console.log(result);

const decipher = crypto.createDecipheriv('aes-256-ccm', Buffer.from(key), iv);
let result2 = decipher.update(result, 'base64');
result2 += decipher.final('utf8');
console.log('복호화:', result2);