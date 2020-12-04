<template> 
  <div class="search-bar" :class="[isShowBg == true? 'search-bar-bg':'' ]">
    <!-- 头像 -->
    <div class="avatar">
      <img src="../assets/img/avatar.jpg" alt="avatar" width="40" height="40" />
    </div>
    <!-- 搜索框 -->
    <div class="search">
      <el-input
        placeholder="请输入内容"
        prefix-icon="el-icon-search"
        v-model="keyword"
        InfoColor='info'
        v-show="!isShowBg"
      ></el-input>
      <el-input
        placeholder="请输入内容"
        prefix-icon="el-icon-search"
        v-model="keyword"
        NormalColor='norm'
        v-show="isShowBg"
      >
      </el-input>
    </div>
    <!-- 导航栏 -->
    <div class="nav">
      <navigation/>
    </div>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue'
export default {
  props: ['isShowBg'],
  components: {Navigation},
  data() {
    return {
      keyword: '',
    }
  },
}
</script>
  
<style lang="scss" scoped>
.search-bar {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 59px;
  /* background: red; */
  display: flex;
  justify-content: flex-start;
  align-items: center;
  border-radius: 0px 0px 5px 15px;
  z-index: 10;
}
.search-bar-bg {
  background: #fff;
  box-shadow: 2px 0px 5px rgba(0, 0, 0, 0.2);
}
.avatar {
  width: 40px;
  height: 40px;
  /* background: rgb(72, 255, 0); */
  margin-right: 30px;
  margin-left: 30px;
  border-radius: 50%;
  overflow: hidden;
}
.search {
  margin-right: 30px;
  position: relative;
}

.nav{
  position: fixed;
  right: 20px;
  top: 15px;
  z-index: 100;
}
</style>