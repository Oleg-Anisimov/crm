<template>
  <div class="wrapper">
    <sidebar/>
    <router-view/>
  </div>
</template>

<script setup>

import Sidebar from "./components/layout/Sidebar.vue";
import MainPage from "./pages/MainPage.vue";
</script>

<style scoped>
.wrapper {
  display: grid;
  grid-template-columns: 80px 1fr;
  grid-column-gap: 1em;
  height: 100vh;
}
</style>
