import {defineStore} from "pinia";
import axios from "axios";

export const useClientStore = defineStore({
    id: 'client',
    state: () => ({
        clients: [],
        client: null,
        loading: false,
        error: null
    }),
    getters: {
      getClients() {
          return this.clients
      }
    },
    actions: {
        async fetchClients() {
            this.clients = [];
            this.loading = true;
            try {
                this.clients = await axios.get('/api/client/byAll')
                    .then((response) => response.data)
            } catch (error) {
                this.error = error;
                console.log(error);
            } finally {
                this.loading = false
            }
        }
    }
})