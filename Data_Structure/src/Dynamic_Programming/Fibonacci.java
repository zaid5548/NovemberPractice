package Dynamic_Programming;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
//		System.out.println("Using Recursion "+fibonacci(n));
		System.out.println("Using TopDown DP "+fibonacciTD(n,new int[n+1]));
		System.out.println("Using BottomUP Dp "+fibonacciBU(n));
		System.out.println("Using BottomUP Dp "+fiboBUSpaceEfficient(n));
	}

	// Using Recursion
	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fn1 = fibonacci(n - 1);
		int fn2 = fibonacci(n - 2);

		int fn = fn1 + fn2;

		return fn;

	}
	
	//Using TopDown Dynamic Programming
	
	public static int fibonacciTD(int n,int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}

		//re-use
		if(strg[n]!=0) {
			return strg[n];
		}
		
		int fn1 = fibonacciTD(n - 1,strg);
		int fn2 = fibonacciTD(n - 2,strg);

		int fn = fn1 + fn2;
		
		strg[n]=fn;//store
		
		return fn;
	}

	
	//Using BottomUP Dynamic Programming Approach
	public static int fibonacciBU(int n) {
		
		int[] strg=new int[n+1];
		
		//base
		strg[0]=0;
		strg[1]=1;
		
		for(int i=2;i<=n;i++) {
			strg[i]=strg[i-1]+strg[i-2];
		}
		
		return strg[n];
		
	}
	
	
	//Bottom UP Space Efficient
	public static int fiboBUSpaceEfficient(int n) {
		int[] strg=new int[2];
		
		strg[0]=0;
		strg[1]=1;
		
		for(int i=2;i<=n;i++) {
			int temp=strg[0];
			strg[0]=strg[1];
			strg[1]=temp+strg[0];
		}
		
		return strg[1];
	}
	
	
}
