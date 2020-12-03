import Vue from 'vue'
import VueRouter from 'vue-router'
import Cover from '../page/cover.vue'
import Index from '../page/index.vue'
import Test from '../test/test.vue'
import Login from '../page/login.vue'
import AuthorLogin from '../page/authorLogin.vue'
import VisitorLogin from '../page/visitorLogin.vue'
import BlogContent from '../page/blogContent.vue'
import Config from '../page/config.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'cover',
    component: Cover
  },
  {
    path: '/index',
    name: 'index',
    component: Index
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    children: [
      {
        path: 'author',
        name: 'AuthorLogin',
        component: AuthorLogin
      },
      {
        path: 'visitor',
        name: 'VisitorLogin',
        component: VisitorLogin
      }
    ]
  },
  {
    path: '/content',
    name: 'BlogContent',
    component: BlogContent
  },
  {
    path: '/config',
    name: 'Config',
    component: Config
  },
  {
    path: '/test',
    name: 'test',
    component: Test
  }
]

const router = new VueRouter({
  routes
})

export default router
