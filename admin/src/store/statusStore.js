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
        ADD_STATUS: (state, status) => {
          state.statuses.push(status)
        },
        UPDATE_STATUS_LIST: (state, statuses) => {
            state.statuses = statuses
        },
        UPDATE_SINGLE_STATUS: (state, status) => {
            for (const key in state.statuses) {
                if (status.id === state.statuses[key].id) {
                    state.statuses[key] = status
                }
            }
        },
        REMOVE_STATUS: (state, status) => {
            for (const key in state.statuses) {
                if (status.id === state.statuses[key].id) {
                    state.statuses[key] = null
                }
            }
        }
    },
    actions: {
        FETCH({commit}) {
            let url = '/api/statuses'
            return axios.get(url).then((response) => {
                commit('UPDATE_STATUS_LIST', response.data)
                return response.data
            })
        },
        UPDATE({commit}, status) {
            let url = '/api/statuses/update'
            return axios.post(url, status)
                .then(response => {
                    if (response.status === 200) {
                        commit('UPDATE_SINGLE_STATUS', status)
                    }
                    return response;
                })
        },
        CREATE({commit}, status) {
            let url = '/api/statuses/create'
            return axios.post(url, status)
                .then(response => {
                    if (response.status === 200) {
                        commit('ADD_STATUS', response.data)
                    }
                    return response;
                })
        },
        DELETE({commit}, status) {
            let url = '/api/statuses/delete'
            return axios.post(url, status)
        }
    }
}