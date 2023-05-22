import axios from "axios";

export const status = {
    namespaced: true,
    state: {
        statuses: []
    },

    getters: {
        GET_ALL_STATUSES: state => {return state.statuses},
    },

    mutations: {
        UPDATE_STATUS_LIST: (state, statuses) => {
            state.statuses = statuses
        },
    },
    actions: {
        FETCH({commit}) {
            let url = '/api/statuses'
            return axios.get(url).then((response) => {
                commit('UPDATE_STATUS_LIST', response.data)
                return response.data
            })
        },
        CREATE() {}, //todo: complete
        DELETER() {}, //todo: complete
    }
}