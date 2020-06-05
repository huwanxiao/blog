//string转int的三种方式
console.log( parseInt("1234") + 1 );
console.log(Number("1234") + 1);
console.log("1234"-0+1);
//实战测试
urlObj = {
   query: { id: "1" },
};
console.log(`id=${parseInt(urlObj.query.id) + 1}`);
console.log(Number(urlObj.query.id) + 1);
console.log(urlObj.query.id - 0 + 1);

