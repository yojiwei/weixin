package com.wx.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Element;
import org.omg.CORBA.Request;

import com.wx.check.WeixinCheck;
import com.wx.util.WeixinXmlElement;

/**
 * ����΢�ŷ��������͹�������Ϣ��ָ���
 * 
 * @author Administrator
 * 
 */
public class WeixinMessage extends HttpServlet {
	
	public String acceptMessage(HttpURLConnection httpurlconnection,HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = null;
		StringBuffer temp = new StringBuffer();
		String msgtype = "";
		try {
			//��ȡPost����
			in = new BufferedReader(new InputStreamReader(
					httpurlconnection.getInputStream()));
			
			String inputLine = in.readLine();
			while (inputLine != null) {
				temp.append(inputLine);
				inputLine = in.readLine();
			}

			//��ȡGet����
			String signature="";
			String timestamp="";
			String nonce= "";
			String echostr="";
			Enumeration en = request.getParameterNames();
	        while (en.hasMoreElements()) {
	            String paramName = (String) en.nextElement();
	            if("signature".equals(paramName)){
	            	signature = request.getParameter(paramName);
	            }
	            if("timestamp".equals(paramName)){
	            	timestamp = request.getParameter(paramName);
	            }
	            if("nonce".equals(paramName)){
	            	nonce = request.getParameter(paramName);
	            }
	            if("echostr".equals(paramName)){
	            	echostr = request.getParameter(paramName);
	            }

	        }
			//��֤΢����ʵ��
			String reback = new WeixinCheck().reBackString(signature, timestamp, nonce, echostr);
			if("0".equals(reback)){
				//��֤�ɹ�
				return new WeixinAcceptMessage().acceptMessage(temp.toString());			
			}else{
				//��֤ʧ��
				System.out.println(reback);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return temp.toString();
	}
	
}
