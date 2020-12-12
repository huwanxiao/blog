<template>
  <div class="write">
      <input placeholder="输入文章标题" v-model="title">
      <v-md-editor v-model="text" height="400px"></v-md-editor>
  </div>
</template>

<script>
export default {
  data() {
    return {
      text:'',
      title:'',
    }
  }
}
</script>

<style lang="scss" scope>
 input {
   width: 100%;
   height: 60px;
   outline: none;
   border: none;
   line-height: 60px;
 }
</style>