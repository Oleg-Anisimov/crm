<template>
  <div class="wrapper">
    <sidebar/>
    <div class="content">
      <router-view/>
    </div>
  </div>
</template>

<script setup>

import Sidebar from "./components/layout/Sidebar.vue";
</script>

<style scoped>
.wrapper {
  display: grid;
  grid-template-columns: 80px 1fr;
  height: 100vh;
}

.content {
  padding: 1em 1em;
}
</style>
