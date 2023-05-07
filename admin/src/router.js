import {createRouter, createWebHistory} from "vue-router";
import MainPage from "./pages/MainPage.vue";
import DealsPage from "./pages/DealsPage.vue";
import ClientsPage from "./pages/ClientsPage.vue";
import PaymentsPage from "./pages/PaymentsPage.vue";
import DealCreationPage  from "./pages/DealCreationPage.vue";

export default createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'Main',
            component: MainPage,
        },
        {
            path: '/deals',
            name: 'Deals',
            component: DealsPage
        },
        {
            path: '/clients',
            name: 'Clients',
            component: ClientsPage
        },
        {
            path: '/payments',
            name: 'Payments',
            component: PaymentsPage
        },
        {
            path: '/deals/new',
            name: 'Deal New',
            component: DealCreationPage
        }

    ]
})