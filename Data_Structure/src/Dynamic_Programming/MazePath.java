package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;

public class MazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(mazepath(0,0,2,2));
		int n = 3;
		System.out.println(mazepathRec(0, 0, n, n));
//		System.out.println(mazepathTD(0, 0, n, n, new int[n+1][n+1]));
//		System.out.println(mazepathBU(0, 0, n, n));
		System.out.println(mazepathBUDiagonal(0, 0, n, n));
//		System.out.println(MPBUSpaceEfficient(0, 0, n, n));
		System.out.println(MPBUSpaceEfficientDiagonal(0, 0, n, n));
	}

	public static ArrayList<String> mazepath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		if (cc + 1 <= ec) {
			ArrayList<String> rr2 = mazepath(cr, cc + 1, er, ec);
			for (String val : rr2) {
				mr.add("H" + val);
			}
		}

		if (cr + 1 <= er) {
			ArrayList<String> rr1 = mazepath(cr + 1, cc, er, ec);
			for (String val : rr1) {
				mr.add("V" + val);
			}
		}
		
		if (cr + 1 <= er && cc<=ec) {
			ArrayList<String> rr1 = mazepath(cr + 1, cc+1, er, ec);
			for (String val : rr1) {
				mr.add("D" + val);
			}
		}

		return mr;

	}

	public static int mazepathRec(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int MPC = mazepathRec(cr, cc + 1, er, ec);
		int MPR = mazepathRec(cr + 1, cc, er, ec);
		int MPD=mazepathRec(cr+1, cc+1, er, ec);

		return MPC + MPR+MPD;

	}

	public static int mazepathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int MPC = mazepathTD(cr, cc + 1, er, ec, strg);
		int MPR = mazepathTD(cr + 1, cc, er, ec, strg);
		int MPD = mazepathTD(cr + 1, cc+1, er, ec, strg);
		
		strg[cr][cc] = MPC + MPR+MPD;
		return MPC + MPR+MPD;

	}

	public static int mazepathBU(int cr, int cc, int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];
		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er && col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row][col + 1] + strg[row + 1][col];
				}
			}
		}

		return strg[0][0];

	}
	
	public static int mazepathBUDiagonal(int cr, int cc, int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];
		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er && col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row][col + 1] + strg[row + 1][col]+strg[row+1][col+1];
				}
			}
		}

		return strg[0][0];

	}

	public static int MPBUSpaceEfficient(int cr, int cc, int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		for (int slide = er - 1; slide >= 0; slide--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					strg[col] = 1;
				} else {
					strg[col] = strg[col] + strg[col + 1];
				}
			}
		}
		
		return strg[0];
	}


	public static int MPBUSpaceEfficientDiagonal(int cr, int cc, int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);
		int d=0;
		for (int slide = er - 1; slide >= 0; slide--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					strg[col] = 1;
					d=1;
				} else {
					int val=strg[col]+strg[col+1]+d;
					d=strg[col];
					strg[col]=val;
				}
			}
		}
		
		return strg[0];
	}
	
}
