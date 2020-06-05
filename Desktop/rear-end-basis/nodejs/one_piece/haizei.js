//搭建了一个表格的框架的网络服务
const http = require('http')
const router = require('./router')
const server = http.createServer()
router.bing(server)
server.listen('8080',(err) => {
    if(!err) console.log('8080服务开启成功');
})