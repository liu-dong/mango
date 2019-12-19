import Vue from 'vue'
import vuex from 'vuex'
// 引入子模块
import app from './modules/app'
import tab from './modules/tab'
import iframe from './modules/iframe'
import user from './modules/user'
import menu from './modules/menu'

Vue.use(vuex);//vuex的作用：管理共享状态 主要包括state、getter、mutations、actions

const store = new vuex.Store({
  modules: {
    app: app,
    tab: tab,
    iframe: iframe,
    user: user,
    menu: menu
  }
});

export default store
