package com.wx.message;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.jdom.Element;

import com.wx.util.CFile;
import com.wx.util.WeixinXmlElement;

/**
 * 接收微信信息
 * fjgw2014 gh_f5c8be861eeb
 * @author Administrator
 *
 */
public class WeixinAcceptMessage {
	public String acceptMessage(String xmls){
		
		Element element = null;
		StringBuffer sb = new StringBuffer();
		try {
			if(!"".equals(xmls)){
				element = new WeixinXmlElement().initEle(xmls);
				if(element!=null){
					List list = element.getChildren();
					for(int i=0;i<list.size();i++){
						System.out.print("element.name="+((Element)list.get(i)).getName());
						System.out.println("====element.value="+((Element)list.get(i)).getText());
						sb.append(((Element)list.get(i)).getName()+"===="+((Element)list.get(i)).getText());
						//存入数据库表中
						//dImpl.setValue((Element)list.get(i)).getName(),(Element)list.get(i)).getText(),CDataImpl.STRING);
						
					}
				}
			}
			if(!"".equals(sb.toString())){
				CFile.write("D:\\aaa.txt", sb.toString());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "<xml><ToUserName><![CDATA[meiwanmeilelehai]]></ToUserName><FromUserName><![CDATA[fjgw2014]]></FromUserName><CreateTime>12345678</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好,这是测试信息]]></Content></xml>";
	}
	
	public static void main(String args[]){
		WeixinAcceptMessage wxam = new WeixinAcceptMessage();
		String xmls = "<xml><URL><![CDATA[http://usercenter.pudong.gov.cn/axis/weixin]]></URL><ToUserName><![CDATA[fjgw2014]]></ToUserName><FromUserName><![CDATA[121896440]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[这是测试信息，请查看。]]></Content><MsgId>1234567890123456</MsgId></xml>";
		try {
			xmls = new String(xmls.getBytes("gbk"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wxam.acceptMessage(xmls);
	}
}
