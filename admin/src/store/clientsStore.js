import axios from "axios";
import Client from "../model/client.js";

export const client = {
    namespaced: true,
    state: {
        clients: []
    },

    getters: {
        GET_ALL_CLIENTS: (state) => state.clients,
        GET_CLIENT_BY_ID: (state) => (id) => {
            return state.clients.find(client => client.id === id)
        },
    },

    mutations: {
        UPDATE_ALL_CLIENTS: (state, clients) => {
            state.clients = clients
        },
    },
    actions: {
        LOAD({commit}) {
            let url = '/api/client/getAll'
            axios.get(url)
                .then((response) => {
                    let allClients = []
                    response.data.forEach(current => {
                        let client = new Client()
                        client.id = current.id
                        client.clientType = current.clientType
                        client.phone = current.phone
                        client.fullName = current.person
                        allClients.push(client)
                    })
                    commit('UPDATE_ALL_CLIENTS', allClients)
                })
        },
        CREATE() {}, //todo: complete
        DELETER() {}, //todo: complete
    }
}