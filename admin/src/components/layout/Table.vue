<template>
  <table>
    <thead>
      <tr>
        <td v-for="header in getHeaders"> {{header}}</td>
      </tr>
    </thead>
    <tbody>
      <tr v-for="row in getRows"  :class="[{'selected': row.ref === selectedItem}]" @click="onItemSelected(row.ref)">
        <td v-for="cell in row.cells"  > {{cell}} </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "Table",
  emits: ['itemSelected'],
  props: ['layout', 'values'],
  data() {
    return {
      selectedItem: null
    }
  },
  methods: {
    onItemSelected(item) {
      this.selectedItem = item
      this.$emit('itemSelected', item)
    },
    clear() {
      this.selectedItem = null
    }
  },
  computed: {
    getHeaders() {
      return this.layout.columns.map(item => item.header);
    },
    getRows() {
      return  this.values.map(object => {
        let currentRow = [];
        this.layout.columns.forEach(column => {
          if (column.valueRef.includes('.')) {
            let names = column.valueRef.split('.')
            let obj = object
            for(let i = 0; i < names.length; i++) {
              obj = obj[names[i]]
            }
            currentRow.push(obj)
          } else {
            currentRow.push(object[column.valueRef])
          }
        })
        return {
          cells: currentRow,
          ref: object
        };
      })
    }
  }
})
</script>

<style scoped>
table {
  border-collapse: collapse;
  width: 100%;
}

thead {
  background-color: #092C4C;
  color: #fff;
  font-weight: 600;
}

thead > tr {
  border-radius: 5px;

}

tbody > tr:nth-child(even) {
  background-color: #f3f3f3;
}

tbody > tr:nth-child(odd) {
  background-color: #fff;
}

.selected {
  background-color: var(--primary-active) !important;
  color: #fff;
}

td {
  padding: 0.8em;
}

</style>