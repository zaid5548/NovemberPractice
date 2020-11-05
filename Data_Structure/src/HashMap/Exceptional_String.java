package HashMap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Exceptional_String {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str=scn.nextLine();
		int ln=str.length();
		if(ln>20) {
			System.out.println("Exceptional String");
		}else {
			maxCharacter(str);

		}
	}

	private static void maxCharacter(String str) {
		
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
		
		char ch=' ';
		String ans="";
		Set<Character> keys=map.keySet();
		
		for(char key:keys) {
			if(map.get(key)==1) {
				ans+=key;
			}
		}
		if(ans.length()>0) {
			System.out.println(ans);
		}else {
			System.out.println("Wrong Input");
		}
	}
	
}

//aapaajapsps
// tatkakakakll
