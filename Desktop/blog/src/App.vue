<template>
  <div id="app">
    <wave/>
    <transition name="fade">
      <router-view />
    </transition>
  </div>
</template>
<script>
import Wave from './components/Wave.vue'
export default {
  components: { Wave },
  data() {
    return {
      synchro: 0, //同步器
    }
  },
  mounted() {
    this.getAllPassage()
  },
  methods: {
    async getAllPassage() {
      const result = await this.$http.get('getAllPassage')
      const data = result.data.data
      this.$store.commit("setPassageInfo",data)
      console.log("收到所有的文章:",data);
    },
  },
  computed: {
    transitionWaveActive() {
      return this.$store.getters.getTransitionWave
    },
  },
}
</script>
<style>

</style>
<style lang="scss">


.fade-enter-active,
.fade-leave-active {
  transition: opacity 2s ease-in-out;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}

html,
body,
#app {
  height: 100%;
  width: 100%;
}
</style>
