package HashMap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CharacterMax_Frequency {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str=scn.nextLine();
		System.out.println(maxCharacter(str));

	}

	private static char maxCharacter(String str) {
		
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
		
		int max=Integer.MIN_VALUE;
		char ch=' ';
		
		Set<Character> keys=map.keySet();
		
		for(char key:keys) {
			if(map.get(key)>max) {
				max=map.get(key);
				ch=key;
			}
		}
		return ch;
	}

}
