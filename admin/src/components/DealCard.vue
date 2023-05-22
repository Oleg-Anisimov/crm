<template>
  <div class="deal_card">
    <h4>#{{ deal.id }}: {{ deal.title }}</h4>
    <p>Цена: {{ deal.price }}</p>
    <p>Клиент: {{ getClientById(deal.clientId) }}</p>
    <p>Ответственные: Степанов Н.Н.</p>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {mapGetters} from "vuex";

export default defineComponent({
  name: "DealCard",
  props: ['deal'],
  computed: {
    ...mapGetters({
      GET_CLIENT_BY_ID: "client/GET_CLIENT_BY_ID"
    }),
    getClientById() {
      return (id) => {
        let client = this.GET_CLIENT_BY_ID(id);
        return client.fullName
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