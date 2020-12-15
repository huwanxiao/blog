import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import '../global/global.css'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';


//markdown
import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
VueMarkdownEditor.use(vuepressTheme);
Vue.use(VueMarkdownEditor);

//axios
import axios from 'axios'

// Vue.prototype.qs = qs
axios.defaults.baseURL = 'http://localhost:3000/'
Vue.prototype.$http = axios
axios.defaults.withCredentials = true    


import VueParticles from 'vue-particles'
Vue.use(VueParticles)  

Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
