package com.wx.check;

import java.util.ArrayList;

public class WeixinCheck{
	/**
	 * ΢����ַ������֤����
	 * ΢��У�顢��֤��Ϣ����ʵ��
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
		String backString = "";
		try {
			ArrayList als = new ArrayList(); 
			als.add(token);
			als.add(timestamp);
			als.add(nonce);
			//�ֵ�������
			als = new DictionarySequ().reBackLists(als);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < als.size(); i++) {
				sb.append(als.get(i));
			}

			// Sha1����
			String afterSha1 = new Sha1().hex_sha1(sb.toString());
			System.out.println("afterSha1============="+afterSha1);
			//�ж�
			if (signature.equals(afterSha1)) {
				backString = echostr;
			} else {
				backString = error;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return backString;

	}

	public static void main(String args[]) {
		WeixinCheck wt = new WeixinCheck();
		String signature = "21bcb09b7a585d0c57d8e0c6c34f9e909e2ddeb9";//a3f3ced70adf021586106410f5dbf603a31b7a7f
		String timestamp = "1387947260";
		String nonce = "1387481411";
		String echostr = "5959187276850947324";
		String reback = wt.reBackString(signature, timestamp, nonce, echostr);
		System.out.println("reback================" + reback);
	}
}
