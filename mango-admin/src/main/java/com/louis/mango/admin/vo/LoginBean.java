package com.louis.mango.admin.vo;

/**
 * @author LD
 * @date 2019/12/15 22:04
 */
public class LoginBean {
    private String account;
    private String password;
    private String captcha;

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCaptcha() {
        return captcha;
    }
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
