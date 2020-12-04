<template>
  <div class="scope">
    <slot :user="user"></slot>
    <slot name="accounts" :account="account"></slot>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        name: 'hwx',
        age: 20,
      },
      account: {
        ac: 123456,
        pwd: 123456,
      },
    }
  },
}
</script>

<style lang="scss" scoped>
</style>