<template>
<div class="content">
 <h1>
    Создание сделки
  </h1>
  <text-field label="Название" type="text" placeholder="Введите название сделки"/>
  <text-field label="Описание" type="text-area" placeholder="Введите описание"/>
  <number-field label="Цена" type="text" placeholder="Введите цену в рублях"/>
  <select-field label="Ответственные" type="text" placeholder="Выберите ответственного" :options="persons"/>
  <select-field label="Клиент" type="text" placeholder="Выберете клиента" :options="clients"/>
  <p></p>
  <custom-button label="Создать" color="primary"/>
  
</div>
</template>

<script>
import TextField from "@/components/TextField.vue"
import NumberField from "@/components/NumberField.vue"
import CustomButton from "@/components/Button.vue"
import SelectField from "@/components/SelectField.vue"
export default {
  name: "DealCreationPage", 
  components:{TextField,NumberField,CustomButton,SelectField},
  data() {
    return {
      persons: [
          'option-1',
          'option-2',
          'option-3',
          'option-4',
          'option-5'
      ],
      clients :[
          'Иванов И.И.',
          'Петров П.П.',
          'Смирнов C.C.'
      ]
    }
  }
}
</script>

<style scoped>
.content {
  border-radius: 8px;
  border: 1px solid #242424;
  padding: 1em 1em;
  max-width: 1000px;
}
</style>