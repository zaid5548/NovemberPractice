package String;

public class reverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abcdef";
		System.out.println(reverseString(str));
		System.out.println(reverseRecursion(str));
	}

	public static String reverseString(String str) {
		
		String res="";
		for(int i=str.length()-1;i>=0;i--) {
			res+=str.charAt(i);
		}
		return res;
	}
	
	public static String reverseRecursion(String str) {
		
		if(str.isEmpty()) {
			return str;
		}
		
	    return reverseString(str.substring(1)) + str.charAt(0);
	}
	
}
