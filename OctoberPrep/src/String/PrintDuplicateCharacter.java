package String;

import java.util.HashMap;
import java.util.Set;

public class PrintDuplicateCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printDuplicateCharacter("zaidkhanB.TechEngineer");
	}

	public static void printDuplicateCharacter(String str) {
		String res="";
		HashMap<Character, Integer> map=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(map.containsKey(ch)) {
				int of=map.get(ch);
				if(of<2) {
					res+=ch+" ";
				}
				map.put(ch, of+1);
			}else {
				map.put(ch, 1);
			}
		}
		System.out.println(res);
	}
	
}
