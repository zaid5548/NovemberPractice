package Dynamic_Programming;

public class Boundry_Path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cr = 0;
		int cc = 1;
		int er = 1;
		int ec = 3;
		int k = 3;
		int[][][] strg=new int[k+1][er][ec];
		System.out.println(boundryPath(cr, cc, er, ec, k));
		System.out.println(boundryPathTD(cr, cc, er, ec, k, strg));
	}

	public static int boundryPath(int cr, int cc, int er, int ec, int k) {

		if (cr < 0 || cr >= er || cc < 0 || cc >= ec) {
			return 1;
		}

		if (k == 0) {
			return 0;
		}

		int cnt = 0;
		cnt += boundryPath(cr + 1, cc, er, ec, k - 1);
		cnt += boundryPath(cr - 1, cc, er, ec, k - 1);
		cnt += boundryPath(cr, cc + 1, er, ec, k - 1);
		cnt += boundryPath(cr, cc - 1, er, ec, k - 1);

		return cnt;
	}
	
	
	public static int boundryPathTD(int cr, int cc, int er, int ec, int k,int[][][] strg) {

		if (cr < 0 || cr >= er || cc < 0 || cc >= ec) {
			return 1;
		}

		if (k == 0) {
			return 0;
		}

		if(strg[k][cr][cc]!=0) {
			return strg[k][cr][cc];
		}
		
		int cnt = 0;
		cnt += boundryPathTD(cr + 1, cc, er, ec, k - 1,strg);
		cnt += boundryPathTD(cr - 1, cc, er, ec, k - 1,strg);
		cnt += boundryPathTD(cr, cc + 1, er, ec, k - 1,strg);
		cnt += boundryPathTD(cr, cc - 1, er, ec, k - 1,strg);

		strg[k][cr][cc]=cnt;
		return cnt;
	}

}
