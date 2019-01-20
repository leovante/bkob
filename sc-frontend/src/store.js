import Vuex from 'vuex'
import Vue from 'vue'
import VuexPersist from 'vuex-persist'

Vue.use(Vuex)
const vuexPersist = new VuexPersist({
  key: 'my-app',
  storage: localStorage
})

export default new Vuex.Store({
  state: {token: null},
  getters: {token: state=>{return state.token}},
  mutations: {
    LOGIN_TOKEN(state,response){
    state.token=response.access_token;
    }},
  plugins: [vuexPersist.plugin]
})
