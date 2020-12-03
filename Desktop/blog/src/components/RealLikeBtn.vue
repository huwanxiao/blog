<template>
  <div
    class="realLikeBtn"
    :style="{ width: widthLength + 'px', height: heightLength + 'px' }"
    @mouseover="press"
    @mouseout="unpress"
  >
    <img
      class="img"
      :src="imgUrl"
      :width="heightLength * muti"
      :height="heightLength * muti"
    />
  </div>
</template>

<script>
export default {
  props: ['widthLength', 'heightLength', 'imgUrl'],
  data() {
    return {
      muti:0.9
    }
  },
  methods:{
    press() {
      this.muti = 0.88
    },
    unpress() {
      this.muti = 0.9
    }
  }
}
</script>

<style lang="scss" scoped>
.realLikeBtn {
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 20px;
  box-shadow: 18px 18px 30px rgba(0, 0, 0, 0.2),
    -18px -18px 30px rgba(255, 255, 255, 1);
  transition: all 0.2s ease-out;
}

.realLikeBtn img {
  transition:all 0.2s ease-out;
  border-radius: 50%;
  z-index: 5;
}

.realLikeBtn:hover {
  box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.2),
    0px 0px 0px rgba(255, 255, 255, 0.8),
    inset 18px 18px 30px rgba(0, 0, 0, 0.1),
    inset -18px -18px 30px rgba(255, 255, 255, 0.1);
}
</style>>