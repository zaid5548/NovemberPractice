package Practice;

import java.util.Arrays;

public class Closet_Zero {

	
public static void main(String[] args) {
        
		  int[] testingArray = {0,2,3,4,5};
        
        int result = ClosestToZero(testingArray);
        
        System.out.println(result);
 
    }
 
    public static int ClosestToZero(int[] a) {
        int i = 0;
        int j = a[0];
        Arrays.sort(a);
 
        for (int k = 0; k < a.length; k++) {
            i = a[k] * a[k];
            if (i <= (j * j)) {
                j = a[k];
            }
        }
        return j;
    }
	
}
