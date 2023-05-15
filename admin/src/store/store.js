import {createStore} from "vuex";
import {deals} from "./dealsStore.js";
import {status} from "./statusStore.js";

let store = createStore({
    modules: {
        deals,
        status
    }
})

export default store;