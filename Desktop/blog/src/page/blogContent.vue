<template>
  <div class="blog-content">
    <!-- 粒子特效 -->
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
    ></vue-particles>
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
    <!-- 页面组成组件 -->
    <search-bar :isShowBg="isShowBg" :isShowAvatar="false"/>
    <content-card style="margin: 0 auto" />
  </div>
</template>

<script>
import BlogCard from '../components/BlogCard.vue'
import ContentCard from '../components/ContentCard.vue'
import SearchBar from '../components/SearchBar.vue'
export default {
  components: { SearchBar, ContentCard },
  mounted() {
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
  data() {
    return {
      isShowBg: false,
      page: {
        title: '我的文章',
      },
    }
  },
}
</script>

<style lang="scss" scoped>
@import '../../global/yinghuochong.css';
.blog-content {
  // overflow: hidden;
  position: fixed;
  background-size: 100%;
  position: relative;
  top: 0;
  left: 0;
  width: 100%;
  height: 120vh;
  background-attachment: fixed;
  background-image: url('../assets/img/milu.jpg');
}
</style>