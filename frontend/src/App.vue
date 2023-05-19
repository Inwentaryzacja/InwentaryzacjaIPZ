<script setup lang="ts">
import { RouterView } from "vue-router";
import Navigation from "./components/Navigation.vue"

</script>

<template>
  <Navigation />
  <RouterView />
</template>

<style scoped>
.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

nav {
  margin-bottom: 100px;
}
</style>
