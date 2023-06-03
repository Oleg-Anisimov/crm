<template>
  <div class="deal_card">
    <h4>#{{ deal.id }}: {{ deal.title }}</h4>
    <table>
      <tr>
        <td>Цена:</td>
        <td>{{ deal.price }}</td>
      </tr>
      <tr>
        <td>Клиент:</td>
        <td>
          <client-preview :organizationName="getClientById(deal.clientId).organizationName || getClientById(deal.clientId).contactPerson.shortName" :person="getClientById(deal.clientId).contactPerson"/>
        </td>
      </tr>
      <tr>
        <td>Ответственные:</td>
        <td>{{ getUserById(deal.userId).getShortName() }}</td>
      </tr>
      <tr>
        <td>Срок:</td>
        <td>10.06.2023</td>
      </tr>
    </table>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {mapGetters} from "vuex";
import ClientPreview from "./ClientPreview.vue";

export default defineComponent({
  name: "DealCard",
  components: {ClientPreview},
  props: ['deal'],
  computed: {
    ...mapGetters({
      GET_USER_BY_ID: "users/GET_USER_BY_ID",
      GET_CLIENT_BY_ID: "client/GET_CLIENT_BY_ID",
    }),
    getUserById() {
      return (id) => {
        return this.GET_USER_BY_ID(id)
      }
    },
    getClientById() {
      return (id) => {
        let client = this.GET_CLIENT_BY_ID(id);
        return client
      }
    }
  }
})
</script>

<style scoped>

.deal_card {
  padding: 1em;
  text-align: left;
  background-color: #f8f8f8;
  border-radius: 5px;
  margin-bottom: 0.5em;
}


.deal_card:active {
  opacity: 10;
}

.deal_card > h4 {
  margin: 0;
}

.user > p {
  display: inline-block;
}

.user > img {
  width: 30px;
  height: 30px;
}
</style>