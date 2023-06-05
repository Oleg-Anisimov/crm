<template>
  <h3>Пользователи</h3>
  <div class="content">
    <div>
      <div class="edit_dialog">

        <text-field ref="text-field" type="text" label="ФИО" placeholder="Иванов Иван Иванович" @value-changed="parseName"/>
        <text-field ref="text-field" type="text" label="Телефон" placeholder="+7 (495) 000-00-00" @value-changed="value => this.currentUser.phone = value"/>
        <text-field ref="text-field" type="text" label="Почта" placeholder="ivan@mail.com" @value-changed="value => this.currentUser.email = value"/>
        <text-field ref="text-field" type="password" label="Пароль" placeholder="ivan@mail.com" @value-changed="value => this.currentUser.password = value"/>

        <div class="button_block">
          <Button :label="editMode ? 'Сохранить' : 'Создать'" size="small" @click="save"/>
          <Button v-if="editMode" label="Отмена" color="second" size="small" @click="disableEditMode"/>
          <Button v-if="editMode" label="Удалить" color="red" size="small" @click="remove"/>
        </div>

      </div>
    </div>
    <Table ref="table" :layout="tableLayout" :values="getAll()" @item-selected="onItemSelected"/>
  </div>
</template>

<script>
import {mapActions, mapGetters} from "vuex";
import Table from "../components/layout/Table.vue";
import TextField from "../components/control/TextField.vue";
import Button from "../components/control/Button.vue";
import User from "../model/user.js";

export default {
  name: "UsersPage",
  components: {Button, TextField, Table},
  data() {
    return {
      editMode: false,
      currentUser: {},
      tableLayout: {
        columns: [
          {
            name: "id",
            header: "id",
            valueRef: "id"
          },
          {
            name: "secondName",
            header: "Фамилия",
            valueRef: "secondName"
          },
          {
            name: "firstName",
            header: "Имя",
            valueRef: "firstName"
          },
          {
            name: "middleName",
            header: "Отчество",
            valueRef: "middleName"
          },
          {
            name: "phone",
            header: "Телефон",
            valueRef: "phone"
          },
          {
            name: "email",
            header: "Почта",
            valueRef: "email"
          },
        ]
      }
    }
  },
  methods: {
    ...mapGetters({
      getAll: 'users/GET_ALL_USERS'
    }),
    ...mapActions({
      fetch: 'users/LOAD',
      delete: 'users/DELETE',
      create: 'users/CREATE',
      update: 'users/UPDATE',
    }),

    onItemSelected(item) {
      this.editMode = true
      this.currentUser = item;
    },

    parseName(name) {
      let arr = name.split(' ')
      this.currentUser.secondName = arr[0]
      this.currentUser.firstName = arr[1]
      this.currentUser.middleName = arr[2]
    },

    save() {
      if (this.editMode && this.currentUser.secondName) {

      } else {
        let user = new User(
            null,
            this.currentUser.firstName,
            this.currentUser.secondName,
            this.currentUser.middleName,
            this.currentUser.phone,
            this.currentUser.email,
            1
        )
        user.password = this.currentUser.password
        this.create(user)
      }
    },
    disableEditMode() {
      this.editMode = false;
      this.currentUser = {};

      this.$refs["text-field"].clear()
      this.$refs["table"].clear()

    },
    remove() {}
  },


  mounted() {
    this.fetch()
  }
}
</script>

<style scoped>

.content {
  display: grid;
  grid-template-columns: 450px 1fr;
  grid-column-gap: 1em;
}

.edit_dialog {
  border-radius: 10px;
  border: 1px solid var(--primary);
  padding: 1em;
  /*height: 200px;*/
}

.button_block {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-column-gap: 1em;
  padding-top: 0.5em;
}

text-field {
  margin-bottom: 1em;
}

</style>