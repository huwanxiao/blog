<template>
  <div class="contact-group" :class="[ isOpen ?  'open' : 'unopen' ]" @click="openBtn">
    <transition name="fade">
      <div class="plus" v-show="!isOpen"></div>
    </transition>
     <div class="contact" v-show="isOpen">
       <transition name="upforward">
         <i class="icon iconfont icon-github1" v-show="isOpen" ></i>
       </transition>
       <transition name="upforward1">
         <i class="icon iconfont icon-qq" v-show="isOpen"></i>
       </transition>
        <transition name="upforward2">
         <i class="icon iconfont icon-weixin" v-show="isOpen"></i>
        </transition>
     </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isOpen: false,
    }
  },
  methods: {
    openBtn() {
      this.isOpen = !this.isOpen
    },
  },
}
</script>

<style lang="scss" scoped>

@keyframes bounce-in {
  0% {
    transform: rotate(10deg);
  }
  25% {
    transform: rotate(-10deg);
  }
  50%{
    transform: rotate(10deg);
  }
  75% {
    transform: rotate(-10deg);
  }
  100% {
    transform: rotate(10deg);
  }
}


.upforward-enter-active, .upforward-leave-active {
  transition: all 1.5s cubic-bezier(1.0, 0.5, 0.8, 1.0);;
}

.upforward-enter, .upforward-leave-to  {
  opacity: 0;
  transform: translateY(100px);
}

.upforward1-enter-active, .upforward1-leave-active {
  transition: all 2s cubic-bezier(1.0, 0.5, 0.8, 1.0);;
}

.upforward1-enter, .upforward1-leave-to  {
  opacity: 0;
  transform: translateY(100px);
}

.upforward2-enter-active, .upforward2-leave-active {
  transition: all 3s cubic-bezier(1.0, 0.5, 0.8, 1.0);;
}

.upforward2-enter, .upforward2-leave-to  {
  opacity: 0;
  transform: translateY(100px);
}


.fade-enter-active, .fade-leave-active {
  transition: all 1s ease;
}

.fade-enter, .fade-leave-to  {
  opacity: 0;
  transform: translateX(120px) rotate(360deg) scale(0.8);
}

.icon {
  size: 20px;
  color: #f39c12;
}

.icon:hover {
   animation: bounce-in 1.5s linear;
}



.contact-group {
  display: flex;
  justify-content: center;
  align-items: center;
}

.contact{
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.unopen {
  width: 40px;
  height: 40px;
  border: 2px solid #f39c12;
  border-radius: 50%;
}

.open {
  width: 120px;
  height: 40px;
  border: 2px solid #f39c12;
  border-radius: 20px;
}

.plus {
  width: 25px;
  height: 5px;
  background: #f39c12;
  position: absolute;
}

.plus::before {
  content: '';
  width: 5px;
  height: 25px;
  background: #f39c12;
  position: absolute;
  top: -10px;
  left: 10px;
}
</style>