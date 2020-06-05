module.exports = {
  where: function (wh) {
    this.wh = wh;
    return this; //链式调用的精髓是返回这个实例
  },
  select: function () {
    if (this.wh == undefined) {
      let sql = "SELECT * FROM `character`";
      console.log(sql);
    } else {
      let sql = "SELECT * FROM `character` where ";
      console.log(sql + this.wh);
    }
    this.wh = undefined;
  },
  update:function (tabel,set) {
    this.tabel = tabel;
    this.set = set
    if(this.wh == undefined){
      console.log('执行失败,请先调用where');
    }else if(tabel == undefined || set == undefined ){
      console.log("参数不正确,请分别输入更新的表格和参数");
    }else {
      let sql = `UPDATE ${tabel} set ${set} where ${this.wh}`;
      console.log(sql);
    }
    this.wh = undefined;
  }
};