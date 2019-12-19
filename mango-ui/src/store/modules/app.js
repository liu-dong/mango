/**
 * 应用内全局性的配置，比如主题色，导航栏收缩状态
 */
export default {
    //state共享状态
    state: {
        appName: "Mango",  // 应用名称
        themeColor: "#14889A",  // 主题颜色
        oldThemeColor: "#14889A",   // 上一次主题颜色
        collapse: false,  // 导航栏收缩状态
        menuRouteLoaded: false    // 菜单和路由是否已经加载
    },
    getters: {
        collapse(state) {// 对应着上面state
            return state.collapse
        }
    },
    //变更state中值的唯一方法 通过commit、dispatch调用
    mutations: {
        onCollapse(state) {  // 改变收缩状态
            state.collapse = !state.collapse
        },
        setThemeColor(state, themeColor) {  // 改变主题颜色
            state.oldThemeColor = state.themeColor;
            state.themeColor = themeColor
        },
        menuRouteLoaded(state, menuRouteLoaded) {  // 改变菜单和路由的加载状态
            state.menuRouteLoaded = menuRouteLoaded;
        }
    },
    //类似mutations，提交的是 mutation，而不是直接变更状态
    actions: {}
}
