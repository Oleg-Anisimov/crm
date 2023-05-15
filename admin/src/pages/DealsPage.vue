<template>
  <div>
    <h1>Сделки</h1>

    <router-link to="/deals/new">
      <Button label="Создать" color="second"/>
    </router-link>

    <div class="content">
      <deals-list v-for="item in statuses" :key="item.id" :deals="getDealByStatus(item.name)" :status="item.name" :title="item.name"/>
    </div>
  </div>
</template>

<script>
import DealCard from "../components/DealCard.vue";
import Button from "../components/control/Button.vue";
import draggable from 'vuedraggable'
import {mapActions, mapGetters} from "vuex";
import DealsList from "../components/DealsList.vue";

export default {
  name: "DealsPage",
  components: {DealsList, Button, DealCard, draggable},
  computed: {
    ...mapGetters({
      GET_DEAL_BY_ID: "deals/GET_DEAL_BY_ID",
      GET_DEAL_BY_STATUS: "deals/GET_DEAL_BY_STATUS",
      GET_ALL_STATUSES: 'status/GET_ALL_STATUSES'
    }),

    statuses(){
      return this.GET_ALL_STATUSES
    },

    getDealByStatus() {
      return (status) => this.GET_DEAL_BY_STATUS(status);
    },
  },
  methods: {
    ...mapActions({
      loadStatuses: 'status/LOAD'
    }),
    ...mapGetters({
      GET_ALL_DEALS: 'deals/GET_ALL_DEALS',
    }),

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
  beforeMount() {
    this.loadStatuses()
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