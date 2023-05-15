<template>
  <aside>
    <img src="/public/avatar_mock.jpg">

    <router-link to="/deals"><sidebar-item image="/src/assets/deal_icon.svg" content="Сделки"/></router-link>
    <router-link to="/clients"><sidebar-item image="/src/assets/clients_icon.svg" content="Клиенты"/></router-link>
    <router-link to="/payments"><sidebar-item image="/src/assets/payments_icon.svg" content="Платежи"/></router-link>
    <router-link to="/settings"><sidebar-item image="/src/assets/settings_icon.svg" content="Настройки"/></router-link>

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