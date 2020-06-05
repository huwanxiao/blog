const fs = require('fs')
fs.readdir('./','utf-8',(err,data) => {
    data.forEach(item => {
       fs.stat(item,(error,file) => {
           console.log(file);
       });
    })
})