import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    transitionWaveActive:true
  },
  getters: {
    getTransitionWave(state) {
      return state.transitionWaveActive
    },
  },
  mutations: {
    setTransitionWave(state, states) {
      state.transitionWaveActive = states
    },
  }
});
