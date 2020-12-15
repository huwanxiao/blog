<template>
  <div class="commentList">
    <!-- 一级评论 -->
    <div class="first-level">
      <div class="avatar">
        <img src="../assets/img/avatar.jpg" alt="头像" width="40" height="40" />
      </div>
      <div class="info">
        <div class="nick-and-time">
          <div class="nick">小胡</div>
          <i class="iconfont icon-arrow_right_fat" v-show="false"></i
          ><span></span>
          <div class="pub-time" style="font-size: 10px">发布于2020</div>
        </div>
        <div class="content">真不错</div>
        <div class="meta">
          <div class="like option">
            <i class="iconfont icon-xihuan"></i>
            <span>33</span>
          </div>
          <div class="comment option">
            <i class="iconfont icon-comment"></i>
            <span>333</span>
            <span style="color: #ccc">  回复</span>
          </div>
        </div>
        <el-divider></el-divider>
        <!-- 二级评论 -->
        <div class="second-level">
          <div class="avatar">
            <img src="../assets/img/avatar.jpg" alt="" width="40" height="40" />
          </div>
          <div class="info">
            <div class="nick-and-time">
              <div>
                <span class="nick">小胡</span
                ><i class="iconfont icon-arrow_right_fat"></i><span>小明</span>
              </div>
              <div class="pub-time" style="font-size: 10px">发布于2020</div>
            </div>
            <div class="content">真不错</div>
            <div class="meta">
              <div class="like option">
                <i class="iconfont icon-xihuan"></i>
                <span>33</span>
              </div>
              <div class="comment option">
                <i class="iconfont icon-comment"></i>
                <span>333</span>
                <span style="color: #ccc" @click="isReply = !isReply"> 回复</span>
              </div>
            </div>
            <el-input placeholder="请输入评论内容" style="margin-top:20px" v-show="isReply"></el-input>
          </div>
        </div>
        <el-divider></el-divider>
        <el-row>
          <el-col :span="1">
            <img src="../assets/img/avatar.jpg" alt="头像" width="40px" height="40px">
          </el-col>
          <el-col :span="23">
            <el-input
              type="textarea"
              :autosize="{ minRows: 5, maxRows: 10}"
              placeholder="请输入内容"
              v-model="textarea"
            >
            </el-input>
          </el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      textarea:'',
      isReply:false,
      isLogin:false,
      token:'',
    }
  },
  mounted() {
    //拿到当前用户的token值
    this.token = window.sessionStorage.getItem("token")
    if(this.token !== ''){
      this.getUserInfo()
    }else{
      return this.$message.error("处于未登录状态")
    }
  },
  methods:{
    //获取游客的信息
    async getUserInfo() {
       const result = await this.$http.get('/getUserByToken/'+this.token)
       
    }
  }
}
</script>

<style lang="scss" scoped>
.content {
  margin-bottom: 5px;
}
.option {
  margin-right: 10px;
}
.first-level,
.second-level {
  display: flex;
  flex: 1;
  margin-right: 10px;
}
.first-level > .avatar,
.second-level > .avatar {
  width: 40px;
  height: 40px;
  margin-right: 10px;
  display: flex;
  justify-content: flex-start;
}

.info {
  display: flex;
  flex: 8;
  flex-wrap: wrap;
  flex-direction: column;
}

.meta {
  display: flex;
  justify-content: flex-start;
  align-items: center;
}

.nick-and-time {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  font-size: 14px;
  color: #ff7675;
  margin-bottom: 5px;
}
</style>