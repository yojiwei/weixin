package com.wx.message;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

import com.wx.accesstoken.WeixinAccessToken;
import com.wx.util.WeixinJson;
/**
 * 发送微信消息
 * @author Administrator
 *
 */
public class WeixinSendMessage {
     
	public String sendMessage(){
		String access_token = new WeixinAccessToken().GetAccessToken();
		String URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+access_token;
		String jsons = "{\"touser\":\"oTnGruMretQPHreWMMBfTnXxI1Uo\",\"msgtype\":\"text\",\"text\":{\"content\":\"Hello World\"}}";
	        byte[] xmlData = jsons.getBytes();           

	         InputStream instr  = null;

	         java.io.ByteArrayOutputStream out = null;             

	          try{                         

	                 URL url = new URL(URL);               

	                 URLConnection urlCon = url.openConnection();              

	                 urlCon.setDoOutput(true);             

	                 urlCon.setDoInput(true);              

	                 urlCon.setUseCaches(false);                           

	                 urlCon.setRequestProperty("Content-Type", "text/xml");      

	                 urlCon.setRequestProperty("Content-length",String.valueOf(xmlData.length));

	                 System.out.println(String.valueOf(xmlData.length));

	                 DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());           

	                 printout.write(xmlData);              

	                 printout.flush();             

	                 printout.close();             

	                 instr = urlCon.getInputStream();  
	                 
	                 byte[] bis = IOUtils.toByteArray(instr);

	                 String ResponseString = new String(bis, "UTF-8"); 

	                if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {

	                     System.out.println("返回空");

	                    }

	               System.out.println("返回数据为:" + ResponseString);

	              return ResponseString;   

	          }catch(Exception e){             

	                 e.printStackTrace();

	                return "0";

	          }            

	          finally {            

	                 try {         

	                        out.close();  

	                        instr.close(); 

	                         

	                 }catch (Exception ex) {     

	                        return "0";

	                     }                 

	                 }                 

	}  
	public static void main(String args[]){
		WeixinSendMessage wxsm = new WeixinSendMessage();
		wxsm.sendMessage();
	}
}

