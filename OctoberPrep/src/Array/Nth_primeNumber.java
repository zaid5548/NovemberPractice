package Array;

import java.util.Scanner;

public class Nth_primeNumber {

	 public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    System.out.print("Enter n to compute the nth prime number: ");
		    int nth = sc.nextInt(); 
		    int num, count, i;
		    num=1;
		    count=0;
		 
		    while (count < nth){
		      num=num+1;
		      for (i = 2; i <= num; i++){ //Here we will loop from 2 to num
		        if (num % i == 0) {
		          break;
		        }
		      }
		      if ( i == num){//if it is a prime number
		        count = count+1;
		      }
		    }
		    System.out.println("Value of nth prime: " + num);
		  }
	
}
