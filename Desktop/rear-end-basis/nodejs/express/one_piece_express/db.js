const mysql = require("mysql");
let connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "one_piece",
});
connection.connect();

module.exports = {
  where: function (wh) {
    this.wh = wh;
    return this; //链式调用的精髓是返回这个实例
  },
  select: function (callback) {
    let sql;
    if (this.wh == undefined) {
      sql = "SELECT * FROM `character`";
    } else {
      sql = "SELECT * FROM `character` where " + this.wh;
    }
    console.log(sql);
    connection.query(sql, (err, data) => {
      console.log(data);
      callback(data);
    });
    this.wh = undefined;
  },
  update: function (data,callback) {
    let sql
    if (this.wh == undefined) {
      console.log("请加where条件");
      return;
    } else {
      let set = "";
      for (i in data) set += i + "='" + data[i] + "',";
      set = set.slice(0, set.length - 1);
      sql = "UPDATE `character` set " + set + " where " + this.wh;
      console.log(sql);
      this.wh = undefined;
    }
    connection.query(sql,(err,data)=>{
      callback(data.changedRows)
    })
  },
  delete: function(callback){
    let sql
    if (this.wh == undefined) {
      console.log("请加where条件");
      return;
    } 
    else 
    {
      sql = "DELETE from `character` where " + this.wh;
    }
    connection.query(sql,(err,data) => {
      console.log(data);
      callback(data.affectedRows);
    })
    this.wh = undefined;
  },
  insert:function(callback){
    let sql = "insert into `character`(name,fruit) value('','')";
    connection.query(sql, (err, data) => {
      callback();
    });
  }
};
