const crypto = require('crypto');
const key = crypto.randomBytes(32);
const iv = crypto.randomBytes(16);

function encrypt(text){
    let cipher = crypto.createCipheriv('aes-256-cbc', Buffer.from(key), iv);
    encrypted = cipher.update(text);
    encrypted = Buffer.concat([encrypted, cipher.final()]);

    return { iv : iv.toString('hex'),
    encryptedData : encrypted.toString('hex') };
}
console.log(encrypt('암호화 문장'));
