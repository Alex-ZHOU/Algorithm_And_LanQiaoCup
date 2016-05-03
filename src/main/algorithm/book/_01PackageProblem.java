package main.algorithm.book;

///**
// * 记忆化搜索与动态规划问题
// * 
// * 有n个重量和价值分别为wi,vi的物品。从这些物品选出总重量不超过W的物品，
// * 求所有挑选方案中价值总和的最大值
// * 
// * 限制条件
// * 1<=n<=100
// * 1<=wi,vi<=100
// * 1<=W<=10000
// * 
// * @author Alex 2016/05/01
// *
// */
public class _01PackageProblem {
	// 01 背包问题
	private static int n = 4;
	private static int w[] = { 2, 1, 3, 2 };
	private static int v[] = { 3, 2, 4, 2 };
	private static int W = 5;

	private static int dp[][] = new int[100][100];

	public static void main(String[] args) {
		System.out.println(res(0, W));
		System.out.println(res2(0, W));
	}

	// 记忆搜索动态规划，此算法更优
	private static int res2(int i, int j) {

		if (dp[i][j] > 0) {
			return dp[i][j];
		}

		int rec;

		if (i == n) {
			rec = 0;
		} else if (j < w[i]) {
			rec = res(i + 1, j);
		} else {
			rec = max(res(i + 1, j), res(i + 1, j - w[i]) + v[i]);
		}
		return dp[i][j] = rec;
	}

	// 深度优先
	private static int res(int i, int j) {

		int rec;

		if (i == n) {
			rec = 0;
		} else if (j < w[i]) {
			rec = res(i + 1, j);
		} else {
			rec = max(res(i + 1, j), res(i + 1, j - w[i]) + v[i]);
		}
		return rec;
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
