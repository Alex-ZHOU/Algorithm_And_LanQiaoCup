package main.lanqiaocup.hzu._20160514;

// 将1,2,3，4填入4×4的方格中，要求每行、每列都没有重复数字，下面是一种填法，
// 则不同的填写方法共有多少种。

public class _3 {

	private static boolean[][] cvis = new boolean[5][5];
	private static boolean[][] rvis = new boolean[5][5];
	private static int ans = 0;

	public static void main(String[] args) {
		bfs(1, 1);
		System.out.println(ans);
	}

	public static void bfs(int r, int c) {
		System.out.println(r + " " + c);

		if (r == 4 && c == 4) {
			ans++;
			return;
		}
		if (c == 5) {
			r++;
			c = 1;
		}

		for (int i = 1; i <= 4; i++) {
			if (check(r, c, i)) {
				rvis[r][i] = true;
				cvis[c][i] = true;
				bfs(r, c + 1);
				rvis[r][i] = false;
				cvis[c][i] = false;
			}
		}
	}

	public static boolean check(int r, int c, int x) {
		if (rvis[r][x] || cvis[c][x]) {
			return false;
		}
		return true;
	}
}
