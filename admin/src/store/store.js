import {createStore} from "vuex";
import {deals} from "./dealsStore.js";
import {status} from "./statusStore.js";
import {client} from "./clientsStore.js";
import {users} from "./usersStore"

let store = createStore({
    modules: {
        deals,
        status,
        client,
        users
    }
})

export default store;