<template>
  <div class="page-index">
    <!-- 海浪过度动画 -->
    <transition-wave v-show="isShowTransition"/>
    <!-- 封面 -->
    <div class="index-cover"></div>
    <!-- 搜索栏 -->
    <search-bar :isShowBg="isShowBg" :isShowSearch="false"/>
    <!-- 个性签名 -->
    <div class="signature">
       我曾难自拔于世界之大，也沉溺于其中梦话
    </div>
    <!-- 大搜索框 -->
    <big-btn class="big-btn"/>
    <!-- 底部导航栏 -->
    <router-link to="/guess">
      <footer-nav style="top:610px">猜你喜欢</footer-nav>
    </router-link>
  </div>
</template>

<script>
import BlogCard from '../components/BlogCard.vue'
import SearchBar from '../components/SearchBar.vue'
import TransitionWave from '../components/TransitionWave.vue'
import BigBtn from '../components/BigBtn'
import FooterNav from '../components/FooterNav.vue'
export default {
  components: { TransitionWave, SearchBar, BlogCard, BigBtn, FooterNav},
  data() {
    return {
      isShowBg: false,
      isShowTransition: true
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
    setTimeout(() => {
      _this.isShowTransition = false
    },2200)
  },
}
</script>

<style lang="scss" scoped>
.signature{
  position: relative;
  width: 1000px;
  height: 100px;
  // background: red;
  top: 100px;
  left: 120px;
  font-size: 3em;
  font-family: myFirstFont;
  text-align: center;
}
.page-index {
  width: 100%;
  height: 100%;
  position: relative;
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
.big-btn{
  position: absolute;
  left: 50%;
  top: 35%;
  transform: translateX(-50%);
}

</style>

