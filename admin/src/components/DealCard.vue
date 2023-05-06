<template>
  <div class="deal_card" draggable="true">
    <h4>#{{ deal.id }}: {{ deal.title }}</h4>
    <p>Цена: {{ deal.amount }}</p>
    <p>Ответственные: </p>
    <div v-for="person in deal.responsiblePeoples" class="user">
      <img src="avatar_mock.jpg" alt="">
      <p> {{ person.lastName }} </p>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent, PropType} from "vue";
import Deal from "../model/deal";

export default defineComponent({
  name: "DealCard",
  props: {
    deal: Object as PropType<Deal>
  }
})
</script>

<style scoped>

.deal_card {
  padding: 1em;
  text-align: left;
  background-color: #e8bbbb;
  height: 230px;
  cursor: move;
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