<template>
  <div class="deal_card">
    <h4>#{{ deal.id }}: {{ deal.title }}</h4>
    <p>Цена: {{ deal.amount }}</p>
    <p>Клиент: Иванов И.И.</p>
    <p>Ответственные: Степанов Н.Н.</p>
  </div>
</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "DealCard",
  props: ['deal']
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