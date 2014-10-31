package com.wx.test;

import java.io.IOException;
/**
 * ◊÷µ‰œÓ≈≈–Ú
 * @author Administrator
 *
 */
public class DictionarySequence {
	public String[] reBackStrings(String[] args) {
		String [] strArray =  args;//new String[]{"red","yellow","Black","Green"};
		   String t = null;
		   System.out.println("≈≈–Ú«∞");
		   for(String s : strArray)
			   System.out.print(s+"\t");
		   int i,j,k;
		   for(i=0;i<strArray.length-1; i++)
		   {
			   k=i;
			   for(j=i+1;j<strArray.length;j++)
			   {
				 Character c1 = Character.valueOf(strArray[j].charAt(0));
				 Character c2 = Character.valueOf(strArray[k].charAt(0));
		     	    if(c1.compareTo(c2)<0)
		     	    	k=j;
			   }
			   if(i!=k)
			   {
				 t=strArray[i];
				 strArray[i]=strArray[k];
				 strArray[k]=t;
			   }
		   }
	                         System.out.println("\n≈≈–Ú∫Û:");
		             for(String s : strArray)
	                              System.out.print(s+"\t");
		             return strArray;
	   }
}
