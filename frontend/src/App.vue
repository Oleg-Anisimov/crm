<script setup lang="ts">
import Header from "./components/layout/Header.vue";
import Sidebar from "./components/layout/Sidebar.vue";
import DealsPage from "./page/DealsPage.vue";</script>

<template>
  <div class="wrapper">
    <Sidebar/>
    <div class="main">
      <Header/>
      <router-view/>
    </div>
  </div>
</template>

<style scoped>
.wrapper {
  display: grid;

  grid-template-columns: 80px 1fr;
}
.main {
  padding: 1em;
}

#droppable div {
  opacity: 1;
}


</style>
