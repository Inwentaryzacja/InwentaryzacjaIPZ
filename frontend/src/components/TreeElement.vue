<script setup lang="ts">

defineProps(["entry", "children", "recursionDepth"]);
</script>

<template>
  <div class="wrap">
    {{ entry?.item?.name }} <span v-if="children.length > 0"> v</span>
    <div v-for="child in children">
      <TreeElement
        v-bind="{
          entry: child.entry,
          children: child.children,
          recursionDepth: recursionDepth + 1,
        }"
      />
    </div>
  </div>
</template>

<style scoped>
.wrap {
  width: 100%;
  font-size: 12px;
  color: #0082fb;

  margin-left: 2px;
  padding-left: 10px;
  margin-bottom: 10px;
  margin-top: 10px;
  padding: 10px;

  border-left: 1px solid #385e72;
  border-bottom: 1px solid #385e72;
  border-right: 1px solid #385e72;
  font-size: 16px;
}
</style>
