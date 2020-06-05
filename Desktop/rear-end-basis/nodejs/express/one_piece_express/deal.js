const url = require("url");
const template = require("art-template");
const db = require("./db");
const formidable = require("formidable");
const fs = require("fs");
// const querystring = require("querystring");
template.defaults.root = "./"; //设置路径，默认的路径是c盘的根目录

module.exports = {
  add: function (req, res) {
    db.insert(()=>{
      let backStr =
        "<script>alert('记录增加成功');window.location.href='/'</script>";
      res.setHeader("Content-type", "text/html;charset=utf-8");
      res.end(backStr);
    })
  },
  login_get: function (req, res) {
    res.end(template("./express/one_piece_express/login.html", {}));
  },
  login_post: function (req, res) {
    let form = new formidable.IncomingForm();
    form.uploadDir = "tmp";
    form.parse(req, (err, fields, files) => {
      if (fields.uname == "admin" && fields.pws == "123456") {
        req.session.se_da = fields;
        console.log(req.session.se_da);
        let backStr =
          "<script>alert('登录成功');window.location.href='/'</script>";
        res.setHeader("Content-type", "text/html;charset=utf-8");
        res.end(backStr);
      } else {
        let backStr =
          "<script>alert('密码或用户名错误');window.location.href='/login'</script>";
        res.setHeader("Content-type", "text/html;charset=utf-8");
        res.end(backStr);
      }
    });
  },
  getall: function (req, res) {
    if (!req.session.se_da) {
      let backStr =
        "<script>alert('请登录');window.location.href='/login'</script>";
      res.setHeader("Content-type", "text/html;charset=utf-8");
      res.end(backStr);
      return;
    } else {
    }
    db.select((data) => {
      res.end(
        template("./express/one_piece_express/haizei.html", { data: data })
      );
    });
  },
  getone: function (req, res) {
    let urlObj = url.parse(req.url, true);
    let wh = "id=" + urlObj.query.id;
    db.where(wh).select((data) => {
      res.end(
        template("./express/one_piece_express/detail.html", { data: data })
      );
    });
  },
  upuser_get: function (req, res) {
    let urlObj = url.parse(req.url, true);
    let wh = "id=" + urlObj.query.id;
    db.where(wh).select((data) => {
      res.end(
        template("./express/one_piece_express/form.html", {
          data: data,
        })
      );
    });
  },
  upuser_post: function (req, res) {
    /* 把客户端的图片存到服务端 */
    let urlObj = url.parse(req.url, true);
    // 获取formidable对象
    let form = new formidable.IncomingForm();
    /* 用于暂时存放客户端传来的数据*/
    form.uploadDir = "tmp";
    //使用parse函数实现自动文件上传(判断请求、获取数据、解析数据、回调)
    form.parse(req, (err, fields, files) => {
      let file_path = "/img/" + files.img.name;
      //files以键值对的形式注明上了哪些文件,以及对象信息。上传文件后文件会被存在本地
      //用rename函数把这些数据重名名之后放到合适的位置
      fs.rename(files.img.path, "./public/img/" + files.img.name, (err) => {
        fields.img = file_path;
        /* 更新数据库 */
        let wh = "id=" + urlObj.query.id;
        db.where(wh).update(fields, (data) => {
          if (data >= 1) {
            let backStr =
              "<script>alert('修改成功');window.location.href='/'</script>";
            res.setHeader("Content-type", "text/html;charset=utf-8");
            res.end(backStr);
          }
        });
      });
    });
  },
  delete_user: function (req, res) {
    let urlObj = url.parse(req.url, true);
    let wh = "id=" + urlObj.query.id;
    db.where(wh).delete((data) => {
      // res.end(data.toString());
      if (data >= 1) {
        let backStr =
          "<script>alert('删除成功');window.location.href='/'</script>";
        res.setHeader("Content-type", "text/html;charset=utf-8");
        res.end(backStr);
      }
    });
  },
};

//原始做法
// upuser_post: function (req, res) {
//     let data = "";
//     /* 监听是否有新数据传过来 */
//     req.on("data", (che) => {
//       data += che;
//     });
//     /* 数据监听数据是否传输传输完毕,
//        数据比较大时,
//        数据有可能是分多次传的 */
//     req.on("end", () => {
//       var data_obj = querystring.parse(data);
//       console.log(data_obj);
//       res.end()
//       return

//       let urlObj = url.parse(req.url, true);
//       let wh = "id=" + urlObj.query.id;
//       db.where(wh).update(data_obj, (data) => {
//         /* res.end(data.toString()) */
//         if (data >= 1) {
//           let backStr =
//             "<script>alert('修改成功');window.location.href='/'</script>";
//           res.setHeader("Content-type", "text/html;charset=utf-8");
//           res.end(backStr);
//         }
//       });
//     });
//   }
