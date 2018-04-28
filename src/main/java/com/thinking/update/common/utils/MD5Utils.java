package com.thinking.update.common.utils;


public class MD5Utils {
	private static final String SALT = "1qazxsw2";

	private static final String ALGORITH_NAME = "md5";

	private static final int HASH_ITERATIONS = 2;

	public static String encrypt(String pswd) {
		return pswd;
	}

	public static String encrypt(String username, String pswd) {
		return pswd;
	}
	public static void main(String[] args) {
		
		System.out.println(MD5Utils.encrypt("admin", "1"));
	}

}
