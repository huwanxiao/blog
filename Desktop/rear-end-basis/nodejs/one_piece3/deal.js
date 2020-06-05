const url = require("url");
const template = require("art-template");
const db = require("./db");
const querystring = require("querystring");
template.defaults.root = "./"; //设置路径，默认的路径是c盘的根目录

module.exports = {
  getall: function (req, res) {
    db.select((data) => {
      console.log("template_data" + data);
      res.end(template("./one_piece3/haizei.html", { data: data }));
    });
  },
  getone: function (req, res) {
    let urlObj = url.parse(req.url, true);
    let wh = "id=" + urlObj.query.id;
    db.where(wh).select((data) => {
      res.end(template("./one_piece3/detail.html", { data: data }));
    });
  },
  upuser_get: function (req, res) {
    let urlObj = url.parse(req.url, true);
    let wh = "id=" + urlObj.query.id;
    db.where(wh).select((data) => {
      res.end(template("./one_piece3/form.html", { data: data }));
    });
  },
  upuser_post: function (req, res) {
    let data = "";
    /* 监听是否有新数据传过来 */
    req.on("data", (che) => {
      data += che;
    });
    /* 数据监听数据是否传输传输完毕,
       数据比较大时,
       数据有可能是分多次传的 */
    req.on("end", () => {
      var data_obj = querystring.parse(data);
      let urlObj = url.parse(req.url, true);
      let wh = "id=" + urlObj.query.id;
      db.where(wh).update(data_obj, (data) => {
        /* res.end(data.toString()) */
        if (data >= 1) {
          let backStr =
            "<script>alert('修改成功');window.location.href='/'</script>";
          res.setHeader("Content-type", "text/html;charset=utf-8");
          res.end(backStr);
        }
      });
    });
  },
  delete_user: function (req, res) {
    let urlObj = url.parse(req.url, true);
    let wh = "id=" + urlObj.query.id;
    db.where(wh).delete((data) => {
    // res.end(data.toString());
    if (data >= 1) {
        let backStr = "<script>alert('删除成功');window.location.href='/'</script>";
        res.setHeader("Content-type", "text/html;charset=utf-8");
        res.end(backStr);
      }
    });
  },
};

// module.exports.getone = (id,callback) => {
//     linkdb.getone( id, data => {
//     console.log("deal:"+id);
//     console.log("dbdata"+data);
//     callback(template("./one_piece2/detail.html", {data:data}))
//    })
// }
