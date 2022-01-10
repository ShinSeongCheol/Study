const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');

/*
설치
npm init
npm install vue
npm i(install) webpack webpack-cli -D(development)
npm i vue-loader -D
npm i vue-template-compiler -D

실행
rpm run build
*/
module.exports = {
    mode:'development',
    devtool: 'eval',
    resolve: {
        extensions: ['.js', '.vue'],
    },
    entry:{
        app:path.join(__dirname, 'main.js'),
    },
    module:{
        rules: [{
            test: /\.vue$/,
            loader: 'vue-loader',
        }],
    },
    plugins:[
        new VueLoaderPlugin(),
    ],
    output:{
        filename:'[name].js',
        path: path.join(__dirname, 'dist'),
    },
}