<script setup lang="ts">
import { computed, type PropType } from "vue";
interface Entry {
  id: number;
  item: Item;
}

interface Item {
  name: string;
  fillable: boolean;
  createdAt: string;
  description: string;
}

interface Child {
  entry: Entry;
  children: Entry[];
}

const props = defineProps({
  entry: Object as PropType<Entry>,
  children: Array as PropType<Array<Child>>,
  recursionDepth: { type: Number, required: true },
});

const has_children = computed(() => {
  return props?.children?.length != undefined && props.children.length > 0;
});
console.log(props?.children);
</script>

<template>
  <div class="wrap">
    {{ props?.entry?.item?.name }}
    <span v-if="has_children"> v</span>
    <div v-for="child in children">
      <TreeElement
        v-bind="{
          entry: child?.entry,
          children: child?.children,
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
