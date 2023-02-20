import {defineStore} from "pinia";
import Client from "../../model/client";

private interface clientsState {
    clients: Array<Client>
}

export const useClients = defineStore('clients', {
    state: () => {
        return {
            clients: []
        }
    },
    actions: {
        loadClients() {

        }
    }
})