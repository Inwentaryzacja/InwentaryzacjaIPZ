<script setup lang="ts"></script>

<template>
  <form id="login">
    <img
      src="box.png"
    /><br />
    <label for="email">Email</label><br />
    <input type="text" id="email" placeholder="Wpisz Email" /><br /><br />
    <label>Hasło</label><br />
    <input type="password" id="password" placeholder="Wpisz hasło" /><br />
    <a href="">Zapomniałem hasła</a><br />
    <button type="button" id="rejestration">Rejestracja</button>
    <button type="button" id="login">Dalej</button>
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

  #login {
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

  #login:hover {
    background-color: $hover-color;
  }

  #rejestration {
    color: $font-color;
    font-size: 18px;
    font-weight: bold;
    background-color: white;
    padding: 12px;
    padding-left: 20px;
    padding-right: 20px;
    margin-top: 50px;
    margin-bottom: 0px;
    border: 2px solid $font-color;
    border-radius: 10px;
    position: relative;
    right: 120px;
    transition-duration: 0.1s;
  }

  #rejestration:hover {
    background-color: $hover-color;
    color: white;
    border: 2px solid $hover-color;
  }
}
</style>
