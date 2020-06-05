const express = require("express");
const router = express.Router()

//express的外置路由
//调用路由方法,获取路由对象
router.get("/", (req, res) => {
  res.send("Hello_World");
});

module.exports = router
