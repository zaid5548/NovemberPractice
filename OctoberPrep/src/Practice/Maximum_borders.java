package Practice;

import java.util.Scanner;

public class Maximum_borders {
	public static void main(String args[] ) throws Exception {
	       Scanner scn = new Scanner(System.in);
	       int t=scn.nextInt();
	       while(t>0){
	           int row=scn.nextInt();
	           int col=scn.nextInt();
	           char[][] arr=new char[row][col];
	           for(int i=0;i<row;i++){
	               for(int j=0;j<col;j++){
	                   arr[i][j]=scn.next().charAt(0);
	               }
	           }
	            
	            int max=0;
	            for(int i=0;i<row;i++){
	                int cnt=0;
	                for(int j=0;j<col;j++){
	                    char ch=arr[i][j];
	                    if(ch=='#'){
	                        cnt++;
	                    }
	                    
	                }
	                max=Math.max(cnt,max);
	            }

	            System.out.println(max);
	           t--;
	       }
	    }
}

/*
2 15
. . . . . # # # # . . . . . .
. . . . . # . . . . . . . . .
7 9
. . . # # # . . .
. . . # # # . . .
. . # . . . . . .
. # # # # . . . .
. . # . . . . . .
. . . # # # # # .
. . . . . . . . .
*/