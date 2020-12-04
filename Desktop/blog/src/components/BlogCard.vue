<template>
  <div class="blog-card-box">
    <div class="blog-content">
      <div class="opt">
        <real-like-btn
          :widthLength="50"
          :heightLength="50"
          v-for="(item, index) in optImg"
          :imgUrl="item"
          :key="index"
          class="real-btn"
        >
        </real-like-btn>
        <div class="mode">
          <div class="icon iconfont icon-liebiao"></div>
          <div class="icon iconfont icon-icon-test"></div>
        </div>
      </div>
      <div class="blog-card">
        <blog-item v-for="(item, index) in 3" :key="index" />
      </div>
      <div><el-pagination class="pagination"></el-pagination></div>
    </div>

    <div class="tool-content">
      <div class="tool-card clock">
        <clock
          border="none"
          bg="radial-gradient(circle, #ecffe5, #fffbe1, #38ff91)"
          size="240px"
        ></clock>
      </div>
      <div class="tool-card weather">
        <div id="weather-v2-plugin-standard"></div>
      </div>
    </div>

    <el-backtop :bottom="100">
    <div
      style="{
        height: 100%;
        width: 100%;
        background-color: #f2f5f6;
        box-shadow: 0 0 6px rgba(0,0,0, .12);
        text-align: center;
        line-height: 40px;
        color: #1989fa;
        border-radius:50%
      }"
    >
      UP
    </div>
    </el-backtop>
  </div>
</template>

<script>
import RealLikeBtn from './RealLikeBtn.vue'
import addImg from '../assets/img/add.png'
import deleteImg from '../assets/img/delete.png'
import BlogItem from './BlogItem.vue'
import Clock from 'vue-clock2'

export default {
  components: { RealLikeBtn, BlogItem, Clock },
  data() {
    return {
      optImg: [addImg, deleteImg],
    }
  },
  methods: {
    print(item) {
      console.log(item)
    },
  },
  mounted() {
    window.WIDGET = {
      CONFIG: {
        layout: 2,
        width: '270',
        height: '250',
        background: 1,
        dataColor: 'FFFFFF',
        aqiColor: 'FFFFFF',
        borderRadius: '10',
        key: 'DjcGLNk1DS',
      },
    }
    var script = document.createElement('script')
    script.type = 'text/javascript'
    script.src =
      'https://apip.weatherdt.com/standard/static/js/weather-standard-common.js?v=2.0'
    document.getElementsByTagName('head')[0].appendChild(script)
  },
}
</script>

<style lang="scss" scoped>
.real-btn {
  margin: 0px 5px;
}
.icon {
  font-size: 24px;
  color: #f39c12;
}
.mode {
  position: absolute;
  right: 30px;
  // background: red;
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
  // background: red;
  flex: 3;
  padding: 10px;
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
  // background: gold;
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
  // background: red;
  flex: 2;
}

.tool-card {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  margin-bottom: 10px;
  height: 50px;
  width: 100%;
}

.opt {
  width: 100%;
  height: 60px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  // background: gold;
  padding: 5px 0px;
  margin-bottom: 10px;
}

</style>
