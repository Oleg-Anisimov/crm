<template>
  <div>
    <div class="content">
      <div class="description">
        <h1>{{`#${deal?.id} - ${deal?.title}`}}</h1>
        <p>
          {{deal?.details}}
        </p>
        <div class="files">
          <p><b>Файлы</b></p>
          <div class="file"></div>
          <div class="file"></div>
          <div class="file"></div>
        </div>
      </div>
      <div class="details">
        <table>
          <tbody>
          <tr>
            <td>Статус:</td>
            <td><dropdown-button :items="statuses" :label="deal ? currentStatus : ''" @statusChosen="(item) => onStatusChosen(item)"/></td>
          </tr>
          <tr>
            <td>Сумма:</td>
            <td>{{ deal ? deal.price : "-"}}</td>
          </tr>
          <tr>
            <td>Клиент:</td>

            <td>
              <client-preview :organizationName="client?.organizationName || client?.contactPerson.shortName" :person="client?.contactPerson || '' "/>
            </td>
          </tr>
          <tr>
            <td>Ответственные: </td>
            <td>{{ deal ? user.getShortName() : '' }}</td>
          </tr>
          <tr>
            <td></td>
            <td></td>
          </tr>
          </tbody>
        </table>
      </div>


    </div>
  </div>
</template>

<script>
import {mapActions} from "vuex";
import DropdownButton from "../components/control/DropdownButton.vue";
import ClientPreview from "../components/ClientPreview.vue";

export default {
  name: "SingleDealPage",
  components: {ClientPreview, DropdownButton},
  props: ['id'],
  data() {
    return {
      deal: null,
      statuses: null,
      client: null,
      user: null,
      currentStatus: '',
      loading: false
    }
  },
  methods: {
    ...mapActions({
      fetchSingleDeal: 'deals/FETCH_SINGLE',
      fetchClient: 'client/FETCH_SINGLE',
      fetchUser: 'users/FETCH_SINGLE',
      fetchStatuses: 'status/FETCH',
      updateDeal: 'deals/UPDATE_DEAL'
    }),

    fetchData() {
      this.fetchSingleDeal(this.id).then(deal => {
        this.deal = deal;

        this.fetchStatuses().then(statuses => {
          this.statuses = statuses
          this.currentStatus = statuses.find(status => status.id === deal.statusId).name
        })

        this.fetchClient(deal.clientId).then(client => {
          this.client = client
        })

        this.fetchUser(deal.userId).then(user => {
          this.user = user
        })
      })
    },

    onStatusChosen(item) {
      this.currentStatus = item.name
      this.deal.statusId = item.id

      this.updateDeal(this.deal)
    }
  },

  mounted() {
    this.fetchData()
  }
}
</script>

<style scoped>
.content {
  display: grid;
  grid-template-columns: 1fr 300px;
  grid-column-gap: 1em;

  padding: 1em;
  max-width: 1500px;
  border-radius: 10px;
  border: 1px solid var(--primary);

}

.details {
  border-left: 1px solid var(--primary);
}

td {
  padding: 0.7em;
}

.content > p {
  margin: 0;
}

.file {
  display: inline-block;
  width: 100px;
  height: 100px;
  background-color: #536b81;
  padding: 1em 1em 1em 0;
  border-radius: 10px;
  border: 1px solid var(--primary);
  margin-left: 1em;
}
h1 {
  border-radius: 5px;
  margin-top: 0;
  margin-bottom: 0;
}
h1:hover {
  background-color: #eeeeee;
}
</style>