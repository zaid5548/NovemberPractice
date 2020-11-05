package Array;

public class Selective_Arrangement {

	 static int waysToArrange(int N, int K, int[] k)  
	    { 
	        int[][] C = new int[N + 1][N + 1]; 
	        int i, j; 
	        for (i = 0; i <= N; i++)  
	        { 
	            for (j = 0; j <= i; j++)  
	            {   
	                if (j == 0 || j == i)  
	                { 
	                    C[i][j] = 1; 
	                }   
	                else 
	                { 
	                    C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]); 
	                } 
	            } 
	        }  
	        int[] dp = new int[K + 1]; 	
	        int count = 0; 
	        dp[0] = 1; 
	        for (i = 0; i < K; i++)  
	        { 
	            dp[i + 1] = (dp[i] * C[count + k[i] - 1][k[i] - 1]); 
	            count += k[i]; 
	        } 
	        return dp[K]; 
	    } 
	    public static void main(String[] args)  
	    { 
	        int N = 4; 
	        int[] k = new int[]{2, 2}; 
	        int K = k.length; 
	        System.out.println(waysToArrange(N, K, k)); 
	    } 
	
}
