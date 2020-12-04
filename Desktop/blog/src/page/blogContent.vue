<template>
  <div class="blog-content">
    <search-bar :isShowBg="isShowBg" />
    
    <content-card/>
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
      isShowBg:false,
      page: {
        title: '我的文章',
      },
    }
  },
}
</script>

<style lang="scss" scoped>
/* .bar{
  position: relative;
  top: 0;
  left: 0;
  margin-top:10px ;
} */
.blog-content {
  position: relative;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-attachment: fixed;
  background-image: url('../assets/img/milu.jpg');
}
</style>