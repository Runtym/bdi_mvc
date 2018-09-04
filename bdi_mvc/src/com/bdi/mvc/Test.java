package com.bdi.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static Map<String,String> map;
	public static int idx = 1;
	
	public static void doGetSomething() {
		if(map==null) {
			System.out.println("map 메모리 생성");
			map = new HashMap<String,String>();
		}
		System.out.println(idx++ + "번 doGet 호출!!");
	}
	public static void main(String[] args) {
		doGetSomething();
		doGetSomething();
		doGetSomething();
		doGetSomething();
		doGetSomething();
		doGetSomething();
		doGetSomething();
		doGetSomething();
		doGetSomething();
		doGetSomething();
	}
}
