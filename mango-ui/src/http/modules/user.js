import axios from '../axios'

/*
 * 用户管理模块
 *    在axios中，params是添加到url的请求字符串中的，用于get请求。
 *               data是添加到请求体（body）中的， 用于post请求。
 */

// 保存
export const save = (data) => {
  return axios({
    url: '/user/save',
    method: 'post',
    data
  })
};
// 删除
export const batchDelete = (data) => {
  return axios({
    url: '/user/delete',
    method: 'post',
    data
  })
};
// 分页查询
export const findPage = (data) => {
  return axios({
    url: '/user/findPage',
    method: 'post',
    data
  })
};
// 查询用户信息
export const findByName = (params) => {
  return axios({
    url: '/user/findByName',
    method: 'get',
    params
  })
};
// 查找用户的菜单权限标识集合
export const findPermissions = (params) => {
  return axios({
    url: '/user/findPermissions',
    method: 'get',
    params
  })
};
// 更新用户密码
export const updatePassword = (params) => {
  return axios({
    url: '/user/updatePassword',
    method: 'get',
    params
  })
};
