package com.louis.mango.admin.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码加密
 * @author Louis
 * @date Jan 13, 2019
 */
public class PasswordEncoder {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	private final static String MD5 = "MD5";
	private final static String SHA = "SHA";

	private Object salt;//盐值
	private String algorithm;//计算法则

    /**
     * 默认md5加密
     * @param salt
     */
	public PasswordEncoder(Object salt) {
		this(salt, MD5);
	}

    /**
     * 自定义加密方式 md5 sha
     * @param salt
     * @param algorithm
     */
	public PasswordEncoder(Object salt, String algorithm) {
		this.salt = salt;
		this.algorithm = algorithm;
	}

	/**
	 * 密码加密
	 * @param rawPass
	 * @return
	 */
	public String encode(String rawPass) {
		String result = null;
        MessageDigest md = null;
        try {
            //消息摘要 算法规则默认为md5
            md = MessageDigest.getInstance(algorithm);
            result = byteArrayToHexString(md.digest(mergePasswordAndSalt(rawPass).getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 加密后的字符串
		return result;
	}

	/**
	 * 密码匹配验证
	 * @param encPass 密文
	 * @param rawPass 明文
	 * @return
	 */
	public boolean matches(String encPass, String rawPass) {
		String pass1 = "" + encPass;
		//同样的盐值和同学的明文会生成同样的密码
		String pass2 = encode(rawPass);
		return pass1.equals(pass2);
	}

    /**
     * 合并密码和盐值
     * @param password
     * @return
     */
	private String mergePasswordAndSalt(String password) {
		if (password == null) {
			password = "";
		}
		if ((salt == null) || "".equals(salt)) {
			return password;
		} else {
			return password + "{" + salt.toString() + "}";
		}
	}

	/**
	 * 转换字节数组为16进制字串
	 *
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	private String byteArrayToHexString(byte[] b) {
		StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }
		return resultSb.toString();
	}

	/**
	 * 将字节转换为16进制
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static void main(String[] args) {
		String salt = "123456";
		PasswordEncoder encoderMd5 = new PasswordEncoder(salt, "MD5");
		String encode = encoderMd5.encode("123456");
		System.out.println(encode);
		boolean passwordValid = encoderMd5.matches("56b291d6ed9b9cb8e2d3dc09cb6377b9", "123456");
		System.out.println(passwordValid);
	}

}
