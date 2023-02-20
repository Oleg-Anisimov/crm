<template>
  <h2>Новая сделка</h2>
  <div class="content">
    <div>
        <p>Название</p>
        <input type="text">
        <p>Детали</p>

        <textarea/>
        <p>Клиент</p>

        <button>Создать</button>


    </div>
    <div>asdfasdf</div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: "DealCreationPage"
})
</script>

<style scoped>
.content {
  display: grid;
  grid-template-columns: 1fr;
  grid-gap: 1em;
}

.content > div{
  background-color: azure;
}
</style>