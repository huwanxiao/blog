//1.搭建第一个服务
//引入http核心模块
const http = require('http')
//创建一个服务器
let serve = http.createServer()
serve.on('request',(res,rs) => { //res带的是请求信息,re带有所有响应的方法
   //console.log(res.method);
   rs.write('nihao')   //在客户端显示这行
   rs.end()            //断开链接
})
//启动监听 
serve.listen('8080',() => {   //允许启用8080端口的时候调用
    console.log('启用服务成功');
})

