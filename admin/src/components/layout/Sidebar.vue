<template>
  <aside>
    <img src="avatar_mock.jpg">

    <router-link to="/deals"><sidebar-item image="src/assets/deal_icon.svg" content="Сделки"/></router-link>
    <router-link to="/clients"><sidebar-item image="src/assets/clients_icon.svg" content="Клиенты"/></router-link>
    <router-link to="/payments"><sidebar-item image="src/assets/payments_icon.svg" content="Платежи"/></router-link>
    <router-link to="/stats"><sidebar-item image="src/assets/stats_icon.svg" content="Статистика"/></router-link>

  </aside>
</template>

<script>
import SidebarItem from "./SidebarItem.vue";

export default {
  name: "Sidebar",
  components: {SidebarItem}
}
</script>

<style scoped>
aside {
  background-color: var(--primary);

  padding-top: 50px;
  color: white;
}

img {
  width: 65px;
  height: 65px;
  margin: 0 auto;

  border-radius: 5px;
  display: block;
}

</style>