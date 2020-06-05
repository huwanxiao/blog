const template = require('art-template')
const linkdb = require("./linkdb");
template.defaults.root = './' 

linkdb.getdata( datas => {
    console.log(datas);
    module.exports.data = template('./one_piece/haizei.html',{data:datas})
})


