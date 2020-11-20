package Practice;

import java.util.Scanner;

public class Smallest_Number {
//	static int max=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		findSmallest(n);
	}
	private static void findSmallest(int n) {
		int[] res=new int[10000]; 
		int j=0;
		if(n<10) {
			System.out.println(n+10);
		}	
		for(int i=9;i>1;i--) {
			while(n%i==0) {
				n=n/i;
				res[j]=i;
				j++;
			}
		}
		if(n>10) {
			System.out.println("not possible");
			return;
		}	
		for(int i=j-1;i>=0;i--) {
			System.out.print(res[i]);
		}	
	}
}
//13 -- not possible
//10 -- 25
//56 -- 78
//150 -- 556

//git remote add origin https://github.com/zaid5548/NOV_10_MERN.git