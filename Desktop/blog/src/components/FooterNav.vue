<template>
  <div class="foot-nav" @click="back">
      <span class="guest-like-text"><slot></slot></span>
  </div>
</template>

<script>
export default {
  props: ['link'],
  methods: {
    back () {
      this.$emit('back')
    }
  },
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
  position: relative;
  width: 100%;
  height: 10px;
  background: #5891e3;
  bottom: -20px;
  left: 0;
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