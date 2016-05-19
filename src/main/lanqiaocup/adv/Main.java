package main.lanqiaocup.adv;

import java.util.Arrays;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// System.out.println("蓝桥杯 算法提高");
		// ADV_205();
		// ADV_148();
	}

	// /*
	// * 算法提高 拿糖果
	// *
	// * 问题描述
	// * 妈妈给小B买了N块糖！但是她不允许小B直接吃掉。
	// * 假设当前有M块糖，小B每次可以拿P块糖，其中P是M的一个不大于根号下M的质因数。
	// * 这时，妈妈就会在小B拿了P块糖以后再从糖堆里拿走P块糖。然后小B就可以接着拿糖。
	// * 现在小B希望知道最多可以拿多少糖。
	// * 输入格式
	// * 一个整数N
	// * 输出格式
	// * 最多可以拿多少糖
	// *
	// * 样例输入
	// * 15
	// * 样例输出
	// * 6
	// *
	// * 数据规模和约定
	// * N <= 100000
	// */
	private static int ADV_205_prime[] = new int[110];
	private static int ADV_205_vis[] = new int[350];
	private static int ADV_205_dp[] = new int[100010];

	@SuppressWarnings("unused")
	private static void ADV_205() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int cur = 0;
		for (int i = 0; i < ADV_205_vis.length; i++) {
			ADV_205_vis[i] = 0;
		}
		for (int i = 0; i < ADV_205_dp.length; i++) {
			ADV_205_dp[i] = 0;
		}
		for (int i = 2; i <= 349; i++) {
			if (ADV_205_vis[i] == 0) {
				ADV_205_prime[cur++] = i;
				for (int j = i + i; j <= 349; j = j + i) {
					ADV_205_vis[j] = 1;
				}
			}
		}

		// for (int i = 0; i < ADV_205_prime.length; i++) {
		// if (ADV_205_prime[i] != 0) {
		// System.out.println(ADV_205_prime[i] + " " + i);
		// }
		// }

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= cur - 1; j++) {
				if (ADV_205_prime[j] <= Math.sqrt(i)) {
					if (i % ADV_205_prime[j] == 0)
						ADV_205_dp[i] = ADV_205_dp[i] > ADV_205_dp[i - 2 * ADV_205_prime[j]] + ADV_205_prime[j]
								? ADV_205_dp[i] : ADV_205_dp[i - 2 * ADV_205_prime[j]] + ADV_205_prime[j];
				} else {
					break;
				}
			}
		}
		System.out.println(ADV_205_dp[n]);
	}

	// /*
	// * 算法提高 排队打水问题
	// *
	// * 问题描述
	// * 有n个人排队到r个水龙头去打水，他们装满水桶的时间t1、t2………..tn为整数且各不相等，
	// * 应如何安排他们的打水顺序才能使他们总共花费的时间最少？
	// * 输入格式
	// * 第一行n，r (n<=500,r<=75)
	// * 第二行为n个人打水所用的时间Ti (Ti<=100)；
	// * 输出格式
	// * 最少的花费时间
	// *
	// * 样例输入
	// * 3 2
	// * 1 2 3
	// * 样例输出
	// * 7
	// *
	// * 数据规模和约定
	// * 其中80%的数据保证n<=10
	// */
	@SuppressWarnings("unused")
	private static void ADV_148() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(a);

		if (r > n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += a[i];
			}
			System.out.println(sum);
			return;
		}

		for (int i = 0; i < r; i++) {
			b[i] = a[i];
		}
		for (int i = r; i < n; i++) {
			b[i] = b[i - r] + a[i];
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += b[i];
		}
		System.out.println(sum);
	}
}
