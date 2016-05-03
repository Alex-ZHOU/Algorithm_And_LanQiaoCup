package main.algorithm.book;

///**
// * 先从简答题开始
// * 
// * 有n跟棍子，棍子i的长度为ai。想要从中选出3跟棍子组成周长尽可能长的三角行。
// * 请输出最大的周长，若无法组成三角形则输出0。
// * 
// * 限制条件
// * 3<=n<=100
// * 1<=ai<=10^6
// * 
// * @author Alex 2016/05/01
// *
// */
public class Triangle {
	// 三角形

	private static int n = 5;

	private static int a[] = { 2, 3, 4, 5, 10 };

	public static void main(String[] args) {

		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int j2 = j + 1; j2 < n; j2++) {
					int max = max(a[i], a[j], a[j2]);
					int len = a[i] + a[j] + a[j2];
					if (len / 2 > max) {
						if (len > ans) {
							ans = len;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

	// 求三个数中最大的那个
	private static int max(int a, int b, int c) {

		int max = a;
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		return max;
	}

}
