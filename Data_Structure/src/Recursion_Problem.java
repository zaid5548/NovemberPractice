
public class Recursion_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printInterval(4);
		printRuler(2, 4);
	}

	public static void print(int n,int val) {
		
		for(int i=0;i<n;i++) {
			System.out.print("-");
		}
		if(val!=-1)
		System.out.println(val);
		else
			System.out.println();
	}
	
	public static void printRuler(int inch,int maxL) {
		
		for(int i=0;i<inch;i++) {
			print(maxL,i);
			printInterval(maxL-1);
		}
		print(maxL,inch);
		
	}
	
	public static void printInterval(int n) {
		if(n==0) {
			return;
		}
		printInterval(n-1);
		print(n,-1);
		printInterval(n-1);
		
	}
	
}
