const express = require('express')
const deal = require("./deal.js");
const router = express.Router()

/* 设置各种请求 */
router
  .get("/", deal.getall)
  .get("/requist", deal.getone)
  .get("/change", deal.upuser_get)
  .post("/change", deal.upuser_post)
  .get("/delete", deal.delete_user)
  .get("/login", deal.login_get)
  .post("/login", deal.login_post)
  .get("/add",deal.add)

module.exports = router