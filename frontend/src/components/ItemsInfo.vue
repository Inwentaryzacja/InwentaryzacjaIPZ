<script setup lang="ts">
import { storeToRefs } from "pinia";
import { selectedItemEntryStore } from "../stores/selectedItemEntryStore";

const store = selectedItemEntryStore();
const { selectedEntry } = storeToRefs(store);
</script>
<template>
  <div v-if="selectedEntry" class="items-info-container">
    <h1 class="item-name-header">{{ selectedEntry?.item.name }}</h1>

    <div class="grid-container">
      <div class="grid-item header key">Atrybut</div>
      <div class="grid-item header value">Wartość</div>

      <div class="grid-item key">Ilość</div>
      <div class="grid-item value">{{ selectedEntry?.quantity }}</div>

      <div class="grid-item key">Data dodania:</div>
      <div class="grid-item value">{{ selectedEntry?.item?.createdAt }}</div>

      <div class="grid-item key">Opis</div>
      <div class="grid-item value">
        {{
          selectedEntry?.item?.description === ""
            ? "Nie ustawiono opisu."
            : selectedEntry?.item?.description
        }}
      </div>
    </div>
    <!-- More data for layout overflow test -->
    <div class="grid-container">
      <div class="grid-item key">Test</div>
      <div class="grid-item value">Test</div>
      <div class="grid-item key">Long Attribute Test</div>
      <div class="grid-item value">
        Lorem, ipsum dolor sit amet consectetur adipisicing elit. Maxime,
        dolorum nihil quis vel rem necessitatibus dolores veniam fugiat vero
        placeat, possimus aperiam laboriosam facere numquam adipisci nostrum
        debitis eos consectetur!
      </div>
    </div>
    <div class="grid-container">
      <div class="grid-item key">Test</div>
      <div class="grid-item value">Test</div>
      <div class="grid-item key">Long Attribute Test</div>
      <div class="grid-item value">
        Lorem, ipsum dolor sit amet consectetur adipisicing elit. Maxime,
        dolorum nihil quis vel rem necessitatibus dolores veniam fugiat vero
        placeat, possimus aperiam laboriosam facere numquam adipisci nostrum
        debitis eos consectetur!
      </div>
    </div>
    <div class="grid-container">
      <div class="grid-item key">Test</div>
      <div class="grid-item value">Test</div>
      <div class="grid-item key">Long Attribute Test</div>
      <div class="grid-item value">
        Lorem, ipsum dolor sit amet consectetur adipisicing elit. Maxime,
        dolorum nihil quis vel rem necessitatibus dolores veniam fugiat vero
        placeat, possimus aperiam laboriosam facere numquam adipisci nostrum
        debitis eos consectetur!
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.items-info-container {
  padding: 20px;
  height: 80vh;
  overflow-y: scroll;
  .item-name-header {
    color: #385e72;
    font-size: 1.5rem;
    text-align: center;
    margin-bottom: 5%;
  }
}
.grid-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 10px;
  margin-bottom: 10px;
}

.grid-item {
  padding: 10px;
  border: 1px solid #ccc;
}

.key {
  background-color: #f1f1f1;
}

.value {
  background-color: #d9e4ec;
}
</style>
