package String;

public class ReverseWordInSentence {

	public static void main(String[] args) {
		reverseWord("This is an easy Java Program");
	}

	public static void reverseWord(String str) {
		
		String[] word=str.split(" ");
		System.out.println("**********");
		for(int i=0;i<word.length;i++) {
			System.out.print(word[i]+" ");
		}
		System.out.println("\n_ _ _ _ _ _ ___ __ __ __ __ _");
		String reverseWord="";
		for(int i=word.length-1;i>=0;i--) {
			reverseWord+=word[i]+" ";
		}
		System.out.println(reverseWord);
	}
	
}
