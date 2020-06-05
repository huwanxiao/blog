const template = require('art-template')
const linkdb = require("./linkdb");
template.defaults.root = './'    //设置路径，默认的路径是c盘的根目录

linkdb.getdata( data => {
    console.log("template_data"+ data );
    module.exports.data = template('./one_piece2/haizei.html', {data:data})
})

module.exports.getone = (id,callback) => {
    linkdb.getone( id, data => {
    console.log("deal:"+id);
    console.log("dbdata"+data);
    callback(template("./one_piece2/detail.html", {data:data}))
   })
}



