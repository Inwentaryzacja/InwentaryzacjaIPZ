<script setup lang="ts">
import { RouterLink } from "vue-router";
</script>

<template>
  <div class="navigation">
    <img src="box.png" />
    <div class="navigation-items">
      <RouterLink class="nav-item" to="/">Home</RouterLink>
      <RouterLink class="nav-item" to="/register">Zarejestruj</RouterLink>
      <RouterLink class="nav-item" to="/login">Zaloguj</RouterLink>
    </div>
  </div>
</template>

<style scoped lang="scss">
.navigation {
  width: 100%;
  height: 20vh;
  border-bottom: solid rgba(0, 0, 0, 0.25) 1px;
  display: flex;
}

.navigation-items {
  padding: 10vh;
  .nav-item {
    margin-left: 100px;
  }
}

img {
  height: 80%;
  margin: 10px;
  margin-left: 50px;
}

.navigation a {
  font-size: 1.5rem;
  color: #0082fb;
  text-decoration: none;
}
</style>
