<template>
  <div>
    <h2>Клиенты</h2>
    <Table :layout="clientsTableLayout" :values="clients.value"/>
  </div>
</template>

<script lang="ts">
import Table from "../components/Table.vue";
import {defineComponent} from "vue";
import clientsTableLayout from "../store/mock/layouts/clients_table_layout.json";
import {storeToRefs} from "pinia";
import {useClientStore} from "../store/modules/clientStore";

export default defineComponent({
  name: "ClientsPage",
  components: {Table},
  setup: () => {
    const { clients, loading, error } = storeToRefs(useClientStore())
    const { fetchClients } = useClientStore()

    fetchClients()
    console.log(clients.value)
  },
  data: () => {
    return {
      clientsTableLayout: clientsTableLayout,
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
  },
})
</script>

<style scoped>
h2 {
  margin-left: 1rem;
  display: inline-block;
}
</style>