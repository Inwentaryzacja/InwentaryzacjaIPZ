<script setup lang="ts">
import LoginForm from "./components/LoginForm.vue";
</script>

<template>
  <div class="centered">
    <LoginForm />
  </div>
</template>

<style scoped>
.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

</style>
