<template>
  <div class="blog-card-box">
    <div class="blog-content">
      <div class="opt">
        <real-like-btn
          :widthLength="50"
          :heightLength="50"
           v-for="(item,index) in optImg"
          :imgUrl="item"
          :key="index"
          @click="print(item)"
          class="real-btn"
        >
        </real-like-btn>
        <div class="mode">
          <div class="icon iconfont icon-liebiao"></div>
          <div class="icon iconfont icon-icon-test"></div>
        </div>
      </div>
      <div class="blog-card">
        <blog-item v-for="(item,index) in 3" :key="index"/>
      </div>
      <div><el-pagination class="pagination"></el-pagination></div>
    </div>

    <div class="tool-content">
      <div class="tool-card clock"></div>
      <el-card class="tool-card weather" :body-style="{ padding: '0px' }" >
      <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
      <div style="padding: 14px;">
        <span>好吃的汉堡</span>
        <div class="bottom clearfix">
          <time class="time"></time>
          <el-button type="text" class="button">操作按钮</el-button>
        </div>
      </div>
    </el-card>
    </div>
  </div>
</template>

<script>
import RealLikeBtn from './RealLikeBtn.vue'
import addImg from '../assets/img/add.png'
import deleteImg from '../assets/img/delete.png'
import BlogItem from './BlogItem.vue'
export default {
  components: { RealLikeBtn, BlogItem },
  data(){
    return {
      optImg:[addImg,deleteImg]
    }
  },
  methods:{
    print(item) {
      console.log(item);
    }
  }
}
</script>

<style lang="scss" scoped>
.real-btn{
  margin: 0px 5px;
}
.icon {
  font-size: 24px;
  color:  #f39c12;
}
.mode{
  position: absolute;
  right: 30px;
  background: red;
  width: 100px;
  height: 50px;
  display: flex;
  justify-content: space-around;
  align-items: center;
}
.blog-card-box {
  display: flex;
  justify-content: flex-start;
  border-radius: 20px;
  padding: 20px;
  position: relative;
  width: 99%;
  height: 120vh;
  margin: 0 auto;
  margin-top: 100vh;
  background: rgba(255, 255, 255, 0.9);
}

.blog-content {
  display: flex;
  justify-content: center;
  align-items: flex-start;
  position: relative;
  margin-right: 20px;
  border-radius: 4px;
  width: 60%;
  height: 100%;
  background: red;
  flex: 3;
  padding: 20px;
  flex-wrap: wrap;
}

.blog-card {
  width: 100%;
  height: 500px;
  position: relative;
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;
  align-items: flex-start;
  background: gold;
  padding: 5px;
  margin-bottom: 10px;
}

.tool-content {
  display: flex;
  flex-direction: column;
  position: relative;
  border-radius: 4px;
  height: 100%;
  width: 30%;
  padding: 10px;
  background: red;
  flex: 2;
}

.tool-card {
  flex: 1;
  margin-bottom: 10px;
  height: 50px;
  width: 100%;
  background: red;
}

.opt {
  width: 100%;
  height: 60px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  background: gold;
  padding: 5px 0px;
  margin-bottom: 10px;
}

.clock {
  border: 1px solid #f39c12;
}
</style>
