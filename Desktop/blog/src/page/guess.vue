<template>
  <div class="page-index">
    <!-- 海浪过度动画 -->
    <transition-wave v-show="isShowTransition"/>
    <!-- 封面 -->
    <div class="index-cover"></div>
    <!-- 搜索栏 -->
    <search-bar :isShowBg="isShowBg" :isShowSearch="true" v-show="isShow" :isShowAvatar="true"/>
    <!-- 底部导航栏 -->
    <!-- 博客卡片展示 -->
    <blog-card :isShowTool="true" :isShowCard="false" :passageInfo="allPassage"/>
    <footer-bar />
    <router-link to="/login">
      <footer-nav>登陆</footer-nav>
    </router-link>
  </div>
</template>

<script>
import BlogCard from '../components/BlogCard.vue'
import SearchBar from '../components/SearchBar.vue'
import TransitionWave from '../components/TransitionWave.vue'
import FooterNav from '../components/FooterNav.vue'
import FooterBar from '../components/FooterBar.vue'
export default {
  components: { TransitionWave, SearchBar, BlogCard, FooterNav, FooterBar },
  data() {
    return {
      isShowBg: false,
      isShow: true,
      isShowTransition:true,
      allPassage:this.$store.state.passageInfo
    }
  },
  mounted() {
    let _this = this
    
    window.addEventListener('scroll', function () {
      let value = window.scrollY
      if (value >= 10) {
        _this.isShow = false
      } else {
        _this.isShow = true
      }
    })

    setTimeout(() => {
      _this.isShowTransition = false
    },2200)
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

