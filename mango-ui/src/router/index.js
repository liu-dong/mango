import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/Home'
import Login from '@/views/Login'
import NotFound from '@/views/404'
/*import Index from '@/components/index'
import Success from '@/components/success'
import Fail from '@/components/fail'*/

Vue.use(Router)

export default new Router({
  // mode:"history", //去掉路由中的#
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },{
      path: '/login',
      name: 'Login',
      component: Login
    },{
      path: '/404',
      name: 'notFound',
      component: NotFound
    },
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})
