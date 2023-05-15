<template>
  <div>

    <h1>
      Клиенты
    </h1>

    <Table :layout="clientsTableLayout" :values="clients"/>

  </div>


</template>

<script>
import Table from "../components/layout/Table.vue";

export default {
  name: "ClientsPage",
  components: {Table},
  data() {
    return {
      clients: [
        {id: 1, contact_person: 'Иванов И.И.', phone: '+79775830249', client_type: 'PERSONAL'},
        {id: 1, contact_person: 'Иванов И.И.', phone: '+79775830249', client_type: 'PERSONAL'},
        {id: 1, contact_person: 'Иванов И.И.', phone: '+79775830249', client_type: 'PERSONAL'},
        {id: 1, contact_person: 'Иванов И.И.', phone: '+79775830249', client_type: 'PERSONAL'},
      ],
      clientsTableLayout:
          {
            columns: [
              {
                name: "id",
                header: "id",
                valueRef: "id"
              },
              {
                name: "contact_person",
                header: "Контактное лицо",
                valueRef: "person"
              },
              {
                name: "phone",
                header: "Телефон",
                valueRef: "phone"
              },
              {
                name: "client_type",
                header: "Тип клиента",
                valueRef: "clientType"
              }
            ]
          }
    }
  }
}
</script>

<style scoped>

</style>