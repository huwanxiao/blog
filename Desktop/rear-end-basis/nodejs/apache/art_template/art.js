const template = require('art-template')
template.defaults.root = './'
let str = template('./apache/art.html',{val:'zhangshan'})
console.log(str);
