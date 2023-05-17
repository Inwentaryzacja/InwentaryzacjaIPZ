<script setup lang="ts">
import TreeElement from "../components/TreeElement.vue";
import { reactive, onMounted } from "vue";
const data = reactive({ entry: {}, children: {} });

onMounted(async () => {
  const response = await fetch(
    "http://localhost:8080/inventory_entries/user/1/tree"
  );
  const jsonData = await response.json();

  data.entry = jsonData.entry;
  data.children = jsonData.children;
});
</script>

<template>
  <div class="box">
    <div class="tools">
      <div class="option" id="add">+</div>
      <div class="option" id="del">-</div>
      <div class="option" id="arrowUp">u</div>
      <div class="option" id="arrowDown">d</div>
    </div>
    <div class="elements">
      <TreeElement v-bind="{ entry: data.entry, children: data.children }" />
    </div>
  </div>
</template>

<style scoped>
.box {
  width: 400px;
  height: 600px;
  border-right: solid rgba(0, 0, 0, 0.24) 1px;
  font-family: Arial;
  float: left;
}

.tools {
  width: 100%;
  height: 70px;
  background-color: #d4d4d4;
  text-align: center;
  font-size: 40px;
}

.option {
  width: 50px;
  height: 50px;
  background-color: #0082fb;
  color: white;
  border: solid rgba(0, 0, 0, 0.24) 1px;
  border-radius: 5px;
  display: inline-block;
  margin: 24px;
  margin-top: 8px;
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
