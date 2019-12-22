<template>
    <!--有子菜单的菜单-->
    <el-submenu v-if="menu.children && menu.children.length >= 1" :index="'' + menu.id">
        <template slot="title">
            <i :class="menu.icon"></i>
            <span slot="title">{{menu.name}}</span>
        </template>
        <MenuTree v-for="item in menu.children" :key="item.id" :menu="item">
        </MenuTree>
    </el-submenu>
    <!--无子菜单的菜单-->
    <el-menu-item v-else :index="'' + menu.id" @click="handleRoute(menu)">
        <i :class="menu.icon"></i>
        <span slot="title">{{menu.name}}</span>
    </el-menu-item>
</template>

<script>
    import {getIFramePath} from '@/utils/iframe'

    export default {
        name: 'MenuTree',
        props: {
            menu: {
                type: Object,
                required: true
            }
        },
        methods: {
            handleRoute(menu) {
                debugger
                // 如果是嵌套页面，转换成iframe的path
                let path = getIFramePath(menu.url);
                if (!path) {
                    path = menu.url
                }
                // 通过菜单URL跳转至指定路由
                this.$router.push("/" + path)
            }
        }
    }
</script>

<style scoped lang="scss">

</style>
