export const status = {
    namespaced: true,
    state: {
        statuses: [
            {id: 1, name: 'NEW'},
            {id: 2, name: 'AGREEMENT'},
            {id: 3, name: 'IN_PROGRESS'},
            {id: 4, name: 'DONE'},
        ]
    },

    getters: {
        GET_ALL_STATUSES: state => {return state.statuses},
    },

    mutations: {

    },
    actions: {
        LOAD() {}, //todo: complete
        CREATE() {}, //todo: complete
        DELETER() {}, //todo: complete
    }
}