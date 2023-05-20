<script setup lang="ts">
import { computed, type PropType } from "vue";
import { Child, Entry } from "../domain/fetchTree";
import { selectedItemEntryStore } from "../stores/selectedItemEntryStore";

const props = defineProps({
  entry: Object as PropType<Entry>,
  children: Array as PropType<Array<Child>>,
  recursionDepth: { type: Number, required: true },
});

const has_children = computed(() => {
  return props?.children?.length != undefined && props.children.length > 0;
});

const store = selectedItemEntryStore();

function selectAndLoadIntoStore() {
  if (props?.entry != undefined) {
    store.set(props.entry);
  }
}
</script>

<template>
  <div
    class="wrap"
    :class="{ expandable: has_children, 'non-expandable': !has_children }"
    @click.stop="selectAndLoadIntoStore"
  >
    {{ props?.entry?.item?.name }}
    <span v-if="has_children">
      <button class="expand-btn">v</button>
    </span>
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
  width: 99%;
  box-sizing: border-box;
  color: #0082fb;

  margin-left: 2px;
  margin-bottom: 10px;
  margin-top: 10px;

  padding-left: 10px;
  padding-bottom: 10px;
  padding-top: 10px;

  border-left: 1px solid #385e72;
  border-bottom: 1px solid #385e72;
  font-size: 0.8rem;
}

.expandable {
  background-color: white;
}

.non-expandable {
  background-color: #b7cfdc;
}
.expand-btn {
  float: right;
  width: 40px;
  margin-right: 10px;
  background-color: #b7cfdc;
}
</style>
