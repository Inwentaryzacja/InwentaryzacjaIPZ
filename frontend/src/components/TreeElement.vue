<script setup lang="ts">

defineProps(['entry','children']);

</script>

<template>
  <div class="wrap">
    {{ entry?.item?.name }} <span v-if="children.length > 0"> v</span>
    <div v-for="child in children" style="padding-left: 20px;">
      <TreeElement class="tree-element" v-bind="{ entry: child.entry, children: child.children }" />
    </div>
  </div>
</template>

<style scoped>
.wrap {
  width: 100%;
  font-size: 12px;
  color: #0082fb;

}
</style>
