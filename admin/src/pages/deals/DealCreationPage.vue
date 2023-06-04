<template>
  <div class="content">
    <h1>
      Создание сделки
    </h1>
    <text-field label="Название" type="text" placeholder="Введите название сделки" @valueChanged="value => deal.title = value"/>
    <text-field label="Описание" type="text-area" placeholder="Введите описание" @valueChanged="value => deal.details = value"/>
    <number-field label="Цена" type="text" placeholder="Введите цену в рублях" @valueChanged="value => deal.price = value"/>
    <select-field label="Ответственные" type="text" placeholder="Выберите ответственного" :options="getUserOptions()" @itemSelected="item => deal.userId = item.value.id"/>
    <select-field label="Клиент" type="text" placeholder="Выберете клиента" :options="getClientOptions()"  @itemSelected="item => deal.clientId = item.value.id"/>
    <p></p>
    <custom-button label="Создать" color="primary" @click="this.createDeal"/>
  </div>
</template>

<script>
import TextField from "@/components/control/TextField.vue"
import NumberField from "@/components/control/NumberField.vue"
import CustomButton from "@/components/control/Button.vue"
import SelectField from "@/components/control/SelectField.vue"
import {mapActions, mapGetters} from "vuex";
import SelectableItem from "../../model/selectableItem.js";
import Deal from "../../model/deal.js";
import router from "../../router.js";

export default {
  name: "DealCreationPage",
  components: {TextField, NumberField, CustomButton, SelectField},
  data() {
    return {
      deal: new Deal()
    }
  },
  computed: {
    ...mapGetters({
      GET_ALL_CLIENTS: "client/GET_ALL_CLIENTS",
      GET_USER_BY_ID: "users/GET_USER_BY_ID",
      GET_CLIENT_BY_ID: "client/GET_CLIENT_BY_ID",
      GET_ALL_USERS: "users/GET_ALL_USERS"
    }),

    getUserOptions() {
      return () => {
        const userOptions = [];
        this.GET_ALL_USERS.forEach(user => {
          userOptions.push(new SelectableItem(user.id, user.getShortName(), user))
        })
        return userOptions;
      }
    },

    getClientOptions() {
      return () => {
        const clients = [];
        this.GET_ALL_CLIENTS.forEach(client => {
          clients.push(new SelectableItem(client.id, client.organizationName ? client.organizationName : client.contactPerson.shortName, client))
        });
        return clients;
      }
    }
  },
  methods: {
    ...mapActions({
      fetchUsers: 'users/LOAD',
      fetchClients: 'client/LOAD',
      uploadDeal: 'deals/CREATE_DEAL'
    }),

    createDeal() {
      this.uploadDeal(this.deal)
      router.push({path: '/deals'})
    }
  },

  mounted() {
    this.fetchClients()
    this.fetchUsers()
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