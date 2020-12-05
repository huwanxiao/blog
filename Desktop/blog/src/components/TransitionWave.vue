<template>
  <div class="transition-wave" >
    <div class="box" :class="{'box-active':transitionWaveActive}"></div>
  </div>
</template>

<script>
export default {
  data(){
    return {
      
    }
  },
  computed:{
     transitionWaveActive(){
       return this.$store.getters.getTransitionWave
     }
  }
}
</script>

<style lang="scss" scoped>
.transition-wave {
   width: 100vh;
   height: 100vh;
   position: absolute;
   z-index: 10;
}
.box {
  position: absolute;
  z-index: 10;
  height: 0vh;
  width: 100%;
  bottom: 0px;
  background: linear-gradient(to bottom, #7abcff 0%, #00bcd4 44%, #2196f3);
}



.box-active{
  animation: upAndDown 2s linear 1;
}
@keyframes upAndDown {
    0%{
       height: 0vh;
    }
    50%{
        height: 100vh;
    }
    60%{
        height: 100vh;
    }
    100%{
       height: 0vh;
    }
}
.transition-wave{
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
}
</style>