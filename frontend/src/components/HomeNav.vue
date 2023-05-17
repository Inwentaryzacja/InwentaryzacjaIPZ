<template>
  <div class="navigation">
    <img
      src="box.png"
    />
    <span>Home</span>
    <span>Zarządzaj tagami</span>
    <span>Ulubione</span>
    <span>Ustawienia</span>
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
