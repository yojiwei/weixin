package com.wx.util;

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WeixinJson {
	/**
	 * 根据JSON name 获取 JSON value
	 * 一层关系 {name:value}
	 * @param jsons
	 * @param name
	 * @return
	 */
	public String getJsonValue(String jsons,String name){
		JSONObject jsonobj=JSONObject.fromObject(jsons);//将字符串转化成json对象 
		String value=jsonobj.getString(name);//获取字符串。
		System.out.println(value);
		return value;
	}
	
	/**
	  * java解析json对象，解析出对象和字符串及数组并遍历出相应的值
	  */
	 
	 private static void strJsonObj(){
	  String json = "{'name': 'helloworlda','array':[{'a':'111','b':'222','c':'333'},{'a':'999'}],'address':'111','people':{'name':'happ','sex':'girl'}}";
	  JSONObject jsonobj=JSONObject.fromObject(json);//将字符串转化成json对象 
	  String name=jsonobj.getString("name");//获取字符串。
	  JSONArray array=jsonobj.getJSONArray("array");//获取数组
	  JSONObject obj=jsonobj.getJSONObject("people");//获取对象
	  
	  System.out.println("===============strJsonObj==================");
	  System.out.println("jsonobj : "+jsonobj);
	  System.out.println("array : "+array);
	  System.out.println("obj : "+obj.getString("name"));
	  
	  //遍历json对象
	   Iterator<?> objkey=obj.keys();  
	  while (objkey.hasNext()) {// 遍历JSONObject   
	       String aa2 = (String) objkey.next().toString();   
	       String bb2 = obj.getString(aa2);         
	       System.out.println(aa2+":"+bb2);
	  }   
	  //遍历数组
	  for (int i = 0; i < array.size(); i++) {   
	   System.out.println("item "+ i + " :" + array.getString(i));   
	  }
	 }
	 
	 public static void main(String args[]){
		 WeixinJson wxj = new WeixinJson();
		 //wxj.strJsonObj();
		 wxj.getJsonValue("{\"token\":\"abc123\"}", "token");
		 
	 }
	
}
