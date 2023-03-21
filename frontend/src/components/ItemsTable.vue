<template>
    <div>
      <h1>Items:</h1>
      <ul>
        <li v-for="item in items" :key="item.id">{{ item.name }}</li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        items: []
      }
    },
    mounted() {
      this.getItems();
    },
    methods: {
      async getItems() {
        try {
          const response = await fetch('http://localhost:8080/items');
          const data = await response.json();
          this.items = data;
        } catch (error) {
          console.error(error);
        }
      }
    }
  }
  </script>

<style scoped>

</style>