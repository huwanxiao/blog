<template>
  <div class="test">
    <comment-list/>
  </div>
</template>

<script>
import CommentList from '../components/CommentList'
export default {
  components:{
    CommentList
  },
  mounted() {},
  data() {
    return {
 
    }
  },
  methods: {},
  computed: {},
}
</script>

<style lang="scss" scoped>
.test{
  position: relative;
}
.star{
  width: 100vw;
  height: 100vh;
  background-attachment: fixed;
}
</style>>