<template>
  <div class="content_box">
    <h2 class="title">{{ currentPassage.title }}</h2>
    <article class="content for-img" v-html="currentPassage.htmlContent"></article>
    <comment-list />
  </div>
</template>

<script>
import CommentList from './CommentList'
import MarkDownIt from 'markdown-it'
export default {
  components: { CommentList },
  data() {
    return {
      isShowBg: false,
      currentPassage:[],
    }
  },
  mounted() {
    //获取文章的id
    let id = this.$route.query.id
    // console.log(id);
    this.getPassageById(id)
  },
  methods:{
    async getPassageById(id) {
      const result = await this.$http.get('getPassageById/'+id)
      if (result.data.code == 200) {
        this.currentPassage = result.data.data
        return this.$message.success("获取成功")
      }
      this.$message.error("获取失败")
    },
  },

}
</script>

<style lang="scss" scoped>
.content_box {
  position: relative;
  top: 80px;
  width: 95%;
  // height: 100px;
  left: 40px;
  background: rgba(255, 255, 255, 0.9);
  border-radius: 20px;
  padding: 20px;
  margin-bottom: 80px;
}
.content_box > .title {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  margin-bottom: 10px;
  size: 28px;
  padding-left: 5px;
  border-left: 5px solid rgb(243, 156, 18);
}

.content_box > .content {
  margin: 20px;
}
img{
  width: 95%;
}
.content{
  width: 95%;
  height: 100%;
  position: relative;
}
</style>

      page: {
        title: 'vue入门教程',
        content: '**是什么** **为什么** **怎么做**',
        Comment: [
          {
            content: '一级评论',
            author: 'hwx',
            children: [
              {
                to: 'hwx',
                content: '二级评论',
              },
            ],
          },
        ],
      },