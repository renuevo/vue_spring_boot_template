// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'admin-lte'
import 'admin-lte/dist/css/AdminLTE.min.css'
import 'admin-lte/dist/css/skins/_all-skins.min.css'
import '@fortawesome/fontawesome-free/css/all.min.css'
import 'semantic-ui-css/semantic.min.css'
import 'chart.js/dist/Chart.bundle.min'
import Vue from 'vue'
import App from './App'
import {store} from './vuex/store'
import router from './router'
import axios from 'axios'


Vue.config.productionTip = false;
Vue.prototype.$server_host_name = 'http://172.20.38.57:8080';
Vue.prototype.$context_name = '/workshop';
Vue.prototype.$http = axios;


document.body.className = 'hold-transition skin-blue-light sidebar-mini';

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  store,
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
