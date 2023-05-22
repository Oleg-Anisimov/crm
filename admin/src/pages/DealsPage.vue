<template>
  <div>
    <h1>Сделки</h1>

    <router-link to="/deals/new">
      <Button label="Создать" color="second"/>
    </router-link>

    <div class="content">
      <deals-list v-for="item in statuses" :key="item.id" :deals="getDealsByStatus(item.id)" :status="item.name" :title="item.name"/>
    </div>
  </div>
</template>

<script>
import DealCard from "../components/DealCard.vue";
import Button from "../components/control/Button.vue";
import draggable from 'vuedraggable'
import {mapActions, mapGetters} from "vuex";
import DealsList from "../components/DealsList.vue";
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
      fetchClients: 'client/LOAD'
    }),
    ...mapGetters({
      GET_ALL_DEALS: 'deals/GET_ALL_DEALS',
    }),

    getDealsByStatus(id) {
      return this.deals.filter(deal => deal.statusId === id)
    },

    onItemChange(e, list) {
      if (e.added) {
        this.UPDATE_DEAL({
          deal: e.added.element,
          newStatus: list
        })
      }
    }
  },

  //hooks
  mounted() {
    this.fetchDeals().then(data => this.deals = data)
    this.loadStatuses().then(data => this.statuses = data)
    this.fetchClients()
  },
}
</script>

<style scoped>
  .content {
    display: grid;
    grid-template-columns: 300px 300px 300px 300px;
    grid-column-gap: 1em;
    margin: 0 auto;
  }
</style>