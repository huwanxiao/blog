//连接mysql之前先安装这个模块
//引入模块
const mysql = require('mysql')
//设置链接
let connection = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'root',
    database:'one_piece'
})
//打开链接
connection.connect()
//答应结果
let sql = "SELECT * FROM `character` WHERE name = '路飞'";
connection.query(sql,(err,res,filed) => {
    console.log(err);
    console.log("--------------------");
    console.log(res);
    console.log("--------------------");
    console.log(filed);
    console.log("--------------------");
})
connection.end()
