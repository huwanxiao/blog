<template>
  <div class="foot-nav">
      <span class="guest-like-text"><slot></slot></span>
  </div>
</template>

<script>
export default {
  props: ['link'],
}
</script>

<style lang="scss" scoped>
.guest-like-text {
  position: absolute;
  left: 50%;
  transform: translate(-50%);
  bottom: 5px;
  color: #fff;
}
.foot-nav {
  position: absolute;
  width: 100%;
  height: 10px;
  background: #5891e3;
  bottom: 0px;
  left: 0px;
  border-radius: 10px 10px 0 0;
}
.foot-nav::before {
  content: '';
  position: absolute;
  width: 80px;
  height: 20px;
  background: #5891e3;
  left: 50%;
  transform: translate(-50%);
  bottom: 10px;
  border-radius: 100px 100px 0 0;
}
</style>