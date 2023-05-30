<script setup lang="ts">
import DeleteItemComponent from "../components/DeleteItemComponent.vue";
import TreeSidebar from "../components/TreeSidebar.vue";
</script>
<template>
  <div class="container">
    <TreeSidebar class="tree" />
    <DeleteItemComponent class="delete_item" />
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

.delete_item {
  width: 70vw;
}
</style>
