<template>
  <div>
    <h2>Клиенты</h2>

    <router-link to="/clients/new">
      <Button label="Создать" color="second"/>
    </router-link>

    <Table :layout="clientsTableLayout" :values="GET_ALL()"/>
  </div>
</template>

<script>
import Table from "../../components/layout/Table.vue";
import {mapActions, mapGetters} from "vuex";
import Button from "../../components/control/Button.vue";

export default {
  name: "Clients page",
  components:{Button, Table},
  data() {
    return {
      clientsTableLayout:
          {
            columns: [
              {
                name: "id",
                header: "id",
                valueRef: "id"
              },
              {
                name: "organization_name",
                header: "Название организации",
                valueRef: "organizationName"
              },
              {
                name: "contact_person",
                header: "Контактное лицо",
                valueRef: "contactPerson.fullName"
              },
              {
                name: "phone",
                header: "Телефон",
                valueRef: "contactPerson.phone"
              },
              {
                name: "client_type",
                header: "Тип клиента",
                valueRef: "clientType"
              }
            ]
          }
    }
  },
  methods: {
    ...mapGetters({
      GET_ALL: 'client/GET_ALL_CLIENTS'
    }),
    ...mapActions({
      FETCH: 'client/LOAD'
    })
  },

  mounted() {
    this.FETCH();
  }
}
</script>

<style scoped>
h2 {
  margin-left: 1rem;
}
Table {
  margin-top: 1em;
}
</style>
