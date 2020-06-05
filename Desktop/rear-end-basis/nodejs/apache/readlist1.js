//读取文件夹实例，模拟aphache首页
const fs = require("fs");
const http = require("http");
const template = require("art-template");
template.defaults.root = "./";

let serve = new http.createServer();
serve.on("request", (request, response) => {
  let urls = request.url;
  console.log(urls);
  if (urls == "/") {
    response.setHeader("Content-type", "text/html;charset=utf-8");
    fs.readdir("./", "utf-8", (err, data) => {
      if (!err) {
        let data_arr = [];
        for (let i = 0; i < data.length; i++) {
          data_arr[i] = {};
          fs.stat(data[i], (error, file) => {
            if (!error) {
              if (file.isFile()) data_arr[i].type = "file";
              else data_arr[i].type = "directory";
              data_arr[i].name = data[i];
              data_arr[i].size = file.size;
              data_arr[i].mtime = file.mtime;
              if (i == data.length - 1) {
                let html = template("./apache/apache1.html", { data: data_arr });
                response.end(html);
              }
            }
          });
        }
      }
    });
  } else {
    fs.readFile("./apache" + urls, (err, data) => {
      if (!err) response.end(data);
    });
  }
});

serve.listen("8010", (err) => {
  if (!err) console.log("8010服务开启成功");
});
