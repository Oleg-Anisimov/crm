<template>
  <div>
    <h1>Сделки</h1>

    <router-link to="/deals/new">
      <Button label="Создать" color="second"/>
    </router-link>

    <div class="content">
      <deals-list v-for="item in statuses" :key="item.id" :deals="getDealsByStatus(item.id)" :status="item" :title="item.name"/>
    </div>
  </div>
</template>

<script>
import DealCard from "../../components/DealCard.vue";
import Button from "../../components/control/Button.vue";
import draggable from 'vuedraggable'
import {mapActions, mapGetters} from "vuex";
import DealsList from "../../components/DealsList.vue";
import {ref} from "vue";

export default {
  name: "DealsPage",
  components: {DealsList, Button, DealCard, draggable},
  data() {
    return {
      deals: null,
      statuses: null
    }
  },
  methods: {
    ...mapActions({
      loadStatuses: 'status/FETCH',
      fetchDeals: 'deals/FETCH_ALL',
      fetchClients: 'client/LOAD',
      fetchUsers: 'users/LOAD',
      updateDeal: 'deals/UPDATE_DEAL'
    }),
    ...mapGetters({
      GET_ALL_DEALS: 'deals/GET_ALL_DEALS',
      GET_DEAL_BY_ID: 'deals/GET_DEAL_BY_ID'
    }),

    getDealsByStatus(id) {
      return this.deals.filter(deal => deal.statusId === id)
    },
  },

  //hooks
  mounted() {
    this.fetchUsers()
    this.fetchClients()
    this.loadStatuses().then(data => this.statuses = data)
    this.fetchDeals().then(data => {
      console.log('fetched deals')
      console.log(data)
      this.deals = data
    })
  },
}
</script>

<style scoped>
  .content {
    display: grid;
    grid-template-columns: repeat(auto-fit, 300px);
    grid-column-gap: 1em;
    margin: 0 auto;
  }
</style>