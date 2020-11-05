package Dynamic_Programming;

public class BoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=2000000000;
//		System.out.println(boardpath(0, n));
//		int[] strg=new int[n];
//		System.out.println(boardpathTD(0, n, strg));
//		System.out.println(boardpathBU(n));
		System.out.println(boardpathBUSpaceCoefficient(n));
	}

	
	//boardpath Recursive 
	public static int boardpath(int curr,int end) {
		int cnt=0;
		if(curr==end) {
			
			return 1;
		}
		
		if(curr>end) {
			return 0; 
			
		}
		
		for(int dice=1;dice<=6;dice++) {
			cnt+=boardpath(curr+dice, end);
		}
		return cnt;
	}
	
	//boardpath TopDown DP
	public static int boardpathTD(int curr,int end,int[] strg) {
		int cnt=0;
		if(curr==end) {
			
			return 1;
		}
		
		if(curr>end) {
			return 0; 
			
		}
		
		if(strg[curr]!=0) {
			return strg[curr];
		}
		
		for(int dice=1;dice<=6;dice++) {
		
			cnt+=boardpathTD(curr+dice, end,strg);
		}
		
		strg[curr]=cnt;
		return cnt;
	}
	
	
	
	//boardpath BottomUp DP
	//TC--- O(n)
	//SC--- O(n)
	public static int boardpathBU(int end) {
		
		int[] strg=new int[end+6];
		strg[end]=1;
		int sum=0;
		for(int i=end-1;i>=0;i--) {
			strg[i]=strg[i+1]+strg[i+2]+strg[i+3]+strg[i+4]+strg[i+5]+strg[i+6];
		}
		return strg[0];
		
	}
	
	
	//BoardPath BottomUp Space Coefficient
	public static int boardpathBUSpaceCoefficient(int end) {
		
		int[] strg=new int[6];
		strg[0]=1;
		for(int i=end-1;i>=0;i--) {
			int sum=0;

			for(int j=0;j<strg.length;j++) {
				sum+=strg[j];
			}
			
			for(int k=strg.length-1;k>0;k--) {
				strg[k]=strg[k-1];
			}
			strg[0]=sum;
			sum=0;
			
		}
		
		return strg[0];
		
	}
}
