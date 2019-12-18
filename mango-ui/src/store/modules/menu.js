export default {
  state: {
    navTree: [],//导航树
  },
  getters: {},
  mutations: {
    setNavTree(state, navTree) {
      state.navTree = navTree;
    }
  }
}
