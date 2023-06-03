<template>
  <div class="column">
    <h2>{{ title }}</h2>
    <draggable
        class="column_content"
        v-model="elements"
        group="deals"
        item-key="id"
        drag-class="drag"
        ghost-class="ghost-new"
        @change="e => onItemChange(e, status.id)">
      <template #item="{element}">
        <DealCard :deal="element" @dblclick="navigateToDeal(element.id)"/>
      </template>
    </draggable>
  </div>
</template>

<script>
import DealCard from "./DealCard.vue";
import Draggable from 'vuedraggable';
import {mapActions} from "vuex";
import router from "../router.js";

export default {
  name: "DealsList",
  components: {DealCard, Draggable},
  props: ['deals', 'status', 'title'],
  data() {
    return {
      elements: this.deals
    }
  },
  methods: {
    ...mapActions({
      UPDATE_DEAL: "deals/UPDATE_DEAL"
    }),

    onItemChange(e, status) {
      if (!e.added) return

      let deal = e.added.element
      deal.statusId = status
      this.UPDATE_DEAL(deal)
    },

    navigateToDeal(id) {
      router.push({path: `/deal/${id}`, params: {id: id}})
    }
  }
}
</script>

<style scoped>
.column {
  text-align: center;
}

.column_content {
  min-height: 50px;
  border: 2px dashed #e1e1e1;
  border-radius: 5px;
  padding: 0.5em;
  min-width: 200px;
}
</style>