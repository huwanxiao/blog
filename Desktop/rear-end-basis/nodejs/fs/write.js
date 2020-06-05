const fs = require('fs')
fs.writeFile('./writtenFile.txt',"nodejs真是太好用的",err => {
    if (!err) {
        console.log("写入成功!请查看writtenFile.txt");
    }
})