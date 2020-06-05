const fs = require('fs')
//1.读取一个文件。回调函数当文件读完后执行
fs.readFile('./note.txt','utf-8',(err,data) => {   //成功和失败只有一个有值;第一个是错误的形参,第二个是成功的，顺序不能换
    console.log("err="+err);
    console.log("data="+data)
})  //读文件操作非常费时,假如读文件耗费2s,执行一行代码只要0.02s,那么2s的时间都够后面执行好几次了。异步就是不等先往下走，
   //直到相应的数据回来了我在执行,大大节省了资源，提高了效率
//以下四行先输出，说明了程序执行是异步的
console.log(1);
console.log(2);
console.log(3);
console.log(4);
