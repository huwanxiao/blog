<template>
  <div class="commentList">
    <!-- 一级评论 -->
    <div class="first-level" v-for="(item, index) in commentList" :key="index">
      <div class="avatar">
        <img
          :src="item.from && item.from.avatarUrl"
          alt="来源头像"
          width="40"
          height="40"
        />
      </div>
      <div class="info">
        <div class="nick-and-time">
          <div class="nick">{{ item.from && item.from.name }}</div>
          <i class="iconfont icon-arrow_right_fat"></i>
          <img
            :src="item.to && item.to.avatarUrl"
            alt="目标头像"
            width="40"
            height="40"
          />
          <div class="nick">{{ item.to && item.to.name }}</div>
          <div class="pub-time" style="font-size: 10px">
            {{
              item.from &&
              $moment(item.from.gmtCreate).format('YYYY年MM月DD日 hh:mm:ss')
            }}
          </div>
        </div>
        <div class="content">{{ item && item.content }}</div>
        <div class="meta">
          <div class="like option">
            <i class="iconfont icon-xihuan"></i>
            <span>{{ item && item.likeCount }}</span>
          </div>
          <div class="comment option">
            <i class="iconfont icon-comment"></i>
            <span>{{ item && item.commentCount }}</span>
            <label for="firstLevel" style="color: #ccc; margin-left: 10px">
              回复</label
            >
            <span style="color: #ccc; margin-left: 10px" @click="foldOpt(item)">
              展开</span
            >
          </div>
        </div>
        <el-divider></el-divider>
        <!-- 二级评论 -->
        <div
          class="second-level"
          v-for="(item2, index2) in item.children"
          :key="index2"
          v-show="item.isFold"
        >
          <div class="avatar">
            <img
              :src="item2.from && item2.from.avatarUrl"
              alt="来源头像"
              width="40"
              height="40"
            />
          </div>
          <div class="info">
            <div class="nick-and-time">
              <div class="nick">{{ item2.from && item2.from.name }}</div>
              <i class="iconfont icon-arrow_right_fat"></i>
              <img
                :src="item2.to && item2.to.avatarUrl"
                alt="目标头像"
                width="40"
                height="40"
              />
              <div>{{ item2.to && item2.to.name }}</div>
              <div class="pub-time" style="font-size: 10px">
                {{
                  item2.to &&
                  $moment(item2.to.gmtCreate).format('YYYY年MM月DD日 hh:mm:ss')
                }}
              </div>
            </div>
            <div class="content">{{ item2 && item2.content }}</div>
            <div class="meta">
              <div class="like option">
                <i class="iconfont icon-xihuan"></i>
                <span>{{ item2 && item2.likeCount }}</span>
              </div>
              <div class="comment option">
                <i
                  class="iconfont icon-comment"
                  @click="isReply = !isReply"
                ></i>
                <span>{{ item2.contentCount }}</span>
                <span
                  style="color: #ccc; margin-left: 10px"
                  @click="reply(item)"
                  >回复</span
                >
              </div>
            </div>
            <el-divider></el-divider>
            <el-row class="second-reply">
              <el-col :span="1" v-show="isReply">
                <img
                  v-show="isLogin"
                  :src="userInfo.avatarUrl"
                  alt="头像"
                  width="40px"
                  height="40px"
                />
              </el-col>
              <el-col :span="23">
                <el-input
                  :placeholder="replyWho"
                  style="margin-top: 0px; margin-bottom: 20px"
                  v-show="isReply"
                  v-model="content2"
                ></el-input>
              </el-col>
            </el-row>
          </div>
        </div>
      </div>
    </div>
    <el-divider></el-divider>
    <el-row class="first-reply">
      <el-col :span="1">
        <img
          v-show="isLogin"
          :src="userInfo.avatarUrl"
          alt="头像"
          width="40px"
          height="40px"
        />
        <img
          v-show="!isLogin"
          src="../assets/img/default-avatar.png"
          alt="默认头像"
          width="40px"
          height="40px"
        />
      </el-col>
      <el-col :span="23">
        <el-input
          type="textarea"
          :autosize="{ minRows: 5, maxRows: 10 }"
          placeholder="请输入内容"
          v-model="content1"
          @keyup.enter.native="sendFirstComment()"
          id="firstLevel"
        >
        </el-input>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      commentList: [],
      isReply: false,
      isLogin: false,
      isFold: false,
      userId: '',
      passageId: '',
      secondLevel: '',
      content1: '',
      content2: '',
      replyWho: '点击回复选择您要回复的人',
      token: '',
      userInfo: this.$store.state.userInfo,
    }
  },
  created() {
    //拿到文章的id
    this.passageId = this.$route.query.id
    //拿到评论
    this.getCommentListById()
    // console.log('passageId', this.passageId)
  },
  mounted() {
    //拿到登陆用户的token值
    let _token = null
    _token = window.sessionStorage.getItem('UserToken')
    this.token = _token
    console.log(_token)
    if (_token !== null) {
      // console.log("error");
      this.isLogin = true
      //根据id获取评论列表
      this.getUserInfo(_token)
    }
  },
  methods: {
    async getUserInfo(token) {
      const result = await this.$http.get('getUserByToken/' + token)
      console.log('获取用户的信息', result.data.data)
      this.$store.commit('setUserInfo', result.data.data)
      this.userId = result.data.data.id
      console.log('userId', this.userId)
    },
    async sendFirstComment() {
      if (this.token == null) {
        alert('您还未登陆')
        return
      } else if (this.content1 == '') {
        alert('输入内容不能为空')
        return
      }
      console.log('正在发送一级评论......')
      await this.$http.post('insertFirstComment', this.firstLevelRef)
      this.getCommentListById()
      console.log('重新拉取信息成功', this.commentList)
    },
    async sendSecondComment() {
      let result = this.$http.post('insertSecondComment', this.secondLevelRef)
      console.log('重新拉取信息')
    },
    async getCommentListById() {
      let result = await this.$http.get('getCommentListById/' + this.passageId)
      //给每一个comment添加fold字段
      this.commentList = result.data.data.map((item) => {
        return {
          ...item,
          isFold: false,
        }
      })
      console.log('commentList', this.commentList)
    },
    reply(item) {
      this.isReply = !this.isReply
      this.replyWho = '@' + item.from.name
    },
    foldOpt(item) {
      console.log(111)
      item.isFold = !item.isFold
    },
    scrollToBottom() {
      var currentPosition, timer
      function GoBottom() {
        timer = setInterval('runToBottom()', 50)
      }
      function runToBottom() {
        currentPosition =
          document.documentElement.scrollTop || document.body.scrollTop
        currentPosition += 30
        if (
          currentPosition < document.body.scrollHeight &&
          document.body.clientHeight + document.body.scrollTop <
            document.body.scrollHeight
        ) {
          document.body.scrollTop = currentPosition
        } else {
          document.body.scrollTop = document.body.scrollHeight
          clearInterval(timer)
        }
      }
    },
  },
  computed: {
    firstLevelRef() {
      return {
        //一级评论的内容
        content: this.content1,
        //一级评论评论的文章id
        parentId: this.passageId, //this.passageId
        //是对文章进行的评论
        type: 1,
        //评论的人是谁
        fromId: this.userId,
        //这里的场景只能发给博主。博主的信息固定。将第一条数据设置为博主信息。
        toId: 5,
      }
    },
    secondLevelRef() {
      return {
        //二级评论的内容
        content: this.content2,
        //二级评论的id。parent为focus时传进来的
        parentId: '',
        //是对评论进行的评论
        type: 2,
        //评论的人是谁
        fromId: this.userId,
      }
    },
  },
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
  position: relative;
  display: flex;
  // flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  font-size: 14px;
  color: #ff7675;
  margin-bottom: 5px;
  // flex-wrap: nowrap;
}

.commentList img {
  border-radius: 50%;
}

.pub-time {
  position: absolute;
  right: 10px;
}
</style>