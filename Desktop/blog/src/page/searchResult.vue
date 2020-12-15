<template>
  <div class="page-index">
    <!-- 海浪过度动画 -->
    <transition-wave v-show="isShowTransition" />
    <!-- 封面 -->
    <div class="index-cover"></div>
    <!-- 搜索栏 -->
    <search-bar
      :isShowBg="isShowBg"
      :isShowSearch="true"
      v-show="isShow"
      :isShowAvatar="true"
    />
    <!-- 底部导航栏 -->
    <!-- 博客卡片展示 -->
    <blog-card :isShowTool="false" :passageInfo="searchResult" :isShowCard="false"/>
    <footer-bar />
    <router-link to="/guess">
      <footer-nav>主页</footer-nav>
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
      searchResult:[]
    }
  },
  mounted() {
    //判断发起的请求种类
    let idx = this.$route.query.index
    let keyword = this.$route.query.word
    console.log(idx,keyword);
     if(idx == 0) {
       console.log(0);
       this.selectTitleEqual(keyword)
     }else if(idx == 1){
       console.log(1);
       this.selectTagRelated(keyword)
     }else if(idx == 2){
       console.log(2);
       this.selectKeywordRelated(keyword)
     } else {
       console.log(3);
       this.selectKeywordRelated(keyword)
     }
    this.dogShow = true
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
  methods:{
    async selectTitleEqual(keyword){
      const result = await this.$http.get('selectTitleEqual/'+keyword)
      if (result.data.code == 200) {
        this.searchResult = result.data.data
        return this.$message.success("搜索成功")
      }
      this.$message.error("搜索失败")
    },
     selectTagRelated(keyword){

     },
     selectKeywordRelated(keyword){

     }
  }
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

