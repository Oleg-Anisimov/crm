<template>
  <h1>Настройки</h1>
  <TabLayout :tabs="tabs" :selected-tab="currentTab" @tab-selected="name => currentTab = name">
    <div v-if="currentTab === 'users'">Lorem ipsum dolor sit amet.</div>
    <div v-if="currentTab === 'steps'">
      <StatusPage/>
    </div>
    <div v-if="currentTab === 'third'">Lorem ipsum dolor sit amet, consectetur adipisicing elit. A architecto delectus doloribus ducimus ex iste molestiae nam, pariatur, placeat porro quidem ratione tempora totam ut.</div>
    <div v-if="currentTab === 'test'">test</div>
  </TabLayout>
</template>

<script>
import TabLayout from "../components/layout/TabLayout.vue";
import StatusPage from "./StatusPage.vue";

export default {
  name: "SettingsPage",
  components: {StatusPage, TabLayout},
  data() {
    return {
      currentTab: 'users',
      tabs: [
        {name: 'users', label: "Пользователи"},
        {name: 'steps', label: "Статусы сделки"},
        {name: 'third', label: "Третья вкладка"},
        {name: 'test', label: "Тестовая вкладка"},
      ]
    }
  }
}
</script>

<style scoped>

</style>