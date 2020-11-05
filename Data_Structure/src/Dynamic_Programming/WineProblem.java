package Dynamic_Programming;

public class WineProblem {

	public static void main(String[] args) {
//		int[] wine = new int[100];
//		for (int i = 0; i < wine.length; i++) {
//			wine[i] = i;
//		}
		int[] wine = { 2, 3, 5, 1, 4 };
//		System.out.println(maximumProfit(wine, 0, wine.length - 1, 1));
		int[][] strg = new int[wine.length][wine.length];
		System.out.println(maximumProfitTD(wine, 0, wine.length - 1, strg));
		System.out.println(maximumProfitBU(wine));
	}

	private static int maximumProfit(int[] wine, int vidx1, int vidx2, int year) {

		if (vidx1 == vidx2) {
			return wine[vidx1] * year;
		}

		int leftMost = maximumProfit(wine, vidx1 + 1, vidx2, year + 1) + wine[vidx1] * year;
		int rightMost = maximumProfit(wine, vidx1, vidx2 - 1, year + 1) + wine[vidx2] * year;

		int ans = Math.max(leftMost, rightMost);

		return ans;
	}

	private static int maximumProfitTD(int[] wine, int vidx1, int vidx2, int[][] strg) {

		int year = wine.length - (vidx2 - vidx1 + 1) + 1;
		if (vidx1 == vidx2) {
			return wine[vidx1] * year;
		}

		if (strg[vidx1][vidx2] != 0) {
			return strg[vidx1][vidx2];
		}

		int leftMost = maximumProfitTD(wine, vidx1 + 1, vidx2, strg) + wine[vidx1] * year;
		int rightMost = maximumProfitTD(wine, vidx1, vidx2 - 1, strg) + wine[vidx2] * year;

		int ans = Math.max(leftMost, rightMost);

		strg[vidx1][vidx2] = ans;

		return ans;
	}

	private static int maximumProfitBU(int[] wine) {
		int n = wine.length;
		int[][] strg = new int[n][n];
		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				// logic same of TopDown
				int year = wine.length - (ei - si + 1) + 1;
				if (si == ei) {
					strg[si][ei] = wine[si] * year;
				} else {
					int leftMost = strg[si+1][ei] + wine[si] * year;
					int rightMost = strg[si][ei-1] + wine[ei] * year;

					int ans = Math.max(leftMost, rightMost);

					strg[si][ei] = ans;
				}
			}
		}
		
		for(int i=0;i<strg.length;i++) {
			for(int j=0;j<strg[0].length;j++) {
				System.out.print(strg[i][j]+"\t");
			}
			System.out.println();
		}
		
		return strg[0][n-1];
	}

}
