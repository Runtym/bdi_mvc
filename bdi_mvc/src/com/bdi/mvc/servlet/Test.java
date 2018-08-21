package com.bdi.mvc.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void changeDataType(String number) throws Exception{
		try {
			int num = Integer.parseInt(number);
		}catch(Exception nfe) {
			throw nfe;
		}
	}
	public static void main(String[] args) throws Exception {
		changeDataType("onetwo");
	}
}
