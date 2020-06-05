//2.设置头部，用于解析html文件
//引入http核心模块
const http = require("http");
//创建一个服务器
let serve = http.createServer();
serve.on("request", (res, rso) => {    //第一个是request，第二个是response
  if(res.method == 'get') console.log('get请求');
  if (res.method == 'post') console.log('post请求');
   //不能为中文,除非在response的头中确定响应的类型
  rso.setHeader('Content-type','text/html;charset=utf-8')
  // rso.write('judge request')
  // rso.write("设置头文件之后");
  rso.end("<h1>writer</h1>和end一起写");  //断开链接
});
//启动监听
serve.listen("3000", () => {
  //允许启用3000端口的时候调用
  console.log("启用3000服务成功");
});
