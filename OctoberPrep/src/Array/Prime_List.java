package Array;

import java.util.Scanner;

public class Prime_List {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int i = 0;
		int num = 0;
//	       String  primeNumbers = "";

		for (i = 1; i <= n; i++) {
			int counter = 0;
			for (num = i; num >= 1; num--) {
				if (i % num == 0) {
					counter = counter + 1;
				}
			}
			if (counter == 2) {
//		     primeNumbers = primeNumbers + i + " ";
				System.out.print(i + " ");
			}
		}
//	       System.out.println(primeNumbers);

	}

}
