import Vue from 'vue'
import Router from 'vue-router'
import Service from './../components/Service'
import User from './../components/User'
import Registration from './../components/Registration'     ////////добавить импорт компанента
import Login from './../components/Login'
import Chat from './../components/Chat'
import WebSocket from './../components/WebSocket'
import Footer from './../components/main/Footer'
import SocketTest from './../components/SocketTest'
import TestChat from './../components/TestChat'
import Profile from '../components/Profile'
import TestAxios from './../components/TestAxios'
import UserCatch from './../components/UserCatch'
import Main from './../components/main/Main'
import Admin from './../components/Admin'
import UserSet from '../components/UserSet'
import SlideTest from '../components/SlideTest'
import Header from './../components/main/Header'
import Authorization from '../components/Authorization'
import CryptoExchanger from '../components/crypto/CryptoExchanger'



Vue.use(Router);

export default new Router({
  mode:'history',
  routes: [
    {
      path:'/activate/:code',
      component:Authorization,

    },
    {
      path: '/callservice',
      name: 'Service',
      component: Service
    },
    {
      path: '/user',
      name: 'User',
      component: User
    },
    {
      path: '/registration',
      name: 'registration',
      component: Registration
    },

    {
      path: '/login',
      name: 'Login',
      component: Login
    },

    {
      path: '/chat',
      name: 'Chat',
      component: Chat
    },

    {
      path: '/WebSocket',
      name: 'WebSocket',
      component: WebSocket
    },

    {
      path: '/footer',
      name: 'Footer',
      component: Footer
    },

    {
      path: '/test',
      name: 'socketTest',
      component: SocketTest
    },

    {
      path: '/testchat',
      name: 'TestChat',
      component: TestChat
    },

    {
      path: '/userset',
      name: 'UserSet',
      component: UserSet
    },

    {
      path: '/main/profile',
      name:'profile',
      component: Profile
    },

    {
      path: '/axios',
      name: 'TestAxios',
      component: TestAxios
    },

    {
      path: '/catch',
      name: 'UserCatch',
      component: UserCatch
    },

    {
      path: '/main',
      name: 'main',
      component: Main,

    },

    {
      path: '/admin',
      name: 'admin',
      component: Admin
    },
    {
      path: '/slide',
      name: 'SlideTest',
      component: SlideTest
    },
    {
      path: '/header',
      name: 'Header',
      component: Header
    },
    {
      path: '/main/crypto',
      name: 'exchanger',
      component: CryptoExchanger
    },
  ]
})
