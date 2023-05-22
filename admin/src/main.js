import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./router.js";
import store from "./store/store.js";

router.beforeEach((to, from, next) => {
    document.title = to.name;
    next();
})

createApp(App)
    .use(router)
    .use(store)
    .mount('#app')
