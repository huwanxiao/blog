//使用express框架实现了增删改查、图片入库、cookie-session
const express = require('express')
//导入外置路由
const router = require('./router.js')
const cs = require('cookie-session')
const app = express();
app.use(cs({
    /* 用于cookie的键值 */
    name:'sessionId',
    /* 用于生成cookie值的密文 */
    keys:['huwanxiao']
}))
app.use(router)
//设置静态资源所在路径
//后续无需任何操作即可使用
app.use(express.static("public"));
//express的内置路由
//语法格式app.method(url,fun)
// app.get('/',(req,res) => {
//    deal.getall(req,res)
// })

app.listen('8080',() => {
    console.log('app服务监听在8080端口'); 
})