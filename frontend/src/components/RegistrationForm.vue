<script setup lang="ts">
import { ref } from "@vue/reactivity";

let email = ref("");
let username = ref("");
let password = ref("");
let passwordAgain = ref("");

function emailCorrect(): boolean {
  return /^[^@]+@\w+(\.\w+)+\w$/.test(email.value);
}

function usernameCorrect(): boolean {
  // At least 6 chars and 1 capital character
  return (
    username.value.length > 6 && username.value.toLowerCase() != username.value
  );
}

function passwordsAreTheSame(): boolean {
  return password.value == passwordAgain.value;
}
</script>

<template>
  <form id="login">
    <img
      src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Adidas_Logo.svg/1000px-Adidas_Logo.svg.png"
    /><br />
    <label for="email">Email</label><br />
    <input
      v-model="email"
      type="text"
      id="email"
      placeholder="Wpisz Email"
    /><br /><br />
    <div>{{ !emailCorrect() ? "Email jest niepoprawny" : "" }}</div>
    <br />
    <label for="username">Nazwa użytkownika</label><br />
    <input
      v-model="username"
      type="text"
      id="username"
      placeholder="Wpisz nazwę użytkownika"
    /><br /><br />
    <div>{{ !usernameCorrect() ? "Hasło jest niepoprawne" : "" }}</div>
    <br />
    <label>Hasło</label><br />
    <input v-model="password" type="text" id="password" placeholder="Wpisz hasło" /><br />
    <input v-model="passwordAgain" type="text" id="passwordconfirm" placeholder="Powtórz hasło" /><br /><br />
    <div>{{ !passwordsAreTheSame() ? "Hasła nie są takie same" : "" }}</div>
    <button type="button">Zarejestruj</button>
  </form>
</template>

<style scoped lang="scss">
$border-color: #aeaeae;
$font-color: #0082fb;
$input-color: #0082fbc9;
$hover-color: #005fb8;

form#login {
  margin: auto;
  padding: 50px;
  text-align: center;
  width: 400px;
  border: 1px solid $border-color;
  border-radius: 23px;
  font-family: Arial;

  img {
    width: 100px;
    height: 100px;
    margin: 30px;
    margin-top: 0px;
  }

  label {
    font-size: 22px;
    font-weight: bold;
    color: $font-color;
  }

  input {
    border-radius: 4px;
    padding: 12px;
    border: 3px solid $input-color;
    margin: 8px;
    margin-bottom: 1px;
    width: 300px;
    box-shadow: 0 6px 2px -2px rgba(128, 128, 128, 0.473);
  }

  a {
    color: $font-color;
    font-size: 12px;
    position: relative;
    right: 100px;
    text-decoration: none;
  }

  button {
    color: white;
    font-size: 18px;
    font-weight: bold;
    background-color: $font-color;
    padding: 12px;
    padding-left: 20px;
    padding-right: 20px;
    margin-top: 50px;
    margin-bottom: 0px;
    border-radius: 10px;
    border-style: none;
    position: relative;
    left: 120px;
    transition-duration: 0.1s;
  }

  button:hover {
    background-color: $hover-color;
  }
}
</style>
