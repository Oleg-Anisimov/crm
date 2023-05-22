<template>
    <div>
    <h2>Клиенты</h2>
    <Table :layout="clientsTableLayout" :values="GET_ALL()"/>
  </div>
</template>

<script>
import Table from "../components/layout/Table.vue";
import {mapActions, mapGetters} from "vuex";

export default {
  name: "Clients page",
  components:{Table},
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
  display: inline-block;
}
</style>
