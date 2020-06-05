//实现了删改查
const http = require('http')
const router = require('./router')
const server = http.createServer()
router.bing(server)
server.listen('8020',(err) => {
    if(!err) console.log('8020服务开启成功');
})      