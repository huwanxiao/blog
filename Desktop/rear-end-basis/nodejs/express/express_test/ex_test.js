const express = require('express')
const app = express();
const router = require('./router.js')
app.use(router)
//express的内置路由
//语法格式app.method(url,fun)
// app.get('/',(req,res) => {
//     res.send('Hello_World')
// })
app.listen(8080,() => {
   console.log('app框架成功搭建在8080端口');
})