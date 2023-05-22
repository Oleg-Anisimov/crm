import axios from "axios";

export const deals = {
    namespaced: true,
    state: {
        deals: []
    },

    getters: {
        GET_ALL_DEALS(state) {
            return state.deals
        },
        GET_DEAL_BY_STATUS: (state) => (status) => {
            return state.deals.filter(deal => deal.statusId === status)
        },
        GET_DEAL_BY_ID: (state) => (id) => {
            return state.deals.find(deal => deal.id === id)
        }
    },

    mutations: {
        UPDATE_DEAL_LIST: (state, deals) => {
            state.deals = deals
        },
        UPDATE_DEAL: (state, deal) => {
            console.log(deal)
            for (let i = 0; i < state.deals.length; i++) {
                let currentDeal = state.deals[i];
                if (currentDeal.id === deal.id) {
                    state.deals[i] = deal;
                }
            }
        }
    },
    actions: {
        FETCH_ALL({commit}) {
            const url = '/api/deals'
            return axios.get(url)
                .then((response) => {
                    commit('UPDATE_DEAL_LIST', response.data)
                    console.log(response)
                    return response.data
                })
                .catch(error => console.log(error))
        },
        FETCH_SINGLE({commit}, id) {
            const url = `/api/deals/${id}`
            return axios.get(url).then((response) => {
                commit('UPDATE_DEAL', response.data)
                return response.data
            }).catch(error => console.log(error))
        },
        CREATE_DEAL() {
        }, //todo: complete deal creating
        DELETE_DEAL() {
        }, //todo: complete deleting deal
        UPDATE_DEAL({commit}, deal) {
            console.log('action update')
            commit('UPDATE_DEAL', deal)
        }
    }
}