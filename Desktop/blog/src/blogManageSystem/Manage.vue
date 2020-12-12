<template>
  <div style="height: 100%">
    <el-container class="manage-container">
      <el-header>
        <div>
          <img
            src="../assets/img/avatar.jpg"
            width="45px"
            height="45px"
            style="border-radius: 50%"
          />
          <span>博客管理系统</span>
        </div>
        <el-button type="info" @click="logout">退出</el-button>
      </el-header>
      <el-container>
        <el-aside :width="isCollapse ? '60px' : '200px'">
          <!-- 切换侧边栏的按钮 -->
          <div class="toggle-button" @click="toggleCollapse">|||</div>
          <!-- 菜单区域 -->
          <el-menu
            unique-opened
            router
            :collapse="isCollapse"
            :collapse-transition="false"
            class="el-menu-vertical-demo"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            :default-active="activePath"
          >
            <!-- 一级菜单 -->
            <el-menu-item
              v-for="item in menulist"
              :key="item.id"
              :index="item.addr"
            >
              <template slot="title">
                <i :class="item.icon"></i>
                <span>{{ item.authName }}</span>
              </template>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
export default {
  name: 'home',
  data() {
    return {
      //是否折叠
      isCollapse: false,
      //菜单数据
      menulist: [
        {id:0,icon:'iconfont icon-gangbi',authName:'写文章',addr:'/manage/write'},
        {id:1,icon:'iconfont icon-gengxin',authName:'更新文章',addr:'/manage/update'},
        
      ],
      activePath: '/users',
    }
  },
  created() {
    // this.getMenuList()
    this.activePath = window.sessionStorage.getItem('activePath')
  },
  methods: {
    // 点击切换侧边栏状态
    toggleCollapse() {
      this.isCollapse = !this.isCollapse
    },
    //退出登录
    logout() {
      window.sessionStorage.clear()
      this.$router.push('/login')
    },
    //读取菜单
    async getMenuList() {
      const { data: res } = await this.$http.get('menus')
      if (res.meta.status != 200) return this.$message.error(res.meta.msg)
      this.menulist = res.data
      console.log(res)
    },
    //保存当前激活连接
    saveNavState(activePath) {
      window.sessionStorage.setItem('activePath', activePath)
      this.activePath = activePath
    },
  },
}
</script>
<style lang="less" scoped>
.manage-container {
  height: 100%;
}
.el-header {
  display: flex;
  justify-content: space-between;
  background-color: #373d37;
  padding-left: 0;
  color: #fff;
  font-size: 20px;
  > div {
    display: flex;
    align-items: center;
    span {
      margin-left: 15px;
    }
  }
}
.el-aside {
  background-color: #373743;
  overflow: hidden;
  .el-menu {
    border-right: none;
  }
}
.el-main {
  background-color: #fff;
}
.toggle-button {
  background: #4a5064;
  font-size: 10px;
  line-height: 24px;
  color: #fff;
  text-align: center;
  cursor: pointer;
  letter-spacing: 0.3em;
}
</style>
