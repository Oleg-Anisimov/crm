import {createRouter, createWebHistory} from "vue-router";
import MainPage from "./pages/MainPage.vue";
import DealsPage from "./pages/deals/DealsPage.vue";
import ClientsPage from "./pages/clients/ClientsPage.vue";
import PaymentsPage from "./pages/PaymentsPage.vue";
import DealCreationPage  from "./pages/deals/DealCreationPage.vue";
import SingleDealPage from "./pages/deals/SingleDealPage.vue";
import ClientCreationPage from "./pages/clients/ClientCreationPage.vue";
import SettingsPage from "./pages/SettingsPage.vue";

export default createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'Сделки',
            component: DealsPage,
        },
        {
            path: '/deals',
            name: 'Deals',
            component: DealsPage
        },
        {
            path: '/deal/:id',
            name: 'Сделка',
            component: SingleDealPage,
            props: true
        },
        {
            path: '/clients',
            name: 'Clients',
            component: ClientsPage
        },
        {
            path: '/clients/new',
            name: 'Создание клиента',
            component: ClientCreationPage
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
        },
        {
            path: '/settings',
            name: 'Настройки',
            component: SettingsPage
        },

    ]
})