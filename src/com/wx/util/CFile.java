package com.wx.util;

import java.io.*;
import java.util.*;

public class CFile
{
   public CFile()
   {
   }

   /**
    * Method:append(File file,String content)
    * Description: ���ļ�β׷������
    * @param file
��  * @param content
    * return boolean
   @roseuid 3E14FEDF01E9
   */
   public static final boolean append(File file, String content)
   {
     return append(file.getName(),content);
   }

   /**
    * Method:append(String file,String content)
    * Description: ���ļ�β׷������
    * @param file
��  * @param content
    * return boolean
   @roseuid 3E15009501D5
   */
   public static final boolean append(String file, String content)
   {
     try
     {
       PrintWriter out = new PrintWriter(new FileWriter(file,true));
       out.println(content);
       out.close();
       return true;
     }catch(IOException e){
       e.printStackTrace() ;
       return false;
     }
   }

   /**
    * Method:append(String file,String content)
    * Description: ɾ���ļ�
    * @param file �ļ�·��
��  * @param content
    * return boolean
   @roseuid 3E15009501D5
   */
   public static final boolean delete(String file)
   {
     if(!Exist(file)) return false;
     File pFile=new File(file);
     pFile.delete();
     return true;
   }

   /**
    * Method:GetFileImage(String strFileName)
    * Description: ��ȡ�ļ�ͼ��
    * @param strFileName �ļ�����
    * return String
   @roseuid 3E15009501D5
   */
   public static final String GetFileImage(String strFileName)
   {
     String imageFile="";
     String FileExt="";

     FileExt=CFile.getFileExtName(strFileName);
     String strExt=FileExt.trim().toLowerCase();
     if(strExt.equals("txt"))
       imageFile = "txt.gif";
     else if(strExt.equals("gif"))
       imageFile = "gif.gif";
     else if(strExt.equals("htm")||strExt.equals("html"))
       imageFile = "htm.gif";
     else if(strExt.equals("xls"))
       imageFile = "xls.gif";
     else if(strExt.equals("ppt"))
       imageFile = "ppt.gif";
     else if(strExt.equals("doc"))
       imageFile = "doc.gif";
     else if(strExt.equals("zip")||strExt.equals("img"))
       imageFile = "zip.gif";
     else if(strExt.equals("rar"))
       imageFile = "rar.gif";
     else if(strExt.equals("lnk"))
       imageFile = "link.gif";
     else if(strExt.equals("xml")||strExt.equals("xsl"))
       imageFile = "xml.gif";
     else if(strExt.equals("jpg"))
       imageFile = "jpg.gif";
     else if(strExt.equals("mdb"))
       imageFile = "mdb.gif";
     else if(strExt.equals("bmp"))
       imageFile = "bmp.gif";
     else if(strExt.equals("asp"))
       imageFile = "Asp.gif";
     else if(strExt.equals("avi")||strExt.equals("mpg")||strExt.equals("mov"))
       imageFile = "avi.gif";
     else if(strExt.equals("mp3")||strExt.equals("rm"))
       imageFile = "mp3.gif";
     else if(strExt.equals("wav")||strExt.equals("mid"))
       imageFile = "wav.gif";
     else
       imageFile = "xls.gif";

     return imageFile;
   }

   /**
    * Method:Exist(String cstrPath)
    * Description: ����ļ�/Ŀ¼�Ƿ����
    * @param cstrPath �ļ�/Ŀ¼·��
    * return boolean
   @roseuid 3E15009501D5
   */
   public static final boolean Exist(String cstrPath)
   {
     boolean bRet=false;
     File newDir=new File(cstrPath);
     bRet = newDir.exists();// ��鸸Ŀ¼�Ƿ����
     return bRet;
   }

