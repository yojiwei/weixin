package com.wx.usermanage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;

import com.wx.accesstoken.WeixinAccessToken;
import com.wx.util.WeixinJson;

/**
 * 用户管理
 * @author Administrator
 *
 */
public class WeixinUserManage {
	/**
	 * https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID
	 * 获取关注用户列表
	 * @param access_token
	 * @return
	 */
	public String getUserlist(String access_token){
		JSONArray jsons = new JSONArray();
		StringBuilder json = new StringBuilder();
		try {
			// WebService URL
			String service_url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token+"&next_openid=";
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


		} catch (Exception e) {
			System.err.println(e);
		}
		return json.toString();
	}
	
	public static void main(String args[]){
		WeixinUserManage wxum = new WeixinUserManage();
		System.out.println(wxum.getUserlist(new WeixinAccessToken().GetAccessToken()));
	}
}
