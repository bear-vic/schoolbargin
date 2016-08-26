package utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class EncryptUtils {
	/*
	 * MD(Message Digest algorithm ，信息摘要算法)
	 * 通常我们不直接使用上述MD加密。通常将MD产生的字节数组交给BASE再加密一把，得到相应的字符串 Digest:汇编
	 */
	public static final String KEY_MD = "MD5";

	public static String MD5(String inputStr) {
		System.out.println("=======加密前的数据:" + inputStr);
		BigInteger bigInteger = null;
		try {
			MessageDigest md = MessageDigest.getInstance(KEY_MD);
			byte[] inputData = inputStr.getBytes();
			md.update(inputData);
			bigInteger = new BigInteger(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("MD5加密后:" + bigInteger.toString());
		return bigInteger.toString();
	}

	/*
	 * SHA(Secure Hash Algorithm，安全散列算法），数字签名等密码学应用中重要的工具，
	 * 被广泛地应用于电子商务等信息安全领域。虽然，SHA与MD通过碰撞法都被破解了， 但是SHA仍然是公认的安全加密算法，较之MD更为安全
	 */
	//public static final String KEY_SHA = "SHA-256";
	public static final String KEY_SHA = "SHA-1";
	public static String SHA(String inputStr) {
		BigInteger sha = null;
		byte[] inputData = inputStr.getBytes();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
			messageDigest.update(inputData);
			sha = new BigInteger(messageDigest.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sha.toString();
	}

}