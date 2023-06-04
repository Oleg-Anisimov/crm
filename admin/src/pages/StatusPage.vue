<template>
  <h3>Статусы сделки</h3>
  <div class="content">
    <div>
      <div class="edit_dialog">
        <text-field ref="text-field" type="text" label="Название" :placeholder="editMode ? currentStatus.name : defaultPlaceholder" :default-value="currentStatus.name" @value-changed="text => this.currentStatus.name = text"/>
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
import Table from "../components/layout/Table.vue";
import TextField from "../components/control/TextField.vue";
import {mapActions, mapGetters} from "vuex";
import Button from "../components/control/Button.vue";

export default {
  name: "StatusPage",
  components: {
    'Button': Button,
    'text-field': TextField,
    'Table': Table},
  data() {
    return {
      editMode: false,
      defaultPlaceholder: 'Статус сделки',
      currentStatus: {
        id: null,
        name: ''
      },
      tableLayout: {
        columns: [
          {
            name: "id",
            header: "id",
            valueRef: "id"
          },
          {
            name: "Название",
            header: "Название",
            valueRef: "name"
          },
        ]
      }
    }
  },

  methods: {
    ...mapGetters({
      getAll: 'status/GET_ALL_STATUSES'
    }),
    ...mapActions({
      update: 'status/UPDATE',
      fetch: 'status/FETCH',
      create: 'status/CREATE',
      delete: 'status/DELETE'
    }),

    save() {
      if (this.editMode) {
        this.update(this.currentStatus)
      } else {
        this.create(this.currentStatus)
      }
      this.disableEditMode()
    },
    remove() {
      if (this.editMode && this.currentStatus) {
        this.delete(this.currentStatus).then(response => {
          if (response.status === 200) {
            this.fetch()
          }
        })
      }
      this.disableEditMode()
    },

    onItemSelected(item) {
      this.editMode = true
      this.currentStatus = item;
    },

    disableEditMode() {
      this.editMode = false;
      this.currentStatus = {};

      this.$refs["text-field"].clear()
      this.$refs["table"].clear()
    }
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

</style>