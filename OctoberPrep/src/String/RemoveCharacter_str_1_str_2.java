package String;

import java.util.HashMap;
import java.util.Set;

public class RemoveCharacter_str_1_str_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str1="india is a great";
//		String str2="in";
		String str1="india is great";
		String str2="in";
		removeCharacterFromFirstString(str1, str2);
	}

	public static void removeCharacterFromFirstString(String str1,String str2) {
		
		HashMap<Character, Integer> map=new HashMap<>();
		for(int i=0;i<str2.length();i++) {
			char ch=str2.charAt(i);
			if(map.containsKey(ch)) {
				int of=map.get(ch);
				map.put(ch, of+1);
			}else {
				map.put(ch, 1);
			}
		}
		
		HashMap<Character, Integer> map2=new HashMap<>();
		String res="";
		for(int i=0;i<str1.length();i++) {
			char ch=str1.charAt(i);
			if(map.containsKey(ch)) {
				
			}else if(map2.containsKey(ch)){
				int of1=map2.get(ch);
				map2.put(ch, of1+1);
				res+=ch;
			}else {
				res+=ch;
				map2.put(ch, 1);
			}
		}
		System.out.println(res);
	}
	
}
