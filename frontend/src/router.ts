import {createRouter, createWebHistory} from "vue-router";
import DealsPage from "./page/DealsPage.vue";
import BlankPage from "./page/BlankPage.vue";
import DealCreationPage from "./page/DealCreationPage.vue";
import ClientsPage from "./page/ClientsPage.vue";
import Typography from "./components/Typography.vue";

export default createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'Main',
            component: BlankPage,
        },
        {
            path: '/deals',
            alias: '/deals',
            name: 'deals',
            component: DealsPage

        },
        {
            path: '/clients',
            alias: '/clients',
            name: 'clients',
            component: ClientsPage

        },
        {
            path: '/deals/new',
            alias: '/deals/new',
            name: 'deals-creation',
            component: DealCreationPage
        },
    ]
})