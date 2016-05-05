package main.algorithm.book;

import java.util.Arrays;

///**
// * Minimum Scalar Product（2008 Round1AA）
// * 
// * 有两个向量v1=（x1,x2,x3...xn）和v2＝（y1,y2,y3...yn），允许任意
// * 交换v1和v2各自的分量的顺序。请计算v1和v2的内积x1y1+x2y2+...＋xnyn
// * 的最小值
// * 
// * 限制条件
// * Small
// * 1<=n<=8
// * -1000<=xi,yi<=1000
// * Large
// * 100<=n<=800
// * -100000<=xi,yi<=100000
// * 
// * @author Alex 2016/05/05
// *
// */
public class MinimumScalarProduct {

	// private static int n = 3;
	// private static int v1[] = {1,3,-5};
	// private static int v2[] = {-2,4,1};
	private static int n = 5;
	private static int v1[] = { 1, 2, 3, 4, 5 };
	private static int v2[] = { 1, 0, 1, 0, 1 };

	public static void main(String[] args) {
		Arrays.sort(v1);
		Arrays.sort(v2);

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += v1[i] * v2[n - i - 1];
		}
		System.out.println(sum);
	}

}
