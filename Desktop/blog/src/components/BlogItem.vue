<template>
  <div class="blog-item">
    <h2 class="title" @click="toContent(item.id)">{{item.title}}</h2>
    <div class="abstract">{{item.desc}}</div>
    <div class="meta">
      <div class="like option">
        <i class="iconfont icon-xihuan"></i>
        <span>{{item.likeCount}}</span>
      </div>
      <div class="comment option">
        <i class="iconfont icon-comment"></i>
        <span>{{item.commentCount}}</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props:['item'],
  methods:{
    toContent(id){
      this.$router.push({ path: '/content', query:{ id:id}})
    },
    
  }
}
</script>

<style lang="scss" scoped>
.blog-item {
  width: 100%;
  padding: 10px 0px;
  border-bottom: 1px solid #ccc;
  margin-bottom: 10px;
  border-radius: 20px;
  border: 2px solid #5891e3;
  padding: 20px;
}
.meta {
  display: flex;
  justify-content: flex-start;
  align-items: center;

}
.title,
.abstract {
  margin-bottom: 10px;
}
.abstract {
  size: 22pt;
  font-family: myFirstFont;
  font-weight: 500;
  max-height: 60px;
}
.option{
  margin-right: 10px;
}
</style>