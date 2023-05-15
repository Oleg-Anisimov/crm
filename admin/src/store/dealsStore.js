export const deals = {
    namespaced: true,
    state: {
        deals: [
            {id: 1, status: 'NEW', title: 'new  deal', amount: 111111 },
            {id: 11, status: 'NEW', title: 'new  deal', amount: 111111 },
            {id: 12, status: 'NEW', title: 'new  deal', amount: 111111 },
            {id: 2, status: 'AGREEMENT', title: 'agreement with customer', amount: 22222 },
            {id: 3, status: 'IN_PROGRESS', title: 'working on this', amount: 33333 },
            {id: 4, status: 'DONE', title: 'DONE DEAL', amount: 44444 }
        ]
    },

    getters: {
        GET_ALL_DEALS(state) {
            return state.deals
        },
        GET_DEAL_BY_STATUS: (state) => (status) => {return state.deals.filter(deal => deal.status === status)},
        GET_DEAL_BY_ID: (state) => (id) => { return state.deals.find(deal => deal.id === id)}
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
        FETCH_ALL() {}, //todo: complete loading deals from backend
        FETCH_SINGLE({commit}, id) {

        },
        CREATE_DEAL() {}, //todo: complete deal creating
        DELETE_DEAL() {}, //todo: complete deleting deal
        UPDATE_DEAL({commit}, deal) {
            console.log('action update')
            //todo: make request to backend
            commit('UPDATE_DEAL', deal)
        }
    }
}