<template>
  <div class="big-btn">
    <div class="label-box" style="padding-left: 30px">
      <span
        v-for="(item, index) in selectCondition"
        :key="index"
        class="my-label"
        @click="selectChange(index)"
        :class="[index == idx ? 'my-label-active' : '']"
        >{{ item }}</span
      >
    </div>

    <el-input
      prefix-icon="icon el-icon-search"
      v-model="keyword"
      BigBtn="big"
      @focus="handleForce"
      @blur="handleBlur"
      @keyup.enter.native="toResult"
    ></el-input>

    <div class="drop-select" v-show="isDropSelectShow">
      <div class="search-guess" @click="log">如何学好vue</div>
      <div class="search-guess" @click="log">如何学好vue</div>
      <div class="search-guess" @click="log">如何学好vue</div>
      <div class="search-guess" @click="log">如何学好vue</div>
      <div class="search-guess" @click="log">如何学好vue</div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      keyword: '',
      idx:-1,
      selectCondition: ['标题','关键字','标签'],
      isDropSelectShow: false,
    }
  },
  methods: {
    selectChange(index) {
      this.idx = index
    },
    handleInput() {},
    handleForce() {
      this.isDropSelectShow = true
    },
    handleBlur() {
      this.isDropSelectShow = false
    },
    log() {
      console.log('vue')
    },
    toResult() {
      this.$router.push({ path: '/result', query:{ index:this.idx, word:this.keyword} })
    }
  }
}
</script>

<style lang="scss" scoped>
.search-guess {
  width: 100%;
  height: 50px;
  border-bottom: 2px solid rgb(243, 239, 239, 0.4);
  display: flex;
  justify-content: flex-start;
  align-items: center;
}
.icon {
  color: #f56c6c;
}
.big-btn {
  position: relative;
}
.lable-box {
  position: relative;
  margin-left: 20px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}
.my-label {
  border-top: 2px solid #f56c6c;
  border-left: 2px solid #f56c6c;
  border-right: 2px solid #f56c6c;
  margin-right: 10px;
  display: inline-block;
  height: 30px;
  width: 60px;
  text-align: center;
  border-radius: 5px 5px 0 0;
  color: #fd79a8;
}

// .my-label:hover {
//   background: #5891e3;
//   color: #fff;
// }
.my-label-active {
  background: #f56c6c;
  color: #fff;
}

.drop-select {
  position: relative;
  top: -18px;
  width: 1000px;
  height: 280px;
  border-bottom: 2px solid #f56c6c;
  border-left: 2px solid #f56c6c;
  border-right: 2px solid #f56c6c;
  background: rgba(2555, 255, 255, 0);
  border-radius: 0 0 10px 10px;
  padding: 20px;
}
</style>
