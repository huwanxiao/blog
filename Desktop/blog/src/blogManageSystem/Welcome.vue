<template>
	<div class="welcome">
		<canvas id="canvas">Canvas not supported.</canvas>
	</div>
</template>
<script>
import welcome from '../assets/js/welcome.js'
export default {
	name: 'welcome',
	data() {
		return {}
	},
	mounted(){
		welcome()
	},
	components: {},
	methods: {}
}
</script>
<style scoped>
canvas#canvas {
	display: block;
	background: rgba(255, 255, 255, 0);
	position: absolute;
	top: 50%;
	left: 50%;
	margin-left: -200px;
	margin-top: -150px;
}
</style>
