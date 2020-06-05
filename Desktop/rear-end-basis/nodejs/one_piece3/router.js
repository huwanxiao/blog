const deal = require("./deal");
const url = require('url')
const fs = require('fs')
module.exports.bing = (server,data) => {       //引入自定义模块使程序模块化
    server.on('request', (request, response) => {
        let method = request.method
        // 解析url为一个对象,对象中包括请求路径和请求参数
        let urlObj = url.parse(request.url,true);
        //true表示是否把拿到的数据解析为一个obj
        console.log("pathname:"+urlObj.pathname);
        console.log("query:"+JSON.stringify(urlObj.query));
        if(method == 'GET')
        {
            if(urlObj.pathname == '/')
            {
              deal.getall(request, response);
            } 
            else if (urlObj.pathname == '/requist')
            {
              deal.getone(request, response);
            }
            else if (urlObj.pathname == '/change')
            {
              deal.upuser_get(request, response); 
            }
            else if(urlObj.pathname == '/delete')
            {
              deal.delete_user(request, response); 
            }
            else
            {
                fs.readFile('./one_piece3' + urlObj.pathname,(err,data) => {
                  response.end(data)
                })
            }
        }
        else if (method == 'POST')
        {
            if(urlObj.pathname == '/change')
            {
              deal.upuser_post(request,response)
            }
        }   
        else
        {
            response.end("抱歉,不支持" + method + "类型请求");
        }
    });
}

            // let data = ''
            // /* 监听是否有新数据传过来 */
            // request.on('data',(che) => {
            //     data += che
            //})
            /* 数据监听数据是否传输传输完毕,
            数据比较大时,
            数据有可能是分多次传的 */
            // request.on('end',()=>{
            //    console.log(data);
            // })