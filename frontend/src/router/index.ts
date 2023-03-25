import AppVue from "../App.vue";
import LoginFormVue from "../components/LoginForm.vue";
import RegistrationFormVue from "../components/RegistrationForm.vue";
import { createRouter, createWebHistory } from "vue-router";

// const router = [
//   { path: "/", component: AppVue },
//   { path: "/login", component: LoginFormVue },
//   { path: "/register", component: RegistrationFormVue },
// ];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import("../views/HomeView.vue"),
    },
    {
      path: "/register",
      name: "register",
      component: () => import("../views/RegisterView.vue"),
    },
    {
      path: "/login",
      name: "login",
      component: () => import("../views/LoginView.vue"),
    },
    {
      path: "/items",
      name: "items",
      component: () => import("../views/ProductsView.vue"),
    },
  ],
});

export default router;