<template>
  <div class="contact-mask" @click="isShow = !isShow">
    <!-- <el-button @click="isShow = !isShow"></el-button> -->
      <div :class="[isShow ? 'mask-active' : 'mask']">
        <img src="../assets/img/qq.png" :class="[isShow ? 'contact-pic-active' : 'contact-pic']">
      </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isShow: true,
    }
  },
}
</script>

<style>
.contact-mask {
  -webkit-perspective: 100px;
}

.mask {
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  height: 60px;
  width: 60px;
  top: -90px;
  left: 50%;
  overflow: hidden;
  margin-left: -30px;
  border-radius: 20px;
  -webkit-transform: rotateX(30deg);
  background: rgba(0, 0, 0, 0.4);
  transition: all 2s ease-in-out;
}

.mask-active {
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  height: 100vh;
  width: 100vw;
  overflow: hidden;
  top: 0;
  left: 0;
  background: rgba(255, 255, 255, 0);
  -webkit-transform: rotateX(0deg);
  transition: all 2s ease-in-out;
}

.contact-pic {
   -webkit-transform: rotateX(30deg);
   transition: all 2s ease-in-out;
}

.contact-pic-active {
   -webkit-transform: rotateX(0deg);
   transition: all 2s ease-in-out;
}
</style>
