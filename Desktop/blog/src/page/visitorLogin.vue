<template>
  <div class="visitor-login">
    <div class="qq">
      <a
        href="https://github.com/login/oauth/authorize?client_id=1a6ace0dbce07b8b4d19&redirect_uri=http://localhost:3000/callback&scope=user&state=1"
      >
          <div class="icon iconfont icon-github"></div>
      </a>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    // async getToken() {
    //   let result = await this.$http.get('/getToken')
    //   console.log(result);
    // },
  },
}
</script>

<style lang="scss" scoped>
.visitor-login {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background: url(../assets/img/starSky.jpg);
  background-size: 100%;
  background-attachment: fixed;
}
.qq {
  position: absolute;
  width: 100px;
  height: 100px;
  border: 2px solid #fff;
  background: linear-gradient(150deg, rgb(5, 141, 239), rgb(22, 175, 194));
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.icon {
  font-size: 60px;
  color: #f39c12;
  font-weight: 500;
}
a {
  text-decoration: none;
}
</style>