const deal = require("./deal");
const url = require('url')
const fs = require('fs')
module.exports.bing = (server,data) => {       //引入自定义模块使程序模块化
    server.on('request', (request, response) => {
        let method = request.method
        // 解析url为一个对象,对象中包括请求路径和请求参数
        let urlObj = url.parse(request.url,true);
        //true表示吧拿到的数据解析为一个obj
        console.log("pathname:"+urlObj.pathname);
        console.log("query:"+JSON.stringify(urlObj.query));
        if(method == 'GET')
        {
            if(urlObj.pathname == '/')
            {
              response.end(deal.data);
            } 
            else if (urlObj.pathname == '/requist')
            {
              deal.getone(urlObj.query.id,(data) => {
                  console.log("page:"+data);
                  response.end(data);
              });
              
            }
            else
            {
                fs.readFile('./one_piece2' + urlObj.pathname,(err,data) => {
                  response.end(data)
                })
            }
        }
        else if (method == 'Post')
        {
            response.end('POST')
        }   
        else
        {
            response.end("抱歉,不支持" + method + "类型请求");
        }
    });
}