   /**
    * Method:CreateMultiFolder(String cstrPath)
    * Description: �����༶Ŀ¼
    * @param cstrPath Ŀ¼·��
    * return boolean
   @roseuid 3E15009501D5
   */
   public static final boolean CreateMultiFolder(String cstrPath)
   {
     boolean	bRet = true;
     String lpcstrParent;

     String	cstrParent;
     int iPos = 0;
     int iLen;

     if(cstrPath==null ||cstrPath.equals("")) 	return false;

     iLen = cstrPath.length();
     if (cstrPath.lastIndexOf('\\')!=-1)
       iPos = cstrPath.lastIndexOf('\\');
     else
       iPos = cstrPath.lastIndexOf('/');

     cstrParent = cstrPath.substring(0,iPos);

     if(cstrParent==null ||cstrParent.equals("")) return false; // Ŀ¼���ƴ���
     lpcstrParent = cstrParent.substring(0,cstrParent.length());
     if(cstrParent.length() > 3) // �������С��3����ʾΪ���̸�Ŀ¼
     {
       bRet = Exist(lpcstrParent);// ��鸸Ŀ¼�Ƿ����
     }

     if(!bRet)
       bRet = CreateMultiFolder(lpcstrParent); // ��Ŀ¼������,�ݹ���ô�����Ŀ¼

     if(bRet){ // ��Ŀ¼����,ֱ�Ӵ���Ŀ¼
       //bRet = CreateDirectory(cstrPath, NULL);
       File newDir=new File(cstrPath);
       if(!newDir.exists())
       {
         newDir.mkdirs(); //����·��
         bRet=true;
       }
     }
     return bRet;
   }


   /**
    * Method:getExtName(String strFile)
    * Description: ����ļ���չ��
    * @param strFile �ļ�����
    * return String ��չ��
   @roseuid 3E1500BE033C
   */
   public static final String getFileExtName(String strFile)
   {
     String strExtName="";
     int pos=-1;
     pos=strFile.lastIndexOf(".");
     if(pos==strFile.length())
       strExtName="dat";
     else
       strExtName=strFile.substring(pos+1);

     return strExtName;
   }


   /**
    * Method:getExtName(String strFile)
    * Description: ����ļ���չ��
    * @param strFile �ļ�����
    * return String ��չ��
   @roseuid 3E1500BE033C
   */
   public static final String getFileTitle(String strFile)
   {
     String strFileTitle="";
     int pos=-1;
     pos=strFile.lastIndexOf(".");
     if(pos==strFile.length())
       strFileTitle=strFile;
     else
       strFileTitle=strFile.substring(0,pos);

     return strFileTitle;
   }

   /**
    * Method:write(File file,String content)
    * Description: д�ļ�
    * @param file
��  * @param content
    * return boolean
   @roseuid 3E1500BE033C
   */
   public static final boolean write(File file, String content)
   {
     return write(file.getName(),content);
   }

   /**
    * Method:write(File file,String content)
    * Description: д�ļ�
    * @param file
��  * @param content
    * return boolean
   @roseuid 3E1500FB0380
   */
   public static final boolean write(String file, String content)
   {
     try
     {
       PrintWriter out = new PrintWriter(new FileWriter(file));
       out.println(content);
       out.close();
       return true;
     }catch(IOException e){
       e.printStackTrace() ;
       return false;
     }
   }

   /**
    * Method:read(File file)
    * Description: ���ļ�
    * @param file
    * return BufferedReader
   @roseuid 3E15012D030A
   */
   public static final BufferedReader read(File file)
   {
     if (file == null) return null;

     try{
       BufferedReader in = new BufferedReader( new FileReader(file));
       return in;
     }catch(IOException e){
       e.printStackTrace();
       return null;
     }
   }

   /**
    * Method:read(File file)
    * Description: ���ļ�
    * @param file
    * return BufferedReader
   @roseuid 3E1501960257
   */
   public static final BufferedReader read(String file)
   {
     if (file == null) return null;
     if (file.equals("")) return null;
     return read(new File(file));
   }

   public static final String[] listFiles(String dirString,String extension)
   {
     File dir;
     File files[];
     String strFileList[];
     String ls_ex[] = {".*"};
     FilenameFilter  filter;
     String temp;
     try{
       dir = new File(dirString);
       if (dir.isDirectory())
       {
         ls_ex[0] = extension;
         filter = new CFileFilter(ls_ex);
         strFileList = dir.list(filter);
         return strFileList;
       }
     }catch(Exception ex){
     }
     return null;
   }

   public static void main(String args[])
   {

     //append("d:\\log.txt","���Բ���");
    System.out.println(getFileTitle("sdfsdf.htm"));
     /*
     File _log = new File(".\\error.log");
     BufferedReader in = read(_log);
     String s;
     try
     {
       while((s=in.readLine())!=null)
       {
         System.out.println(s);
       }
     }catch(IOException e){
       e.printStackTrace();
     }
     */
     /*
     String s[];
     s = listFiles("c:\\test","java");
     for (int i=0;i<s.length ;i++)
     {
       System.out.println(s[i]);
     }
*/
   }
}
