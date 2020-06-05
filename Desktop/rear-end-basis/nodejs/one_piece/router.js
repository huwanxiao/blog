const deal = require("./deal");
module.exports.bing = (server,data) => {       //引入自定义模块使程序模块化
    server.on('request', (request, response) => {
        let urls = request.url
        if(urls == '/') {
            response.end(deal.data);
        }
    });
}