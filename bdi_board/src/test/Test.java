package test;

public class Test {

	public static void main(String[] args) {
		String pattern = ".*(css|pang|gif|gs|js)|//*(userLogin|userJoin)";
		String uri = "test.css";
		System.out.println(uri.matches(pattern));
		uri = "/views/user/userLogin";
		System.out.println(uri.matches(pattern));
	}
}
