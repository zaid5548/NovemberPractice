package String;

import java.util.Scanner;

public class PallindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String str=scn.nextLine();
		boolean ans=pallindromeString(str);
		if(ans) {
			System.out.println("String is Pallindrome");
		}else {
			System.out.println("String is Not Pallindrome");
		}
	}

	private static boolean pallindromeString(String str) {
		
		int lo=0;
		int hi=str.length()-1;
		while(lo<=hi) {
			char ch1=str.charAt(lo);
			char ch2=str.charAt(hi);
			if(ch1==ch2) {
				lo++;
				hi--;
			}else {
				return false;
			}
		}
		return true;
		
	}
	
}
