package com.wx.util;

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WeixinJson {
	/**
	 * ����JSON name ��ȡ JSON value
	 * һ���ϵ {name:value}
	 * @param jsons
	 * @param name
	 * @return
	 */
	public String getJsonValue(String jsons,String name){
		JSONObject jsonobj=JSONObject.fromObject(jsons);//���ַ���ת����json���� 
		String value=jsonobj.getString(name);//��ȡ�ַ�����
		System.out.println(value);
		return value;
	}
	
	/**
	  * java����json���󣬽�����������ַ��������鲢��������Ӧ��ֵ
	  */
	 
	 private static void strJsonObj(){
	  String json = "{'name': 'helloworlda','array':[{'a':'111','b':'222','c':'333'},{'a':'999'}],'address':'111','people':{'name':'happ','sex':'girl'}}";
	  JSONObject jsonobj=JSONObject.fromObject(json);//���ַ���ת����json���� 
	  String name=jsonobj.getString("name");//��ȡ�ַ�����
	  JSONArray array=jsonobj.getJSONArray("array");//��ȡ����
	  JSONObject obj=jsonobj.getJSONObject("people");//��ȡ����
	  
	  System.out.println("===============strJsonObj==================");
	  System.out.println("jsonobj : "+jsonobj);
	  System.out.println("array : "+array);
	  System.out.println("obj : "+obj.getString("name"));
	  
	  //����json����
	   Iterator<?> objkey=obj.keys();  
	  while (objkey.hasNext()) {// ����JSONObject   
	       String aa2 = (String) objkey.next().toString();   
	       String bb2 = obj.getString(aa2);         
	       System.out.println(aa2+":"+bb2);
	  }   
	  //��������
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
