<template>
  <div id="app">
    <!-- <transition-mark v-show="showTransition" /> -->
    <transition name="fade">
      <router-view />
    </transition>
  </div>
</template>
<script>
import TransitionMark from './components/TransitionMark.vue'
export default {
  components: { TransitionMark },
  data() {
    return {
      synchro: 0, //同步器
    }
  },
  mounted() {},
  methods: {},
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
  transition: opacity 4s ease-in-out;
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
