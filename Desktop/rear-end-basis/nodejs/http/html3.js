//3.加载其他类型的静态资源文件
const http = require("http");
const fs = require("fs");
let serve = http.createServer();
serve.on("request", (res, rso) => {
  let urls = res.url;
  console.log(urls);
  if (urls == "/") {
    rso.setHeader("Content-type", "text/html;charset=utf-8");
    fs.readFile("./http/3.html", "utf-8", (err, data) => {
      if (!err) rso.end(data);
    });
  }else{
    //加载一切html所需的静态资源
    fs.readFile("./http"+urls, (err, data) => {
      if (!err) rso.end(data);
    });
  }
});
serve.listen("3000", () => {
  console.log("启用3000服务成功");
});
