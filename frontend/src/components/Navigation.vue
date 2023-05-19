<script setup lang="ts">
import { RouterLink } from "vue-router";
</script>

<template>
  <div class="navigation">
    <img src="box.png" />
    <span><RouterLink to="/">Home</RouterLink></span>
    <span><RouterLink to="/register">Zarejestruj</RouterLink></span>
    <span><RouterLink to="/login">Zaloguj</RouterLink></span>
  </div>
</template>

<style scoped>
.navigation {
  width: 100%;
  height: 161px;
  border-bottom: solid rgba(0, 0, 0, 0.25) 1px;
}

img {
  height: 121px;
  display: inline-block;
  margin-left: 50px;
}

span {
  color: #0082fb;
  font-family: Arial;
  font-size: 24px;
  margin: 135px;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>
