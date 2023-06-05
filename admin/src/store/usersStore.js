import axios from "axios";
import User from "../model/user.js";
import qs from "qs";


export const users = {
    namespaced: true,
    state: {
        currentUser: null,
        users: []
    },

    getters: {
        AUTHENTICATED(state) {
            return state.currentUser || localStorage.getItem('currentUser')
        },
        GET_CURRENT_USER(state) {
            return state.currentUser
        },
        GET_ALL_USERS: (state) => state.users,
        GET_USER_BY_ID: (state) => (id) => {
            return state.users.find(user => user.id === id)
        },
    },

    mutations: {
        ADD_USER: (state, user) => {
          state.users.push(user)
        },
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
        SET_CURRENT_USER: (state, authResult) => {
            localStorage.setItem('currentUser', JSON.stringify(authResult))
            state.currentUser = authResult
        }
    },

    actions: {
        LOGIN({commit}, credentials) {
            let url = '/api/perform_login';
            const options = {
                method: 'POST',
                data: qs.stringify(credentials)
            }
            return axios(url, options)
                .then((response) => {
                    console.log(response.data)
                    commit('SET_CURRENT_USER', response.data)
                    return response
                })
        },
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
        CREATE({commit}, user) {
            let url = '/api/users/create'
            return axios.post(url, user).then(response => {
                if (response.status === 200) {
                    let dto = response.data
                    commit('ADD_USER', new User(dto.id, dto.firstName, dto.secondName, dto.middleName, dto.phone, dto.email, dto.roleId))
                }
            })
        },
        UPDATE() {},
        DELETE() {}
    }
}