<script setup lang="ts">
import { ref } from "vue";
import { selectedItemEntryStore } from "../stores/selectedItemEntryStore";
import { HttpStatusCode } from "axios";
import { useRouter } from "vue-router";
import { storeToRefs } from "pinia";

const { selectedEntry } = storeToRefs(selectedItemEntryStore());

async function deleteItem() {
  const router = useRouter();

  const entry = selectedEntry.value;
  let id = entry?.id;

  if (id === null || id === undefined) return;

  let res = await fetch(`http://localhost:8080/inventory_entries/${id}`, {
    method: "DELETE",
  });

  if (res.status === HttpStatusCode.Ok) {
    console.log(`Deleted item id=${id}, name=${entry?.item?.name}`);
    router.push("/");
  } else {
    alert(`Failed to delete item.`);
  }
}
</script>

<template>
  <div class="wrap">
    <div class="delete-info">You are about to delete {{ selectedEntry?.item?.name }}</div>
    <form @submit.prevent="deleteItem" action="delete">
      <h3>Are you sure?</h3>
      <button type="submit" class="confirm-delete">
        Yes, delete this item.
      </button>
    </form>
  </div>
</template>

<style scoped>
.wrap {
  height: 80vh;
  background: white;
  padding: 20px;
}
</style>
