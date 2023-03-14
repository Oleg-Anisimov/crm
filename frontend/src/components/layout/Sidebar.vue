<template>
  <aside>
    <div>
      <router-link to="/clients"><SidebarItem icon="/icon_users.svg" text="Клиенты"/></router-link>
      <router-link to="/deals"><SidebarItem icon="/icon_deals.svg" text="Сделки"/></router-link>
      <router-link to="/"><SidebarItem icon="/icon_tasks.svg" text="Задачи"/></router-link>
      <router-link to="/"><SidebarItem icon="/icon_payments.svg" text="Платежи"/></router-link>
      <router-link to="/"><SidebarItem icon="/icon_calendar.svg" text="Календарь"/></router-link>
    </div>
    <div>
      <SidebarItem icon="/icon_settings.svg" text="Настройки"/>
    </div>
  </aside>

</template>

<script lang="ts">
import {defineComponent} from "vue";
import SidebarItem from "./SidebarItem.vue";

export default defineComponent({
  name: "Sidebar",
  components: {SidebarItem}
})
</script>

<style scoped>
aside {
  width: 80px;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  border-right: 1px solid darkgray;
  justify-content: space-between;
  position: sticky;
}

a  {
  text-decoration: none;
  color: #000000;

}

a:visited {
  text-decoration: none;
}
</style>