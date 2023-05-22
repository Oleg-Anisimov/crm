import {createStore} from "vuex";
import {deals} from "./dealsStore.js";
import {status} from "./statusStore.js";
import {client} from "./clientsStore.js";

let store = createStore({
    modules: {
        deals,
        status,
        client
    }
})

export default store;