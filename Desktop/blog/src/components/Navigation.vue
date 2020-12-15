<template>
  <div class="nav">
    <div class="top">
      <div
        class="title-box"
        v-for="(item, index) in nav"
        :key="index"
        @mouseover="show(index)"
        @mouseout="hide"
      >
        <router-link :to="item.link" tag="div">{{ item.title }}</router-link>
      </div>
    </div>
    <div class="bottom" v-show="isButtomShow">
      <div class="detail-box" v-for="(item, index) in nav" :key="index" :class="[index == titleIndex?'':'detail-box-hide']">
        <span v-for="(item2, index2) in item.detail" :key="index2">
          <router-link :to="item.sublink[index2]" tag="span">{{ item2 }}</router-link>
        </span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      nav: [
        { title: '主页', detail: [], link: '/index', sublink: [] },
        {
          title: '登陆',
          detail: ['游客', '作者'],
          link: '/login',
          sublink: ['/login/visitor', '/login/author'],
        },
        { title: '定制', detail: [], link: '/config', sublink: [] },
      ],
      titleIndex: -1,
      isDrop: false,
      leftPos: -1,
      isButtomShow:false
    }
  },
  methods: {
    show(index) {
      this.titleIndex = index
      this.isButtomShow = true
    },
    hide() {
      let _this = this
      setTimeout(() => {
        this.titleIndex = -1
      },3000)
      
    },
  },
}
</script>

<style lang="scss" scoped>
.nav {
  display: flex;
  justify-content: space-between;
  flex-direction: column;
  align-items: center;
  //   border: 1px solid red;
  width: 200px;
  font-size: 16px;
  color: #f39c12;
}
.nav-font-orange {
  color: #f39c12;
}
.nav-font-blue {
  color: #5891e3;
}
.top {
  display: flex;
  justify-content: space-around;
  width: 100%;
  height: 35px;
  align-items: center;
  //   border: 1px solid red;
}

.title-box:hover {
  border-bottom: 2px solid  #f39c12;
}
.title-box {
  border-bottom: 2px solid  #fff;
}
.bottom {
  display: flex;
  justify-content: space-around;
  align-items: flex-start;
  width: 100%;
  height: 100%;
  position: relative;
  // border: 1px solid red;
}
.detail-box {
  display: flex;
  justify-content: space-around;
  align-items: center;
  height: 70px;
  flex-direction: column;
  position: absolute;
}

.detail-box-hide {
  display: none;
}
</style>

linear-gradient(90deg,#03a9f4,#f441a5,#ffeb3b,#03a9f4);