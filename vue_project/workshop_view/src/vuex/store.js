import Vuex from 'vuex';
import Vue from "vue";
import getters from "./getters";
import actions from "./actions";
import mutations from "./mutations";

Vue.use(Vuex);

const state = {
  userName: '',
  errorState: '',
  isAuth: false,
}

export const store = new Vuex.Store({
  state,
  mutations,
  getters,
  actions
});
