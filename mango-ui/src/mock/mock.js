import Mock from 'mockjs'
/*
* mockjs :用于生产随机数据，并拦截请求
* */
Mock.mock('http://localhost:8080/login', {
  'token': '3233201912132', // 令牌
})
Mock.mock('http://localhost:8080/user', {
  'name': '@name', // 随机生成姓名
  'name': '@email', // 随机生成邮箱
  'age|20-40': 5, // 年龄20-40之间
})
Mock.mock('http://localhost:8080/menu', {
  'id': '@increment', // id自增
  'name': 'menu', // 名称为menu
  'order|1-20': 5, // 排序1-20之间
})
