package main.algorithm.book;

///**
// * 部分和问题
// * 
// * 给定整数a1、a2、...、an，判断是否可以从中选出若干数，
// * 使它们的和恰好为k。
// * 
// * 限制条件
// * 1<=n<=20
// * -10^8<=ai<=10^8
// * -10^8<=k<=10^8
// * 
// * @author Alex 2015/05/05
// *
// */
public class ProblemOnPartialSums {

	// private static int n = 4;
	// private static int[] a = {1,2,4,7};
	// private static int k = 13;

	private static int n = 4;
	private static int[] a = { 1, 2, 4, 7 };
	private static int k = 15;

	public static void main(String[] args) {
		if (dfs(0, 0)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean dfs(int i, int sum) {
		if (i == n) {
			return sum == k;
		}
		if (dfs(i + 1, sum)) {
			return true;
		}
		if (dfs(i + 1, sum + a[i])) {
			return true;
		}

		return false;
	}
}
