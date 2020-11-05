package Array;

public class Double_On_Match {

	
	 static int findValue(int arr[], int n, int k) { 
		    for (int i = 0; i < n; i++)  
		        if (arr[i] == k) 
		        k *= 2; 
		      
		    return k; 
		    } 
		  
		    // Driver Code 
		    public static void main(String[] args)  
		    { 
		    int arr[] = {1,2,4,11,12,8}, k = 2; 
		    int n = arr.length; 
		    System.out.print(findValue(arr, n, k)); 
		    } 
	
}
