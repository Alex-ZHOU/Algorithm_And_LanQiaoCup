package main.algorithm.book;

///**
// * 假定一个解并判断是否可行
// * 
// * 有N条绳子，他们的长度分别是Li。如果他们中切割出K条长度相等的绳子的话，这K
// * 条绳子最长能有多长。答案保留到小数点后2位。
// * 
// * 限制条件
// * 1<=N<=10000
// * 1<=K<=10000
// * 1<=Li<=100000
// * 
// * @author Alex
// *
// */
public class CableMaster {

	public static void main(String[] args) {

		int N = 4;
		int K = 11;
		double[] L = { 8.02, 7.43, 4.57, 5.39 };

		solve(N, K, L);

	}

	private static void solve(int n, int k, double[] l) {
		// 初始化范围
		double lb = 0;
		double ub = 100000;

		// 重复循环，直到解的范围足够小
		for (int i = 0; i < 100; i++) {

			double mid = (lb + ub) / 2;

			if (C(mid, k, l)) {
				lb = mid;
			} else {
				ub = mid;
			}

		}

		// // 原数输出
		// System.out.println(ub);
		// // 四舍五入写法
		// System.out.printf("%.2f", ub);

		// Math.floor(float i)向下取整，保留2位小数的正确做法，不是四舍五入
		System.out.printf("%.2f", Math.floor(ub * 100) / 100);

	}

	// 判断是否满足条件
	private static boolean C(double mid, int k, double[] l) {

		int num = 0;

		for (int i = 0; i < l.length; i++) {
			num += l[i] / mid;
		}

		if (num >= k) {
			return true;
		} else {
			return false;
		}
	}

}
