import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/Layout.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Layout,
    children:[
      {
        path: "/test",
        name:"Test",
        component: ()=> import('../views/admin/Test')
      },
      {
        path: "/test2",
        name:"Test2",
        component: ()=> import('../views/admin/Test2')
      },
      {
        path: "/articleManage",
        name:"ArticleManage",
        component: ()=> import('../views/admin/articleManage')
      },
      {
        path: "/categoryManage",
        name:"CategoryManage",
        component: ()=> import('../views/admin/categoryManage')
      },
      {
        path: "/userManage",
        name:"UserManage",
        component: ()=> import('../views/admin/userManage')
      },
      {
        path: "/menuManage",
        name:"MenuManage",
        component: ()=> import('../views/admin/menuManage')
      },
      {
        path: "/userTypeManage",
        name:"UserTypeManage",
        component: ()=> import('../views/admin/userTypeManage')
      },
    ]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/login',
    name: 'Login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/Login')
  },
  {
    path: '/register',
    name: 'Register',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/Register')
  },


]

const router = new VueRouter({
  //路由模式
  mode: 'history',
  routes
})

export default router
