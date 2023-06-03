import axios from "axios";

export const client = {
    namespaced: true,
    state: {
        clients: []
    },

    getters: {
        GET_ALL_CLIENTS(state) {
            return state.clients;
        },
        GET_CLIENT_BY_ID: (state) => (id) => {
            return state.clients.find(client => client.id === id)
        },
    },

    mutations: {
        UPDATE_SINGLE_CLIENT: (state, client) => {
            for (let i = 0; i < state.clients.length; i++) {
                let current = state.clients[i];
                if (current.id === client.id) {
                    state.clients[i] = client;
                }
            }
        },
        UPDATE_ALL_CLIENTS: (state, clients) => {
            state.clients = clients
        },
    },
    actions: {
        FETCH_SINGLE({commit}, id) {
            let url = `/api/client/${id}`
            return axios.get(url)
                    .then(response => {
                        commit('UPDATE_SINGLE_CLIENT', response.data)
                        return response.data
                    })
        },
        LOAD({commit}) {
            let url = '/api/client/getAll'
            return axios.get(url)
                .then((response) => {
                    commit('UPDATE_ALL_CLIENTS', response.data)
                    return response.data
                })
        },
        CREATE() {},
        DELETE() {},
    }
}