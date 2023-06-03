import axios from "axios";
import User from "../model/user.js";


export const users = {
    namespaced: true,
    state: {
        users: []
    },

    getters: {
        GET_ALL_USERS: (state) => state.users,
        GET_USER_BY_ID: (state) => (id) => {
            return state.users.find(user => user.id === id)
        },
    },

    mutations: {
        UPDATE_SINGLE_USER: (state, user) => {
            for (let i = 0; i < state.users.length; i++) {
                let current = state.users[i];
                if (current.id === user.id) {
                    state.users[i] = user;
                }
            }
        },
        UPDATE_ALL_USERS: (state, users) => {
            state.users = users
        },
    },

    actions: {
        FETCH_SINGLE({commit}, id) {
            let url = `/api/users/${id}`
            return axios.get(url)
                .then(response => {
                    const dto = response.data
                    const user = new User(dto.id, dto.firstName, dto.secondName, dto.middleName, dto.phone, dto.email, dto.roleId)
                    commit('UPDATE_SINGLE_USER', user)
                    return user
                })
        },
        LOAD({commit}) {
            let url = '/api/users'
            return axios.get(url)
                .then((response) => {
                    let userList = []
                    response.data.forEach(dto => {
                        userList.push(new User(dto.id, dto.firstName, dto.secondName, dto.middleName, dto.phone, dto.email, dto.roleId))
                    })
                    commit('UPDATE_ALL_USERS', userList)
                    return userList
                })
        },
        CREATE() {},
        DELETER() {},
    }
}