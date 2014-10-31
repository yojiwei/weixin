package com.wx.test;

public class WeixinTest {
	/**
	 * 微信网址接入验证方法
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	public String reBackString(String signature, String timestamp,
			String nonce, String echostr) {
		String token = "helloworld";
		String error = "error";
		String[] strArray = new String[] { token, timestamp, nonce };
		//字典项排序
		strArray = new DictionarySequence().reBackStrings(strArray);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArray.length; i++) {
			sb.append(strArray[i]);
		}
		// Sha1加密
		String afterSha1 = new Sha1().hex_sha1(sb.toString());
		System.out.println("afterSha1===="+afterSha1);
		if (signature.equals(afterSha1)) {
			return echostr;
		} else {
			return error;
		}

	}

	public static void main(String args[]) {
		WeixinTest wt = new WeixinTest();
		String signature = "19740fcea300ea70788cd8f725cc49c7ae33bd65";
		String timestamp = "2013-12-23";
		String nonce = "111";
		String echostr = "a1b2c3";
		String reback = wt.reBackString(signature, timestamp, nonce, echostr);
		System.out.println("reback================" + reback);
	}
}
