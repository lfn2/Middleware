package application;

public class StringOperator {
	
	public String concat(String a, String b) {
		return a+b;
	}
	
	public String replace(String s, String toBeReplaced, String toReplace) {
		return s.replace(toBeReplaced, toReplace);
	}
	
	public String reverse(String s) {
		return new StringBuilder(s).reverse().toString();		
	}
	
	public String lowercase(String s) {
		return s.toLowerCase();
	}
	
	public String uppercase(String s) {
		return s.toUpperCase();
	}
	
}
