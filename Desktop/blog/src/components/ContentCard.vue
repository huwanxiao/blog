<template>
  <div class="content_box">
    <transition-mark/>
    <div class="title">{{page.title}}</div>
    <div class="content">{{page.content}}</div>
    <comment-list/>
  </div>
</template>

<script>
import CommentList from './CommentList'
import TransitionMark from './TransitionMark.vue'
export default {
  components: { CommentList,TransitionMark },
  data() {
    return {
      isShowBg: false,
      page: {
        title: 'vue入门教程',
        content: '是什么 为什么 怎么做',
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
    }
  },
}
</script>

<style lang="scss" scoped>
.content_box {
  position: relative;
  top: 100px;
  width: 99%;
  max-height: 150vh;
  margin: 0px auto;
  background: rgba(255, 255, 255, 0.9);
  border-radius: 20px;
  padding: 20px;
}
.content_box > .title {
  display: flex;
  justify-content: flex-start;
  align-items: center;
   margin-bottom:10px ;
   size: 28px;
   padding-left: 5px;
   border-left: 5px solid rgb(243, 156, 18);
}

.content_box > .content {
  margin: 20px;
}
</style>