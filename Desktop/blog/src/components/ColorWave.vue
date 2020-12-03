<template>
  <div class="wave">
    <div class="cover c1"></div>
    <div class="cover c2"></div>
    <div class="cover c3"></div>
    <div class="cover c4"></div>
    <div class="cover c5"></div>
    <router-link to="/index" tag="div"
      ><div class="next">NEXT</div>
    </router-link>
  </div>
</template>

<script>
export default {}
</script>

<style>
.wave {
  position: relative;
  width: 100%;
  height: 80px;
  background: linear-gradient(to bottom, #7abcff 0%, #00bcd4 44%, #2196f3);
  overflow: hidden;
}

.cover {
  position: absolute;
  width: 400px;
  height: 400px;
  border-radius: 40%;
  top: -360px;
  left: -50px;
  background: rgba(255, 255, 255, 1);
  animation: cover 10s linear infinite;
}

.c2 {
  left: 260px;
}
.c3 {
  left: 570px;
}
.c4 {
  left: 880px;
}
.c5 {
  left: 1190px;
}
@keyframes cover {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
    bottom: 100%;
  }
}

.next {
  position: absolute;
  font-size: 8vh;
  font-weight: 300;
  color: #ff7675;
  left: 45%;
  animation: next 4s ease-in-out infinite;
}

@keyframes next {
  0% {
    opacity: 1;
  }
  25% {
    opacity: 0.4;
  }
  50% {
    opacity: 0.2;
  }
  75% {
    opacity: 0.4;
  }
  100% {
    opacity: 1;
  }
}
</style>