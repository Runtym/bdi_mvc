package test;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void test(Map<String,String> map) {
		map.put("out", "난 나가는놈");
	}
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		test(map);
		System.out.println(map.get("out"));
	}
}
