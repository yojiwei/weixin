package com.wx.message;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.wx.check.WeixinCheck;

public class WxMessage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡGet����
		String signature="";
		String timestamp="";
		String nonce= "";
		String echostr="";
		Enumeration en = req.getParameterNames();
        while (en.hasMoreElements()) {
            String paramName = (String) en.nextElement();
            if("signature".equals(paramName)){
            	signature = req.getParameter(paramName);
            }
            if("timestamp".equals(paramName)){
            	timestamp = req.getParameter(paramName);
            }
            if("nonce".equals(paramName)){
            	nonce = req.getParameter(paramName);
            }
            if("echostr".equals(paramName)){
            	echostr = req.getParameter(paramName);
            }

        }
		//��֤΢����ʵ��
		String reback = new WeixinCheck().reBackString(signature, timestamp, nonce, echostr);
		System.out.println("--------------"+reback);
		resp.getWriter().print(reback);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedReader in = null;
		StringBuffer temp = new StringBuffer();
		String msgtype = "";
		String xmls = "";
		try {
			//��ȡPost xml���ݰ�
			ServletInputStream inStream = req.getInputStream();
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
			byte[] buff = new byte[8192]; //buff���ڴ��ѭ����ȡ����ʱ����
			int rc = 0;
			while ((rc = inStream.read(buff, 0, 1024)) > 0) {
			  swapStream.write(buff, 0, rc);
			}
			byte[] in_b = swapStream.toByteArray(); //in_bΪת��֮��Ľ��?
			xmls = new String(in_b); //�����ܵ�������ת����String
			xmls = new String(xmls.getBytes("gbk"), "utf-8");//������������
			
		}catch (Exception e) {
			// TODO: handle exception
		} 

		System.out.println("xmls=========="+xmls);
		WeixinAcceptMessage wam = new WeixinAcceptMessage();
		String reb = wam.acceptMessage(xmls);
		resp.getWriter().write(reb);
	}
}
