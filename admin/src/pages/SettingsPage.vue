<template>
  <h1>Настройки</h1>
  <TabLayout :tabs="tabs" :selected-tab="currentTab" @tab-selected="name => currentTab = name">
    <div v-if="currentTab === 'users'">
      <UsersPage/>
    </div>
    <div v-if="currentTab === 'steps'">
      <StatusPage/>
    </div>
  </TabLayout>
</template>

<script>
import TabLayout from "../components/layout/TabLayout.vue";
import StatusPage from "./StatusPage.vue";
import UsersPage from "./UsersPage.vue";

export default {
  name: "SettingsPage",
  components: {UsersPage, StatusPage, TabLayout},
  data() {
    return {
      currentTab: 'users',
      tabs: [
        {name: 'users', label: "Пользователи"},
        {name: 'steps', label: "Статусы сделки"},
      ]
    }
  }
}
</script>

<style scoped>

</style>