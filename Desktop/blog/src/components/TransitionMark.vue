<template>
  <div class="transition-mark">
    <div class="pic-mark">
      <img src="../assets/img/avatar.jpg" width="200px" height="200px" />
    </div>
    <div class="top-mark"></div>
    <div class="bottom-mark"></div>
  </div>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
// 页面过度效果
.pic-mark {
  position: fixed;
  width: 200px;
  height: 200px;
  background: red;
  top: 30%;
  left: 50%;
  margin-left: -100px;
  z-index: 10;
  border-radius: 50%;
  overflow: hidden;
  opacity: 0;
  animation: avatar 3s linear 1;
}
.bottom-mark {
  width: 100%;
  height: 0vh;
  position: fixed;
  left: 0;
  bottom: 0;
  background: gold;
  z-index: 9;
  animation: topAndBottom  3s linear 1;
 }
.top-mark {
  width: 100%;
  height: 0vh;
  position: fixed;
  top: 0;
  left: 0;
  background: goldenrod;
  z-index: 9;
  animation: topAndBottom  3s linear 1;

}
@keyframes topAndBottom{
    0%{
        height: 0vh;
    }
    45%{
        height:50vh;
    }
    55%{
        height:50vh;
    }
    100%{
        height:0vh;
    }
}
@keyframes avatar{
    0%{
        transform: rotate(0deg);
    }
    45%{
        transform: rotate(360deg);
        opacity: 1;
    }
    55%{
        transform: rotate(360deg);
        opacity: 1;
    }
    100%{
        opacity: 0;
        transform: rotate(0deg);
    }
}
</style>
