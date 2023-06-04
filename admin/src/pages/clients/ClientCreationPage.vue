<template>
  <div class="content">
    <h1>
      Создание сделки
    </h1>
    <text-field label="Название организации" type="text" placeholder="ООО Рога и копыта" @valueChanged="value => client.organizationName = value"/>
    <text-field label="Контактное лицо" type="text" placeholder="Иванов Иван Иванович" @valueChanged="value => setFullName(value)"/>
    <text-field label="Телефон" type="text" placeholder="+7 (495) 000-00-00" :mask="'+7 (###) ###-##-##'" @valueChanged="value => contactPerson.phone = value"/>
    <select-field label="Тип клиента" type="text" placeholder="Выберите тип клиента" :options="clientTypeOptions" @itemSelected="item => client.clientType = item.value"/>
    <p></p>
    <custom-button label="Создать" color="primary" @click="convertAndSend"/>
  </div>
</template>

<script>
import TextField from "@/components/control/TextField.vue"
import NumberField from "@/components/control/NumberField.vue"
import CustomButton from "@/components/control/Button.vue"
import SelectField from "@/components/control/SelectField.vue"
import SelectableItem from "@/model/selectableItem.js";
import Client from "@/model/client.js";
import {mapActions} from "vuex";
import router from "../../router.js";

export default {
  name: "DealCreationPage",
  components: {TextField, NumberField, CustomButton, SelectField},
  data() {
    return {
      contactPerson: {},
      client: new Client()
    }
  },
  methods: {
    ...mapActions({
      createClient: "client/CREATE"
    }),
    setFullName(fullName) {
      let arr = fullName.split(' ');
      this.contactPerson.firstName = arr[0]
      this.contactPerson.secondName = arr[1]
      this.contactPerson.middleName = arr[2]
    },

    convertAndSend() {
      this.client.contactPerson = this.contactPerson;
      this.createClient(this.client).then(response => {
        if (response.status === 200) {
          router.push({path: '/clients'})
        }
      })

    }
  },

  computed: {
    clientTypeOptions: () => {
      return [
        new SelectableItem(1, 'Корпоративный', 'CORPORATE'),
        new SelectableItem(2, 'Физ. лицо', 'PERSONAL')
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
  max-width: 800px;
}

h1 {
  margin-top: 0;
}
</style>