package com.wx.check;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class DictionarySequ {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("helloworld");
		list.add("1387947260");
		list.add("1387481411");
		
		/*
		 * ����Collections��sort������������������� sort����������Ҫ�� ����������һ������Ҫ���������Collection
		 * ��һ����һ��Comparator
		 */
		Collections.sort(list, new SpellComparator());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public ArrayList reBackLists(ArrayList lists){
		/*
		 * ����Collections��sort������������������� sort����������Ҫ�� ����������һ������Ҫ���������Collection
		 * ��һ����һ��Comparator
		 */
		ArrayList al = new ArrayList();
		Collections.sort(lists, new SpellComparator());
		for (int i = 0; i < lists.size(); i++) {
			al.add(lists.get(i));
		}
		return al;
	}
	
}

/**
 * ����ƴ������Ƚ���
 */
class SpellComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		try {
			// ȡ�ñȽ϶���ĺ��ֱ��룬������ת�����ַ���
			String s1 = new String(o1.toString().getBytes("GB2312"),
					"ISO-8859-1");
			String s2 = new String(o2.toString().getBytes("GB2312"),
					"ISO-8859-1");
			// ����String��� compareTo������������������бȽ�
			return s1.compareTo(s2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}