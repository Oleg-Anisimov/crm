<template>
  <aside>
    <div>
      <SidebarItem icon="icon_users.svg" text="Клиенты"/>
      <SidebarItem icon="icon_deals.svg" text="Сделки"/>
      <SidebarItem icon="icon_tasks.svg" text="Задачи"/>
      <SidebarItem icon="icon_payments.svg" text="Платежи"/>
      <SidebarItem icon="icon_calendar.svg" text="Календарь"/>
    </div>
    <div>
      <SidebarItem icon="icon_settings.svg" text="Настройки"/>

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
  height: 93vh;

}
</style>