import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/auth/Login.vue';
import Register from '@/views/auth/Register.vue';

Vue.use(Router)

export const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    // Security
    {
      path: '/login',
      component: Login
    },
    {
      path: '/register',
      component: Register
    },
    {
      path: '/my_journal',
      component: () => import('@/views/Index'),
      children: [
        // Dashboard
        {
          name: 'Today',
          path: 'today',
          component: () => import('@/views/today/Today'),
        },
        {
          name: 'Diary',
          path: 'archive',
          component: () => import('@/views/diary/Diary'),
        },
        {
          name: 'Dashboard',
          path: 'dashboard',
          component: () => import('@/views/dashboard/Dashboard'),
        },
        {
          name: 'Calendar',
          path: 'calendar',
          component: () => import('@/views/calendar/Calendar'),
        },
        {
          name: 'User Profile',
          path: 'profile',
          component: () => import('@/views/profile/Profile'),
        },
      ],
    },
  ],
})

router.beforeEach((to, from, next) => {
  const publicPages = ['/login', '/register'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');
  // trying to access a restricted page + not logged in
  // redirect to login page
  if (authRequired && !loggedIn) {
    console.log("2")
  } else {
    next();
  }
});
