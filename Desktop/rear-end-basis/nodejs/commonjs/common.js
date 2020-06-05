//导出的两种方式
//第一种
// module.exports = { 
//     age: 20, 
//     setName:function () {
//       this.name = 'hwx' 
//     }
// };
//第二种 
exports.age = '20'
exports.setName = (name) => {
    this.name = name
}
