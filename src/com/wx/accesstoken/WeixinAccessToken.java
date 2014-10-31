package com.wx.accesstoken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;

import com.wx.util.WeixinJson;

/**
 * ªÒ»°Œ¢–≈access token
 * 
 * @author Administrator
 * https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
 */
public class WeixinAccessToken {
	public String GetAccessToken() {
		String result = "";
		String appid = "";//wxaa9457dd88af1ec2
		String secret = "";//bd063774d41c8c08729485b24926209b
		JSONArray jsons = new JSONArray();
		StringBuilder json = new StringBuilder();
		try {
			// WebService URL
			String service_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret+"";
		        try {
		            URL oracle = new URL(service_url);
		            URLConnection yc = oracle.openConnection();
		            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		            String inputLine = null;
		            while ( (inputLine = in.readLine()) != null) {
		                json.append(inputLine);
		            }
		            in.close();
		        } catch (MalformedURLException e) {
		        } catch (IOException e) {
		        }

			
			//System.out.println("result==========="+json.toString());
			result = new WeixinJson().getJsonValue(json.toString(), "access_token");
			//{"access_token":"SUW_RiBUdp60XnPqzD-a3WOkubTfY_cF4F9NaUU7lpJO0hcV9PsmQQ7XafF6-SyaMVggwwJYcNqmtrqP--0Ti_r2Isqx3PMSQfcJbTgil4ZQfw23k102UYdva2_HJj2KGYOUdZn3kG_i8cBIMyHuJw","expires_in":7200}
			

		} catch (Exception e) {
			System.err.println(e);
		}
		return result;
	}
	
	public static void main(String args[]){
		WeixinAccessToken wxat = new WeixinAccessToken();
		wxat.GetAccessToken();
	}
}
