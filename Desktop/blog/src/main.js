import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import '../global/global.css'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import LetItSnow from 'vue-let-it-snow';
Vue.use(LetItSnow);

import VueParticles from 'vue-particles'
Vue.use(VueParticles)  

Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
