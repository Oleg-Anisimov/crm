<template>
  <table>
    <thead>
      <tr>
        <td v-for="header in headers"> {{header}}</td>
      </tr>
    </thead>
    <tbody>
      <tr v-for="row in values">
        <td v-for="cell in row"> {{cell}} </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "Table",
  props: ['layout', 'values'],
  data() {
    let headers = this.layout.columns.map(item => item.header)
    let rows = this.values.map((object) => {
      let row = []
      this.layout.columns.forEach(colunm => {
        row.push(object[colunm.valueRef])
      })
      return row
    })
    return {
      headers: headers,
      rows: rows
    }
  }
})
</script>

<style scoped>
table {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #123E89;
}

thead {
  background-color: #123E89;
  color: #fff;
  font-weight: 600;
}

tbody > tr:nth-child(even) {
  background-color: #fff;
}

tbody > tr:nth-child(odd) {
  background-color: #f3f3f3;
}

td {
  padding: 0.8em;
}

</style>