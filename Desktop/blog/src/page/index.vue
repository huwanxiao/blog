<template>
  <div class="page-index">
    <!-- 海浪过度动画 -->
    <transition-wave />
    <!-- 封面 -->
    <div class="index-cover"></div>
    <!-- 搜索栏 -->
    <search-bar :isShowBg="isShowBg" />
    <!-- 博客卡片展示 -->
    <blog-card />
    <footer-bar />
  </div>
</template>

<script>
import BlogCard from '../components/BlogCard.vue'
import SearchBar from '../components/SearchBar.vue'
import TransitionWave from '../components/TransitionWave.vue'
import FooterBar from '../components/FooterBar.vue'
export default {
  components: { TransitionWave, SearchBar, BlogCard, FooterBar },
  data() {
    return {
      isShowBg: false,
    }
  },
  mounted() {
    this.dogShow = true
    let _this = this
    window.addEventListener('scroll', function () {
      let value = window.scrollY
      if (value >= 500) {
        _this.isShowBg = true
      } else {
        _this.isShowBg = false
      }
    })
  },
}
</script>

<style lang="scss" scoped>
.page-index {
  width: 100%;
  height: 100%;
}
.index-cover {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background-image: url('../assets/img/fushi-mountain.jpg');
  background-size: 100%;
  background-attachment: fixed;
}
</style>