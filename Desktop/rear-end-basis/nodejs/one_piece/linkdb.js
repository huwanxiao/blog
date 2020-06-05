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
    connection.end();
  });
}

//为什么用回调函数，为什么不直接在connection.query中返回取到的数据呢
//那是因为我在调用了模块之后，还等不到数据返回就被已经被拿去用了,当然是空的
//用了回调之后,下面的语句会等着被调用
//我一调用就通过传进来的回调函数把数据取走处理了，举个例子吧
//今天我去蛋糕店订了一个蛋糕,我只是说了我想要什么样的，并说今天来取,
//他就给我把原材料都要准备好，没准的我今天什么时候来取
//我一去他们就把准备好的东西现做现卖。把新鲜的蛋糕给我，我拿回去吃,
//这样就不存在时间差，避免了我去了还没做好。提升了效率

//你看这里的函数都是准备好的。他说：你什么需要我的时候记得调用我一下哦。不知道什么时候他过来调用了,
//通过调用传回调函数的方式满足了调用它的人的某种需求