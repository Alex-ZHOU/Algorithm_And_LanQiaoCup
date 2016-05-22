package main.lanqiaocup.hzu._20160522;

import java.util.Scanner;

///*
// * 题目描述
// * 背景
// * 最近老师教了狗狗怎么算组合数，狗狗又想到了一个问题。。。
// * 描述
// * 狗狗定义C(N,K)表示从N个元素中不重复地选取K个元素的方案数。
// * 狗狗想知道的是C(N,K)的奇偶性。
// * 当然，这个整天都老是用竖式算123456789*987654321=？的人
// * 不会让你那么让自己那么轻松，它说：“N和K都可能相当大。”但是
// * 狗狗也犯难了，所以它就找到了你，想请你帮他解决这个问题。
// * 
// * 输入格式
// * 第1行：一个正整数t(t<=100000)，表示数据的组数。
// * 第2~2+t-1行：两个非负整数N和K。（保证k<=n）
// * 输出格式
// * 每一组输入，如果C(N,K)是奇数则输出1，否则输出0。
// * 
// * 样例输入 
// * 3
// * 1 1
// * 1 0
// * 2 1
// * 样例输出 
// * 1
// * 1
// * 0
// */
public class _7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int a[][] = new int[t][2];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();
		System.out.println("方法一:");
		for (int i = 0; i < a.length; i++) {
			System.out.println(check(a[i][0], a[i][1]));
		}
		System.out.println("方法二:");
		for (int i = 0; i < a.length; i++) {
			if ((a[i][0] & a[i][1]) == a[i][1]) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	private static int check(int N, int K) {

		K = N - K > K ? K : N - K;

		int k = 1;
		int n = 1;
		for (int i = 1; i <= K; i++) {
			k *= K;
			n *= (N - i - 1);
		}
		if (n / k % 2 == 0) {
			return 0;
		} else {
			return 1;
		}
	}
}
