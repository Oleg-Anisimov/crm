<script setup lang="ts">
import CustomButton from "../components/Button.vue";
import SelectField from "@/components/SelectField.vue";
import TextField from "@/components/TextField.vue";
import NumberField from "@/components/NumberField.vue";
</script>
<template>
  <h2>Новая сделка</h2>
  <div class="content">
    <div>
      <text-field label="Название" type="text" placeholder="Введите название сделки"/>
      <text-field label="Описание" type="text-area" placeholder="Введите название сделки"/>
      <select-field label="Клиент" type="text" placeholder="Выберите клиента" :options="options"/>
      <select-field label="Ответственные" type="text" placeholder="Выберите клиента" :options="options"/>

      <number-field label="Сумма" placeholder="Введите сумму"/>

      <p></p>

      <custom-button label="Создать" color="primary"/>



    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: "DealCreationPage",
  data() {
    return {
      options: [
          'option-1',
          'option-2',
          'option-3',
          'option-4',
          'option-5'
      ]
    }
  }

})
</script>

<style scoped>
.content {
  border-radius: 8px;
  border: 1px solid #242424;
  padding: 1em 1em;
  max-width: 800px;
}
</style>