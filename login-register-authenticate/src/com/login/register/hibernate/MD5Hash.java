package com.login.register.hibernate;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {

	public static String md5(String input) {

		String md5 = null;
		String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
		input = input + salt;

		if (null == input)
			return null;

		try {
			// create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			// update input string in message digest
			digest.update(input.getBytes(), 0, input.length());

			// converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(md5);
		return md5;
	}
}