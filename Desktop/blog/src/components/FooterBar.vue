<template>
   <footer class="footer-bar">
       <span class="info">职业:前端开发 | </span>
       <span class="info">坐标:温州 | </span>
       <span class="info">项目:个人博客</span>
   </footer>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
  .footer-bar {
      display: flex;
      position: relative;
      justify-content: center;
      align-items: center;
      width: 100%;
      height: 60px;
      bottom: 0px;
  }
  .info{
      color: rgb(255, 255, 255);
      size: 22pt;
      font-family: myFirstFont;
      font-weight: 500;
  }
</style>