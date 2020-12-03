<template>
  <div class="page-index">
    <!-- 联系方式按钮组件 -->
    <contact-group class="contactBtn"></contact-group>
    <!-- 导航栏 -->
    <navigation class="nav"></navigation>
    <!-- 小狗 -->
    <transition name="dog">
      <dog class="little-dog" v-show="dogShow" />
    </transition>
    <!-- 封面标题 -->
    <router-link to="/index" tag="div"
      ><h2 class="title">欢迎来到胡万晓、陈奕州的个人博客</h2></router-link>
    <!-- 图片效果 -->
    <section class="pic-clip"></section>
    <!-- 剪切蒙版 -->
    <div class="container">
      <section class="sec">
        <div class="content">
          <h2>成长</h2>
          <p>有些改变只需要一秒</p>
        </div>
      </section>
      <section class="sec">
        <div class="content">
          <h2>积累</h2>
          <p>有些改变需要走过四季</p>
        </div>
      </section>
      <section class="sec">
        <div class="content">
          <h2>独立</h2>
          <p>愿你走出四季</p>
        </div>
      </section>
      <section class="sec">
        <div class="content">
          <h2>盛放</h2>
          <p>归来仍是少年</p>
        </div>
      </section>
    </div>
    <!-- 跳转下一页的区域 -->
    <div class="bottom">
      <color-wave></color-wave>
    </div>
  </div>
</template>

<script>
import ContactGroup from '../components/ContactGroup.vue'
import ColorWave from '../components/ColorWave'
import Dog from '../components/Dog'
import Navigation from '../components/Navigation.vue'
export default {
  components: {
    ContactGroup,
    ColorWave,
    Dog,
    Navigation,
  },
  data() {
    return {
      dogShow: false,
    }
  },
  mounted() {
    this.dogShow = true
    let section = document.querySelector('section')
    window.addEventListener('scroll', function () {
      let value = window.scrollY
      section.style.clipPath = `circle(${value}px at center)`
    })
  },
  methods: {},
}
</script>

<style lang="scss" scoped>
.nav{
  position: fixed;
  right: 20px;
  top: 20px;
  z-index: 100;
}

.little-dog {
  top: 270px;
  left: 790px;
  position: absolute;
}

.dog-enter-active,
.dog-leave-active {
  transition: opacity 5s ease-in-out;
  transition-delay: 3s;
}
.dog-enter, .dog-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}

.bottom {
  position: relative;
  z-index: 2;
  width: 100%;
  height: 80px;
  bottom: 0;
}

.pic-clip {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background: url(../assets/img/cover-bg.jpg);
  background-size: 100%;
  background-attachment: fixed;
  clip-path: circle(0px at center);
}
.container {
  position: relative;
  margin-top: 200vh;
}

.title {
  position: absolute;
  top: 220px;
  left: 21%;
  z-index: 20;
  font-size: 3em;
  font-family: myFirstFont;
  text-align: center;
}

.contactBtn {
  position: fixed;
  left: 20px;
  top: 20px;
  z-index: 100;
}

.sec {
  position: relative;
  width: 100%;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 50px 0;
  background: #fff;
}
.sec .content {
  text-align: center;
  color: #000;
}

.sec .content h2 {
  font-size: 20vw;
  font-weight: 700;
  background-attachment: fixed;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

section:nth-child(1) .content h2 {
  background-image: url(../assets/img/cutfont-bg1.jpg);
}
section:nth-child(2) .content h2 {
  background-image: url(../assets/img/cutfont-bg2.jpg);
}
section:nth-child(3) .content h2 {
  background-image: url(../assets/img/cutfont-bg3.jpg);
}
section:nth-child(4) .content h2 {
  background-image: url(../assets/img/cutfont-bg4.jpg);
}

section .content p {
  max-width: 800px;
  margin: 0 auto;
  padding: 0 20px;
  font-size: 4vw;
  font-weight: 300;
}
</style>