/*
* 将axios封装成插件，按插件方式引入
* 并且将API模块挂载在Vue原型的$api对象上
* */
// 导入所有接口
import api from './api'

const install = Vue => {
    if (install.installed)
        return;

    install.installed = true;

    Object.defineProperties(Vue.prototype, {
        // 注意，此处挂载在 Vue 原型的 $api 对象上
        $api: {
            get() {
                return api
            }
        }
    })
};

export default install
