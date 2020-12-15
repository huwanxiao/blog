<template>
  <div class="login_container">
    <div class="slideshow">
      <div
        class="slideshow-image"
        :style="{
          backgroundImage: 'url(' + require('../assets/img/1.jpg') + ')',
        }"
      ></div>
      <div
        class="slideshow-image"
        :style="{
          backgroundImage: 'url(' + require('../assets/img/2.jpg') + ')',
        }"
      ></div>
      <div
        class="slideshow-image"
        :style="{
          backgroundImage: 'url(' + require('../assets/img/3.jpg') + ')',
        }"
      ></div>
      <div
        class="slideshow-image"
        :style="{
          backgroundImage: 'url(' + require('../assets/img/4.jpg') + ')',
        }"
      ></div>
    </div>
    <!-- 登入框区域 -->
    <div class="login_box">
      <!--  头像区域 -->
      <div class="avator_box">
        <img src="../assets/img/avatar.jpg" />
      </div>
      <!-- 表单区域 -->
      <div class="form_box">
        <el-form
          ref="formRef"
          :model="loginForm"
          :rules="loginRules"
          class="login_form"
        >
          <!-- 用户名区域 -->
          <el-form-item prop="username">
            <el-input
              placeholder="请输入用户名"
              v-model="loginForm.username"
              prefix-icon="el-icon-s-custom"
            ></el-input>
          </el-form-item>
          <!-- 密码区域 -->
          <el-form-item prop="password">
            <el-input
              placeholder="请输入密码"
              v-model="loginForm.password"
              prefix-icon="el-icon-lock"
              type="password"
              show-password
            ></el-input>
          </el-form-item>
          <!-- 按钮区域 -->
          <el-form-item class="btns">
            <el-button type="primary" @click="login">登录</el-button>
            <el-button type="info" @click="resetForm">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'login',
  props: [''],
  data() {
    return {
      /* 这是登录表单的数据对象 */
      loginForm: {
        username: 'admin',
        password: '123456',
      },
      loginRules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          {
            min: 3,
            max: 10,
            message: '长度在 3 到 10 个字符',
            trigger: 'blur',
          },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          {
            min: 6,
            max: 20,
            message: '长度在 6 到 20 个字符',
            trigger: 'blur',
          },
        ],
      },
    }
  },
  mounted() {},
  methods: {
    resetForm() {
      this.$refs.formRef.resetFields()
    },
    login() {
      this.$refs.formRef.validate(async (valid) => {
        if (!valid) return
        else {
          const { data: ref } = await this.$http.post('login', this.loginForm)
          if (ref.meta.status != 200) return this.$message.error('登陆失败')
          this.$message.success('登陆成功')
          // window.sessionStorage.setItem('token', ref.data.token)
          // this.$router.push('/index')
        }
      })
    },
  },
}
</script>
<style lang="less" scoped>
@import '../../global/picSwitch.css';
/* 登录框区 */
.login_container {
	height: 100%;
	background: royalblue;
}
.login_box {
	width: 450px;
	height: 300px;
  background-color:  rgba(255, 255, 255, 0.5);
	border-radius: 3px;
  position: absolute;
  z-index: 100;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	.avator_box {
		height: 130px;
		width: 130px;
		border-radius: 50%;
		border: 1px solid #eee;
		padding: 10px;
		box-shadow: 0 0 10px #ddd;
		position: absolute;
		left: 50%;
		transform: translate(-50%, -50%);
		background-color: #fff;
		img {
			height: 100%;
			width: 100%;
			border-radius: 50%;
			background-color: #eee;
		}
	}
}

.login_form {
	position: absolute;
	bottom: 0px;
	padding: 0 20px;
	width: 100%;
	box-sizing: border-box;
}
.btns {
	display: flex;
	justify-content: flex-end;
}
</style>