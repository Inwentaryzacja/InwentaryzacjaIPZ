<script setup lang="ts">
import { storeToRefs } from "pinia";
import { selectedItemEntryStore } from "../stores/selectedItemEntryStore";

const store = selectedItemEntryStore();
const { selectedEntry } = storeToRefs(store);
</script>
<template>
  <div class="items-info-container">
    <h1 class="item-name-header">Lodówka</h1>
    
    {{ selectedEntry?.item.name }}

    <div class="grid-container">
      <div class="grid-item header key">Atrybut</div>
      <div class="grid-item header value">Wartość</div>
      <div class="grid-item key">Producent</div>
      <div class="grid-item value">Amica</div>
      <div class="grid-item key">Klasa oszczędności</div>
      <div class="grid-item value">A+</div>
    </div>

    <div class="grid-container">
      <div class="grid-item key">Data dodania:</div>
      <div class="grid-item value">2022-12-13</div>
      <div class="grid-item key">Opis</div>
      <div class="grid-item value">
        Lorem, ipsum dolor sit amet consectetur adipisicing elit. Maxime,
        dolorum nihil quis vel rem necessitatibus dolores veniam fugiat vero
        placeat, possimus aperiam laboriosam facere numquam adipisci nostrum
        debitis eos consectetur!
      </div>
    </div>

    <div class="grid-container">
      <div class="grid-item key">Data dodania:</div>
      <div class="grid-item value">2022-12-13</div>
      <div class="grid-item key">Opis</div>
      <div class="grid-item value">
        Lorem, ipsum dolor sit amet consectetur adipisicing elit. Maxime,
        dolorum nihil quis vel rem necessitatibus dolores veniam fugiat vero
        placeat, possimus aperiam laboriosam facere numquam adipisci nostrum
        debitis eos consectetur!
      </div>
    </div>

    <div class="grid-container">
      <div class="grid-item key">Data dodania:</div>
      <div class="grid-item value">2022-12-13</div>
      <div class="grid-item key">Opis</div>
      <div class="grid-item value">
        Lorem, ipsum dolor sit amet consectetur adipisicing elit. Maxime,
        dolorum nihil quis vel rem necessitatibus dolores veniam fugiat vero
        placeat, possimus aperiam laboriosam facere numquam adipisci nostrum
        debitis eos consectetur!
      </div>
    </div>

    <div class="grid-container">
      <div class="grid-item key">Data dodania:</div>
      <div class="grid-item value">2022-12-13</div>
      <div class="grid-item key">Opis</div>
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
