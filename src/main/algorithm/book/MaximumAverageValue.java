package main.algorithm.book;

import java.util.Arrays;

///**
// * 最大化平均值
// * 
// * 有n个物品的重量和价值分别说wi和vi。从中选出k个物品使得单位重量的价值最大。
// * 
// * 限制条件
// * 1<=k<=n<=10^4
// * 1<=wi,v<=10^6
// * 
// * @author Alex
// *
// */
public class MaximumAverageValue {

	private static int n = 3;

	private static int k = 2;

	private static int w[] = { 2, 5, 2 };

	private static int v[] = { 2, 3, 1 };

	private static double y[] = new double[n];

	public static void main(String[] args) {
		// 二分法

		double lb = 0;
		double ub = Integer.MAX_VALUE;

		for (int i = 0; i < 100; i++) {
			double mid = (lb + ub) / 2;
			if (C(mid)) {
				lb = mid;
			} else {
				ub = mid;
			}
		}

		System.out.printf("%.2f", lb);

	}

	private static boolean C(double x) {

		for (int i = 0; i < n; i++) {

			y[i] = v[i] - x * w[i];

		}

		// 从小到大排序
		Arrays.sort(y);

		// for (int i = 0; i < n; i++) {
		// System.out.print(y[i]);
		// }
		// System.out.println();

		// 从y中拿出最大的k个数，如果最大的k个数和小于0，返回false，否则返回true
		double sum = 0;
		for (int i = 0; i < k; i++) {
			sum += y[n - i - 1];
		}

		return sum >= 0;

	}

}
