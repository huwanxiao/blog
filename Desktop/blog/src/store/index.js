import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    passageInfo:[],
    searchResult:[],
    currentPassage:{},
    visitorToken:'',
    userInfo:{},
  },
  getters: {
  
  },
  mutations: {
    setPassageInfo(state, msgs) {
      state.passageInfo = msgs
    },
    addNewPassage(state, msg) {
      state.passageInfo.push(msg)
    },
    setUserInfo(state, msg) {
      state.userInfo = msg
    }
  }
});
