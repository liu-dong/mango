<template><!--一个template里面只能有一个标签-->
  <div id="index">
    <h1 v-if="status">{{ message }}</h1>
    <label>
      <input v-model="message">
    </label>
    <button v-on:click="reverseMessage">反转</button>
    <ol>
      <li v-for="todo in todoList">
        {{ todo.text }}
      </li>
    </ol>
    <router-link to="/success">成功</router-link>
    <router-link to="/fail">失败</router-link>
  </div>
</template>
<script>
    export default {
        name: 'Index',
        data() {
            return {
                message: 'Hello World Vue!',
                status:true,
                todoList:[
                    {text:"vue"},
                    {text:"vue-cli"},
                    {text:"vue-router"}
                ]
            }
        },
        methods: {
            reverseMessage : function () {
                this.message = this.message.split('').reverse().join('');
            }
        }
    }
</script>
<style></style>
