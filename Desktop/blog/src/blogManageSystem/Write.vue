<template>
  <div class="write">
      <el-row class="title mar">
         <label for="title">文章标题:</label>
        <el-col><el-input id="title" v-model="passageRef.title"/></el-col>
      </el-row>
      <v-md-editor height="400px" class="mar" v-model="passageRef.content"></v-md-editor>
      <el-row class="desc mar">
         <label for="desc">简介:</label>
        <el-col><el-input id="desc" v-model="passageRef.desc"/></el-col>
      </el-row>
      <el-row class="desc mar">
        <label for="tag">标签(以逗号分隔):</label>
        <el-col><el-input id="tag" v-model="passageRef.tag"/></el-col>
      </el-row>
      <el-button @click="submit" style="float:rignt;margin-right:10px" type="primary">提交</el-button>
  </div>
</template>

<script>
import showdown from "showdown"
export default {
  data() {
    return {
      passageRef:{
        title:'',
        content:'',
        htmlContent:'',
        desc:'',
        tag:'',
      },
      text:'',
    }
  },
  methods:{
    submit() {
      let converter = new showdown.Converter();
      this.passageRef.htmlContent = converter.makeHtml(this.passageRef.content);
      this.postPassageList()
      console.log(this.passageRef);
    },
    async postPassageList() {
      const result = await this.$http.post('addPassage',this.passageRef)
      if (result.data.code == 200) {
        this.$store.commit('addNewPassage',result.data.data)
        console.log("postPassageList",result.data.data)
        return this.$message.success("添加成功")
      }
      this.$message.error("添加失败")
    },
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
 .mar {
   margin-bottom: 10px;
 }
</style>