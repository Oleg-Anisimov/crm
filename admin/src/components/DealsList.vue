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
        @change="e => onItemChange(e, status)">
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

    onItemChange(e, newStatus) {
      if (!e.added) return

      let deal = e.added.element
      deal.status = newStatus
      this.UPDATE_DEAL(deal)
    },
    navigateToDeal(id) {
      router.push(`/deal/${id}`)
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

.drag {
  background-color: #c0c0c0;
  border: 1px solid var(--second);
  opacity: 100%;
}

.ghost-new {
  border: 1px solid var(--error);
}
</style>