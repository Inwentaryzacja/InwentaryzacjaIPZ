<script setup lang="ts">
import TreeElement from "../components/TreeElement.vue";
import { onMounted, ref } from "vue";
import { get, Entry, Child } from "../domain/fetchTree";

const root_entry = ref<Entry>();
const root_children = ref<Array<Child>>();

onMounted(async () => {
  const jsonData = await get();

  root_entry.value = jsonData.entry;
  root_children.value = jsonData.children;
});
</script>

<template>
  <div class="box">
    <div class="tools">
      <div class="option" id="add">+</div>
      <div class="option" id="del">-</div>
      <div class="option" id="arrowUp">u</div>
    </div>
    <div class="elements">
      <TreeElement
        v-bind="{
          entry: root_entry,
          children: root_children,
          recursionDepth: 0,
        }"
      />
    </div>
  </div>
</template>

<style scoped>
.box {
  border: solid rgba(0, 0, 0, 0.24) 1px;
  font-family: Arial;
  float: left;
  
  /* 
  This is for scrollbar to appear on the left.
  Direction right to left makes everything float to right in the scope of this component. 
  Direction + text-align is a terrible hack and if something doesnt work in this component
  (especially layout directions), then have in mind that this is the reason.
  Change left and right sides to compensate.
  */
  direction: rtl;
  text-align: left;
}

.tools {
  width: 100%;
  background-color: #d4d4d4;
  text-align: center;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  gap: 30px;
  align-items: baseline;
  font-size: 0.7rem;
}

.option {
  width: 30px;
  margin-top: 10px;
  margin-bottom: 10px;
  height: 30px;
  line-height: 30px;
  display: inline-block;
  vertical-align: middle;
  font-size: 1.5rem;
  text-align: center;
  background-color: #0082fb;
  color: white;
  border: solid rgba(0, 0, 0, 0.24) 1px;
  border-radius: 5px;
}

.elements {
  overflow-y: scroll;
  height: 70vh;
  width: 100%;
}
</style>
