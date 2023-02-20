<template>
  <h2>Сделки</h2>
<!--  <button @click="this.$router.push('/deals/new')">New</button>-->
  <div class="content">
    <div class="column"><h2>На согласовании</h2>
      <div class="column_content" @drop="onDrop($event, 'agreement')" @dragenter="prevent" @dragover="prevent">
        <DealCard v-for="d in getList('agreement')" :deal="d" @dragstart="startDrag($event, d)"/>
      </div>
    </div>
    <div class="column"><h2>В обработке</h2>
      <div class="column_content" @drop="onDrop($event, 'in progress')" @dragenter.prevent @dragover.prevent>
        <DealCard v-for="d in getList('in progress')" :deal="d"  @dragstart="startDrag($event, d)"/>
      </div>
    </div>
    <div class="column"><h2>Доставка</h2>
      <div class="column_content" @drop="onDrop($event, 'delivery')" @dragenter.prevent @dragover.prevent>
        <DealCard v-for="d in getList('delivery')" :deal="d" @dragstart="startDrag($event, d)"/>

      </div>
    </div>
    <div class="column"><h2>Готово</h2>
      <div class="column_content" @drop="onDrop($event, 'done')" @dragenter.prevent @dragover.prevent>
        <DealCard v-for="d in getList('done')" :deal="d" @dragstart="startDrag($event, d)"/>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";
import DealCard from "../components/DealCard.vue";
import {ref} from "vue";
import dealsData from '../store/mock/deal.json'
import Deal from "../model/deal";

export default defineComponent({
  name: "DealsPage",
  components: {DealCard},
  data() {
    console.log(dealsData)
    return {
      dealsRef: ref(dealsData)
    }
  },
  methods: {
    prevent(event) {
      event.preventDefault()
    },
    startDrag(event, item)  {
      event.dataTransfer.dropEffect = 'move'
      event.dataTransfer.effectAllowed = 'move'
      event.dataTransfer.setData('item.id', item.id)
    },
    onDrop(event, status) {
      const id = parseInt(event.dataTransfer.getData('item.id'))
      const deal = this.dealsRef.find(d => d.id === id)
      deal.status = status
    },
    getList(status: String) {
      return this.dealsRef.filter(deal => deal.status === status)
    }
  }
})
</script>

<style scoped>

h2 {
  margin-left: 1rem;
  display: inline-block;
}
.content {
  width: 100%;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-column-gap: 1em;

}

.column {
  text-align: center;
}

.column_content {
  background-color: #f6f6f6;
  padding: 1em;
  display: grid;
  grid-gap: 1em;
  height: 100%;
}
</style>