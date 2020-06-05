//读取文件夹实例，模拟aphache首页
const fs = require("fs");
const http = require("http");
let serve = new http.createServer();
serve.on("request", (request, response) => {
  let urls = request.url;
  console.log(urls);
  if (urls == "/") {
    response.setHeader("Content-type", "text/html;charset=utf-8");
    fs.readFile("./apache/apache.html", "utf-8", (err, data) => {
      if (!err) response.end(data);
    });
  } 
  else if 
  (urls == "/read_file") {
    fs.readdir("./", "utf-8", (err, data) => {
      if (!err) {
        let data_arr = []
        for(let i = 0; i < data.length; i++ ) {
          data_arr[i] = {};
          fs.stat(data[i], (error, file) => {
            if (!error) {
              if(file.isFile()) data_arr[i].type = "file";
              else data_arr[i].type = "directory";
              data_arr[i].name = data[i]
              data_arr[i].size = file.size
              data_arr[i].mtime = file.mtime
              if( i == data.length - 1) {
                //console.log(data_arr);      //出了stat回调函数的作用域无效,因为异步数据还没到就输出了
                response.end(JSON.stringify(data_arr));
              }
            }
          });
        };
      }
    });
  } 
  else 
  {
    fs.readFile("./apache" + urls, (err, data) => {
      if (!err) response.end(data);
    });
  }
});

serve.listen("8000", (err) => {
  if (!err) console.log("8000服务开启成功");
});
