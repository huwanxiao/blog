const mysql = require("mysql");
let connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "one_piece",
});
connection.connect();

module.exports.getdata = (callback) => {
  let sql = 'SELECT * FROM `character`';
  connection.query(sql, (err, data) => {
    callback(data);
  });
}

module.exports.getone = (id,callback) => {
  let sql = "SELECT * FROM `character` where id=" + id;
  console.log("linkdb:"+id);
  connection.query(sql,(err,data) => {
    callback(data);
    //connection.end();
  });
}
