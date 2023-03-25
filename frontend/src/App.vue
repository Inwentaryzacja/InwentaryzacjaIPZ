<script setup lang="ts">
import LoginForm from "./components/LoginForm.vue";
import RegistrationForm from "./components/RegistrationForm.vue";
import { RouterView, RouterLink } from "vue-router";
</script>

<template>
  <RouterLink to="/">Home</RouterLink>
  <RouterLink to="/register">Register</RouterLink>
  <RouterLink to="/login">Login</RouterLink>
  <RouterLink to="/items">Items</RouterLink>
  <RouterView />

  <!--iv class="centered">
    <RouterView />
  </div-->
</template>

<style scoped>
.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>
