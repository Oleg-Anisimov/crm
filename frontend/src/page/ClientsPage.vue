<template>
  <div>
    <h2>Клиенты</h2>
    <Table :layout="clientsTableLayout" :values="getClients"/>
  </div>
</template>

<script lang="ts">
import Table from "../components/Table.vue";
import {defineComponent} from "vue";
import clientsTableLayout from "../store/mock/layouts/clients_table_layout.json";
import clientData from "../store/mock/clients.json";

export default defineComponent({
  name: "ClientsPage",
  components: {Table},
  data: () => {
    return {
      clientsTableLayout: clientsTableLayout,
    }
  },
  computed: {
    getClients() {
      return this.transformData(clientData)
    }
  },
  methods: {
    transformData(data) {

      return data.map(client => {
        const contactPerson = client.contactPerson;
        client.phone = contactPerson.phone;
        client.person = contactPerson.lastName + ' '
            + contactPerson.firstName.charAt(0) + '. '
            + contactPerson.paternalName.charAt(0) + '.'
        return client
      })
    }
  }
})
</script>

<style scoped>
h2 {
  margin-left: 1rem;
  display: inline-block;
}
</style>