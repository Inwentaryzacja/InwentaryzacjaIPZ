<script setup lang="ts">
import { computed, ref, type PropType } from "vue";
import { Entry, Child } from "../domain/fetchTree";
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

const shouldShow = ref(true);

function toggleShouldShow() {
  shouldShow.value = !shouldShow.value;
}

function loadIntoStore() {
  if (props?.entry != undefined) {
    store.set(props.entry);
  }
}
</script>

<template>
  <div
    @click.self="loadIntoStore"
    class="wrap"
    :class="{
      expandable: has_children,
      'non-expandable': !has_children,
    }"
  >
    <span v-if="has_children">
      <img
        @click.stop="toggleShouldShow"
        class="arrow"
        :class="{
          'arrow-open': shouldShow,
          'arrow-close': !shouldShow,
        }"
        :src="shouldShow ? 'arrowopen.svg' : 'arrowclosed.svg'"
      />
    </span>
    {{ props?.entry?.item?.name }}

    <div class="children" v-for="child in children">
      <TreeElement
        v-if="shouldShow"
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
.arrow {
  display: inline;
  float: left;
  margin-right: 10px;
  height: 17px;
}
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

  font-size: 0.8rem;
  user-select: none;
}
</style>
