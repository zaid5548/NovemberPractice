package LeetCode_Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Letter_Case_Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String str=scn.nextLine();
	    List<String> ans=new ArrayList<>();
		ans=letterCase("a1b2");
		print(ans);
	}
	
	private static void print(List<String> ans) {
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i));
		}
	}

	public static List<String> letterCase(String S) {
        
        letterCasePermutation(S,"");
        return ll;
        
        
    }
    static List<String> ll=new ArrayList<>();
	
	public static void letterCasePermutation(String str,String ans) {
		if(str.length()==0) {
			ll.add(ans);
			return;
		}
		
		char ch=str.charAt(0);
		String ros=str.substring(1);
		
		if(Character.isUpperCase(ch) || Character.isLowerCase(ch)) {
			letterCasePermutation(ros, ans+Character.toLowerCase(ch));
			letterCasePermutation(ros, ans+Character.toUpperCase(ch));
		}else{
			letterCasePermutation(ros, ans+ch);
		}
	
		
	}

}
