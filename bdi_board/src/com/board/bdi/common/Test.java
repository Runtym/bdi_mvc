package com.board.bdi.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Person{
	private String name;
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String name6;

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getName5() {
		return name5;
	}

	public void setName5(String name5) {
		this.name5 = name5;
	}

	public String getName6() {
		return name6;
	}

	public void setName6(String name6) {
		this.name6 = name6;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", name1=" + name1 + ", name2=" + name2 + ", name3=" + name3 + ", name4="
				+ name4 + ", name5=" + name5 + ", name6=" + name6 + "]";
	}
	
}
public class Test {

	public static <T> T parseMap(Map<String,String> map, Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		T p1 = (T)clazz.newInstance();
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String meth = key.substring(0, 1).toUpperCase() + key.substring(1);
			Method m1 = clazz.getMethod("set" + meth,String.class);
			m1.invoke(p1, map.get(key));
		}
		return p1;
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "조치헌");
		map.put("name1", "박규원");
		map.put("name2", "최명권");
		map.put("name3", "한승우");
		map.put("name4", "김민혁");
		map.put("name5", "박경훈");
		map.put("name6", "동동이");
		Person p = parseMap(map, Person.class);
		System.out.println(p);
	}
}
