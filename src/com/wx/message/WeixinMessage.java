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
 * 接收微信服务器发送过来的信息、指令等
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
			//获取Post数据
			in = new BufferedReader(new InputStreamReader(
					httpurlconnection.getInputStream()));
			
			String inputLine = in.readLine();
			while (inputLine != null) {
				temp.append(inputLine);
				inputLine = in.readLine();
			}

			//获取Get数据
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
			//验证微信真实性
			String reback = new WeixinCheck().reBackString(signature, timestamp, nonce, echostr);
			if("0".equals(reback)){
				//验证成功
				return new WeixinAcceptMessage().acceptMessage(temp.toString());			
			}else{
				//验证失败
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
