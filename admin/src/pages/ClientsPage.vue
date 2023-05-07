<template>
    <div>
    <h2>Клиенты</h2>
    <Table :layout="clientsTableLayout" :values="clients"/>
  </div>
</template>

<script>
import Table from "@/components/Table.vue"
export default {
  name: "DealCreationPage", 
  components:{Table},
  data() {
    return {
      clients: [
        {id: 1, contact_person: 'Иванов И.И.', phone: '+79775830241', client_type: 'PERSONAL'},
        {id: 2, contact_person: 'Петров П.П.', phone: '+79775830242', client_type: 'PERSONAL'},
        {id: 3, contact_person: 'Смирнов C.C.', phone: '+79775830243', client_type: 'PERSONAL'},
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
h2 {
  margin-left: 1rem;
  display: inline-block;
}
</style>


