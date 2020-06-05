1.三种打开repl环境的方式:浏览器f12;vscode终端输入node打入命令;使用node ./fs.js命令行
2.读文件的操作 --> read.js
3.写文件的操作 --> writer.js
4.创建一个服务器在页面输出'nihao'(创建服务器、监听请求(请求的时间->断开请求)、监听端口) --> http.js
5.创建第一个完整的http服务(加载不同类型的资源) --> http3.js
6.读取文件夹操作 --> readlist.js
7.读取文件夹状态信息 --> readStatus.js
8.模拟apache索引页的效果(客户端渲染) --> readlist.js/apache.html
9.art-template模板引擎的使用 --> art.js/art.js
10.模拟apache索引页的效果(服务端渲染用到模板引擎) --> readlist.js/apache.html
11.完成一个海贼王角色管理的实例页面 --> one piece
12.如何操作一个数据库 --> mysql.txt / db.js
13.用模块化的方式完成角色管理器页面 --> deal.js/haizei.js/haize.html/linkdb.js/router.js
14.理解回调函数 --> callback.js
15.完善查询的功能 --> one_piece2
16.链式操作的原理 --> link-option 
17.改进one_piece想,项目。改数据库调用为链式操作,简化调用的流程
18.增加update的功能 --> one_piece3
18.1.nodejs中的模块分成三类,分别是核心模块、第三方模块(node_module)、自定义模块
18.2.如何才能拿到post发送到服务断面的请求。查看文档后，这句话很关键
为了支持各种可能的HTTP应用,Nodejs的http的API是非常底层的。它只涉及流处理与消息解析。
他把一个消息解析成消息头和消息主体。但不解析具体的消息头和消息体。这就是为什么要引入url模块
post请求同理,需要用到更底层的网络实现,net核心模块
19.express框架的基础用法 --> express/express_test/ex_test.js
20.express对比内置路由与外置路由 --> express/express_test/router.js
21.实现图片的上传与入库 --> express/one_piece_express --> 用到npm i formidable -S
22.实现登录效果 --> express/one_piece_express --> 用到npm i cookie-session -S
23.用表单post数据时的表单头问题 --> post_request_header_intro.md
