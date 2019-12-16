package com.louis.mango.admin.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 自定义令牌对象
 * @author Louis
 * @date Jan 14, 2019
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;

	private String token;//token身份令牌

    /**
     * 实现了父类的构造方法
     * @param principal
     * @param credentials
     */
	public JwtAuthenticationToken(Object principal, Object credentials){
		super(principal, credentials);
	}

    /**
     * 实现了父类的构造方法，并为token赋值了
     * @param principal
     * @param credentials
     * @param token
     */
	public JwtAuthenticationToken(Object principal, Object credentials, String token){
		super(principal, credentials);
		this.token = token;
	}

	public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String token) {
		super(principal, credentials, authorities);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
