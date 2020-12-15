import Vue from 'vue'
import VueRouter from 'vue-router'
import Cover from '../page/cover.vue'
import Index from '../page/index.vue'
import Test from '../test/test.vue'
import Login from '../page/login.vue'
import AuthorLogin from '../page/authorLogin.vue'
import VisitorLogin from '../page/visitorLogin.vue'
import BlogContent from '../page/blogContent.vue'
import GuessYouLike from '../page/guess.vue'
import Config from '../page/config.vue'
import SearchResult from '../page/searchResult.vue'
import Manage from '../blogManageSystem/Manage.vue'
import Welcome from '../blogManageSystem/Welcome.vue'
import Write from '../blogManageSystem/Write.vue'
import Update from '../blogManageSystem/Update.vue'

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
    component: Login
  },
  {
    path: '/login/author',
    name: 'AuthorLogin',
    component: AuthorLogin
  },
  {
    path: '/login/visitor',
    name: 'VisitorLogin',
    component: VisitorLogin
  },
  {
    path: '/guess',
    name: 'GuessYouLike',
    component: GuessYouLike
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
  },
  {
    path: '/result',
    name: 'SearchResult',
    component: SearchResult
  },
  {
    path: '/manage',
    name: 'Manage',
    component: Manage,
    redirect:'/welcome',
    children: [
      {
        path: '/manage/write',
        name: 'Write',
        component: Write
      },
      {
        path: '/manage/update',
        name: 'Update',
        component: Update
      },
      {
        path: '/manage/welcome',
        name: 'Welcome',
        component: Welcome
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
