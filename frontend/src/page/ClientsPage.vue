<script lang="ts" setup>
  import { useClientStore } from "../store/modules/clientStore";
  import { storeToRefs } from "pinia";
  import clientsTableLayout from '../store/mock/layouts/clients_table_layout.json'
  import Table from "../components/Table.vue";

  const { clients, loading, error } = storeToRefs(useClientStore())
  const { fetchClients } = useClientStore()

  const transformData = () => {
    console.log(clients)

    return clients.value.map(client => {
      const contactPerson = client.contactPerson;
      client.phone = contactPerson.phone;
      client.person = contactPerson.lastName + ' '
          + contactPerson.firstName.charAt(0) + '. '
          + contactPerson.paternalName.charAt(0) + '.'
      return client
    })
  }

  fetchClients()
  transformData()
</script>

<template>
  <div>
    <h2>Клиенты</h2>
    <Table :layout="clientsTableLayout" :values="clients"/>
  </div>
</template>


<style scoped>
h2 {
  margin-left: 1rem;
  display: inline-block;
}
</style>