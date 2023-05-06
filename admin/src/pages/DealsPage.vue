<template>
  <div>
    <h1>Сделки</h1>

    <router-link to="/deals/new">
      <Button label="Создать" color="second"/>
    </router-link>

    <div class="content">
      <div class="column">
        <h2>Новая</h2>
        <div class="column_content"></div>
      </div>
      <div class="column">
        <h2>В работе</h2>
        <div class="column_content"></div>
      </div>
      <div class="column">
        <h2>Доставка</h2>
        <div class="column_content"></div>
      </div>
      <div class="column">
        <h2>Завершено</h2>
        <div class="column_content"></div>
      </div>
    </div>
  </div>
</template>

<script>
import DealCard from "../components/DealCard.vue";
import Button from "../components/Button.vue";

export default {
  name: "DealsPage",
  components: {Button, DealCard}

}
</script>

<style scoped>

  .content {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-column-gap: 1em;
  }

  .column {
    text-align: center;
  }

  .column_content {
    min-height: 50px;
    background-color: #e7e7e7;

  }

</style>