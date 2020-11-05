package String;

import java.util.HashMap;
import java.util.Set;

public class First_Non_Reapiting_Character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="geeksforgeeks";
		System.out.println(firstNonreapitingCharacter(str));
	}

	public static char firstNonreapitingCharacter(String str) {
		
		HashMap<Character, Integer> map=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(map.containsKey(ch)) {
				int of=map.get(ch);
				map.put(ch, of+1);
			}else {
				map.put(ch, 1);
			}
		}
		char ans=' ';
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(map.get(ch)==1) {
				ans=ch;
				break;
			}
		}
		return ans;
	}
	
}
