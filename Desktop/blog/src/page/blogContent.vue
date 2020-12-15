<template>
  <div class="blog-content">
    <div class="bg-pic"></div>
    <transition-mark v-show="isShowTransition"/> -->
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
    <search-bar :isShowBg="isShowBg" :isShowAvatar="false" />
    <content-card/>
    <footer-bar />
      <footer-nav @back="back">返回</footer-nav>
  </div>
  
</template>

<script>
import BlogCard from '../components/BlogCard.vue'
import ContentCard from '../components/ContentCard.vue'
import SearchBar from '../components/SearchBar.vue'
import TransitionMark from '../components/TransitionMark'
import FooterNav from '../components/FooterNav'
import FooterBar from '../components/FooterBar'
export default {
  components: { SearchBar, ContentCard,TransitionMark,FooterNav,FooterBar },
  mounted() {
    
    let _this = this
    _this.getAllPassage()
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
    },3200)
  },
  mounted() {
    this.getAllPassage()
  },
  methods: {
    async getAllPassage() {
      const result = await this.$http.get('getAllPassage')
      const data = result.data.data
      this.$store.commit("setPassageInfo",data)
    },
    back() {
      this.$router.go(-1);
    }
  },
  data() {
    return {
      isShowBg: false,
      isShowTransition:true,
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
  position: relative;
  background-size: 100%;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.bg-pic{
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background-size: 100%;
  background-attachment: fixed;
  background: url('../assets/img/milu.jpg');
}
</style>