<template>
  <div class="login">
    <vue-particles
        color="#dedede"
        :particleOpacity="0.7"
        :particlesNumber="80"
        shapeType="circle"
        :particleSize="4"
        linesColor="#dedede"
        :linesWidth="1"
        :lineLinked="true"
        :lineOpacity="0.4"
        :linesDistance="150"
        :moveSpeed="3"
        :hoverEffect="true"
        hoverMode="grab"
        :clickEffect="true"
        clickMode="push"
      >
    </vue-particles>
    <!-- 萤火虫特效 -->
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="firefly"></div>
    <div class="btn-group">
      <div><button @click="jump('login/author')">作者</button></div>
      <div><button @click="jump('login/visitor')">游客</button></div>
    </div>
    
  </div>
</template>

<script>
export default {
  methods:{
    jump(addr) {
      this.$router.push(addr) 
    }
  }
}
</script>

<style lang="scss" scoped>
@import '../../global/yinghuochong.css';
.login {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background: url(../assets/img/starSky.jpg);
  background-size: 100%;
  background-attachment: fixed;
}
.btn-group {
  position: absolute;
  width: 250px;
  height: 250px;
  // background: red;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}
button {
  width: 200px;
  height: 60px;
  margin-right: 5px;
  border-radius: 5px;
  box-shadow: 10 10 10 10 rgba(0,0,0,0.2);
  background: linear-gradient(150deg,rgb(5,141,239),rgb(22,175,194));
  border: none;
}


</style>