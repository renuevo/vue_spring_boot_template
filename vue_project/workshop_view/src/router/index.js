import Vue from 'vue'
import Router from 'vue-router'
import Matching from '@/components/Matching'
import List from '@/components/List'

const context = "/workshop"
Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: context + '/',
      name: 'Matching',
      component: Matching
    }, {
      path: context + '/list_info',
      name: 'List',
      component: List
    }
  ]
})
