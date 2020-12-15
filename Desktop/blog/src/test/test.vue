<template>
  <div class="test">
    {{passage[0]}}
    
  </div>
</template>

<script>

export default {
  components: {},
  mounted() {
    // let pass = JSON.stringify(passage)
    // console.log(pass.p1)
  },
  data() {
    return {
      passage:this.$store.getters.getPassageInfo
    }
  },
  methods: {},
  computed: {},
}
</script>

<style lang="scss" scoped>
</style>>