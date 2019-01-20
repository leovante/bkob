import Vuex from 'vuex'
import Vue from 'vue'

Vue.use(Vuex)


export default new Vuex.Store({
  state: {token: null},
  getters: {token: state=>{return state.token}},
  mutations: {
    LOGIN_TOKEN(state,response){
    state.token=response.access_token;
    }}
})
