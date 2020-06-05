//封装成一个可以用链式调用的sql语句的拼接模块
const db = require("./query_db");
db.where("id=1").select();
db.where("name='hwx'").select();
db.select();
db.update();
db.update('character');
db.update('character','name = aaa');
db.where("name='hwx'").update("character");
db.where("name='hwx'").update('character', 'name = aaa');
