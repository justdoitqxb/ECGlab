package com.busycoder.util;

import java.security.MessageDigest;
import java.lang.Exception;
/*
 * MD5�����㷨���м���
 */
public class Encrypttion {
	public static String md5Encrypt(String str) throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
		return base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
	}
}