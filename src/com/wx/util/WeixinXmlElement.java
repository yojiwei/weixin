package com.wx.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class WeixinXmlElement {

	/**
	 * 获取XMLS的元素
	 * @param xmls
	 * @param column
	 * @return
	 */
	public static String getChildColumn(String xmls, String column)
    {
        String regBegin = "<" + column + ">";
        String regEnd = "</" + column + ">";
        String regC = regBegin + "([\\w\\W]*?)" + regEnd;
        String returnStr = "";
        Pattern p = null;
        Matcher m = null;
        p = Pattern.compile(regC);
        m = p.matcher(xmls);
        if(m.find())
        {
            returnStr = m.group();
            returnStr = returnStr.replace(regBegin, "");
            returnStr = returnStr.replace(regEnd, "");
            try
            {
                returnStr = URLDecoder.decode(returnStr, "utf-8");
            }
            catch(IllegalArgumentException ex){
				System.out.println("catch=="+ex.getMessage());
			}
			catch(UnsupportedEncodingException e){
				System.out.println("CASUtil:"+e.getMessage());
			}
            return returnStr;
        } else
        {
            return returnStr;
        }
    }
	/**
	 * Description：初始化变量
	 * 
	 * @param fileStr
	 *            一段xml的字符串
	 */
	public Element initEle(String fileStr) {
		Document doc = null;

		SAXBuilder sb = null;

		Element element = null;
		try {
			sb = new SAXBuilder();
			InputStream inputStream = new ByteArrayInputStream(fileStr
					.getBytes("utf-8"));
			doc = sb.build(inputStream);
			element = doc.getRootElement();
		} catch (Exception ex) {
			System.out.println(" XML格式错误: " + ex.getMessage());
		}
		return element;
	}
}
