<script setup lang="ts">
import TreeSidebar from "../components/TreeSidebar.vue";
import ItemsInfo from "../components/ItemsInfo.vue";
</script>
<template>
  <div class="container">
    <TreeSidebar class="tree" />
    <ItemsInfo class="items"></ItemsInfo>
  </div>
</template>

<style scoped>
.container {
  width: 98vw;
  margin: 0 auto;
  height: 80vh;
  display: flex;
}
.tree {
  width: 30vw;
  height: 80vh;
}

.items {
  width: 70vw;
}
</style>
