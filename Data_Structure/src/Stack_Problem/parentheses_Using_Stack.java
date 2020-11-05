package Stack_Problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class parentheses_Using_Stack {

	public static void main(String[] args) {
		String str="([{}])"; 
		if (isParanthesisBalanced(str)) 
			System.out.println("Balanced "); 
		else
			System.out.println("Not Balanced ");

	}

	private static boolean isParanthesisBalanced(String str) {
		
		Deque<Character> stack=new ArrayDeque<>();
		
		for(int i=0;i<str.length();i++) {
			
			char ch=str.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
				continue;
			}
			
			if(stack.isEmpty())
				return false;
			
			char check;
			switch (ch) {
			case ')':
				check=stack.pop();
				if(ch=='[' || ch=='{')
					return false;
				break;
			case ']':
				check=stack.pop();
				if(ch=='(' || ch=='{')
					return false;
				break;
			case '}':
				check=stack.pop();
				if(ch=='[' || ch=='(')
					return false;
				break;
			}
			
		}
		
		return (stack.isEmpty());
	}

}
