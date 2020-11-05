package String;

import java.util.HashMap;

public class RemoveDuplicateCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RemoveDiplicate("javaisaprogramminglanguage"));
	}
	
	public static String RemoveDiplicate(String str) {
		String res="";
		HashMap<Character, Integer> map=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(map.containsKey(ch)) {
				int of=map.get(ch);
				if(of<2) {
					map.put(ch, of+1);
					res+=ch;
				}
			}else {
				res+=ch;
				map.put(ch, 1);
			}
		}
		return res;
	}

}
