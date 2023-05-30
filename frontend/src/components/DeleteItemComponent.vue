<script setup lang="ts">
import { ref } from "vue";
import { selectedItemEntryStore } from "../stores/selectedItemEntryStore";
import { HttpStatusCode } from "axios";
import { useRouter } from "vue-router";
import { storeToRefs } from "pinia";

const { selectedEntry } = storeToRefs(selectedItemEntryStore());
const router = useRouter();

async function deleteItem() {
  const entry = selectedEntry.value;
  let id = entry?.id;

  if (id === null || id === undefined) return;
  let res = await fetch(`http://localhost:8080/inventory_entries/${id}`, {
    method: "DELETE",
  });

  if (res.status === HttpStatusCode.Ok) {
    console.log(`Deleted item id=${id}, name=${entry?.item?.name}`);
  } else {
    alert(`Failed to delete item.`);
  }
  router.push("/");
}
</script>

<template>
  <div class="wrap" v-if="selectedEntry">
    <div class="delete-info dark">
      You are about to delete {{ selectedEntry?.item?.name }}
    </div>

    <form @submit.prevent="deleteItem" action="delete">
      <h3>Are you sure?</h3>
      <button type="submit" class="confirm-delete dark light-bg">
        Yes, delete this item.
      </button>
    </form>
  </div>
</template>

<style scoped lang="scss">
@mixin border-radius($radius) {
  -webkit-border-radius: $radius;
  -moz-border-radius: $radius;
  -ms-border-radius: $radius;
  border-radius: $radius;
}

.wrap {
  height: 80vh;
  background: white;
  padding: 5vmin;
}

.delete-info {
  margin-top: 10px;
  margin-bottom: 10px;
}

form {
  width: 30vw;
  height: 30vh;
  margin: 0 auto;

  h3 {
    margin-top: 10px;
    text-align: center;
    width: 100%;
  }
  button {
    @include border-radius(5px);
    margin-top: 10px;
    width: 100%;
    height: 2rem;
  }
}
</style>
