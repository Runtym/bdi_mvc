package com.bdi.mvc;

public class Test {

	public static int test() throws Exception{
		try {
			return Integer.parseInt("abc");
		}catch(Exception e) {
			throw e;
		}
	}

	public static int test(String str) {
		str = "abc";
		if(str.equals("abc")) {
			return 1;
		}else {
			return 2;
		}
	}
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
