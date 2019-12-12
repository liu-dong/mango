import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Index from '@/components/index'
import Success from '@/components/success'
import Fail from '@/components/fail'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/success',
      name: 'Success',
      component: Success
    },
    {
      path: '/fail',
      name: 'Fail',
      component: Fail
    }
  ]
})
