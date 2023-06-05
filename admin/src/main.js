import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./router.js";
import store from "./store/store.js";

let isAuthenticated = function () {
    let data = store.getters["users/AUTHENTICATED"]
    console.log(data)
    return data
}

router.beforeEach((to, from, next) => {

    if (to.fullPath === '/auth' || isAuthenticated()) {
        document.title = to.name
        next();
    } else {
        next('/auth');
    }
})

createApp(App)
    .use(router)
    .use(store)
    .mount('#app')
