package main.algorithm.book;

import java.util.Arrays;

///**
// * 农夫约翰搭了一间有N间牛舍的小屋。牛舍排在一条线上，第i好牛舍在xi的位置。
// * 但是他的M头牛对小屋很不满意，因此经常互相攻击。约翰为了防止牛这间互相伤害，
// * 因此决定把每头牛都放在离其他牛尽可能远的牛舍。也就上要最大化最近两头牛之间
// * 的距离。
// * 
// * 限制条件
// * 2<=N<=100000
// * 2<=M<=N
// * 0<=xi<=10^9
// * 
// * @author Alex
// *
// */
public class AggressiveCows {

	private static int N = 5;
	private static int M = 3;
	private static int x[] = { 1, 2, 8, 4, 9 };

	public static void main(String[] args) {

		Arrays.sort(x);

		// for (int i = 0; i < x.length; i++) {
		// System.out.print(x[i] + " ");
		// }

		// 初始化范围
		int lb = 0;
		int ub = x[x.length - 1] - x[0];

		// 二分搜索
		while (ub - lb > 1) {
			int mid = (ub + lb) / 2;
			if (C(mid)) {
				lb = mid;
			} else {
				ub = mid;
			}
		}

		System.out.println(lb);

	}

	// 判断是否满足要求。思路：起始位置为last，找到离它最近适合的位置
	private static boolean C(int mid) {

		int last = 0;

		for (int i = 1; i < M; i++) {
			int crt = last + 1;

			while (crt < N && x[crt] - x[last] < mid) {
				crt++;
			}
			if (crt == N) {
				return false;
			}
			last = crt;

		}

		return true;
	}

}
