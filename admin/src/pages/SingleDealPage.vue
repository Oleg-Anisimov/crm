<template>
  <div>
    <h1>TEsty</h1>

    <div class="content">
      <div>
        <div class="deal-details">
        </div>
      </div>
      <div class="deal-properties">
        <table>
          <tbody>
          <tr>
            <td>Статус:</td>
            <td>Новая</td>
          </tr>
            <tr>
              <td>Цена:</td>
              <td>1111.12</td>
            </tr>
            <tr>
              <td>Клиент:</td>
              <td>Иванов И.И.</td>
            </tr>
            <tr>
              <td>Ответственный:</td>
              <td>Степанов И.И.</td>
            </tr>
          <tr>
              <td>В архиве:</td>
              <td>нет</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import {mapActions, mapGetters} from "vuex";

export default {
  name: "SingleDealPage",
  props: ['id'],
  data() {
    return {
      currentDeal: null,
      loading: false
    }
  },
  methods: {
    ...mapActions({
      fetchData: 'deals/FETCH_SINGLE'
    })
  },

  mounted() {
    let promise = this.fetchData(52);
    promise.then(data => {
      console.log(data)
    })
  }
}
</script>

<style scoped>
.content {
  padding: 1em 1em;
  display: grid;
  grid-template-columns: 1fr 300px;
}

.deal-properties {
  background-color: #f6f8ff;
  border-radius: 5px;
}

td {
  padding: 1em;
}

h1 {
  margin-top: 0;
  margin-bottom: 0;
}
</style>