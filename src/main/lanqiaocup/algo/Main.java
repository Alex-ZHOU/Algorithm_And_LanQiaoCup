package main.lanqiaocup.algo;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		// ALGO_142(); TheLast
		//ALGO_116(); 
		
		//ALGO_4();
		// ALGO_3();
		// ALGO_2();
		// ALGO_1();
	}

	private static void ALGO_4() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int b[][] = new int[n-1][2];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		
		
		
	}

	

	// /*
	// * 算法训练 K好数
	// *
	// * 问题描述
	// * 如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这
	// * 个数是K好数。求L位K进制数中K好数的数目。
	// * 例如K = 4，L = 2的时候，所有K好数为11、13、20、22、30、31、33 共7个。
	// * 由于这个数目很大，请你输出它对1000000007取模后的
	// * 值。
	// * 输入格式
	// * 输入包含两个正整数，K和L。
	// * 输出格式
	// * 输出一个整数，表示答案对1000000007取模后的值。
	// *
	// * 样例输入
	// * 4 2
	// * 样例输出
	// * 7
	// *
	// * 数据规模与约定
	// * 对于30%的数据，K^L <= 10^6；
	// * 对于50%的数据，K <= 16， L <= 10；
	// * 对于100%的数据，1 <= K,L <= 100。
	// * */
	private static long ALGO_3_Count = 0;
	private static long[][] ALGO_3_Data = new long[105][105];

	@SuppressWarnings("unused")
	private static void ALGO_3() {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int l = sc.nextInt();
		sc.close();

		for (int i = 0; i <= k - 1; i++) {
			ALGO_3_Data[1][i] = 1;
		}

		for (int i = 2; i <= l; i++) {
			for (int j = 0; j < k; j++) {
				for (int x = 0; x < k; x++) {
					if (x != j - 1 && x != j + 1) {
						ALGO_3_Data[i][j] = ALGO_3_Data[i][j] % 1000000007 + ALGO_3_Data[i - 1][x] % 1000000007;
					}
				}
			}
		}
		for (int i = 1; i <= k - 1; i++) {
			ALGO_3_Count = (ALGO_3_Count + ALGO_3_Data[l][i]) % 1000000007;
		}

		System.out.println(ALGO_3_Count);
	}

	// /*
	// * 算法训练 最大最小公倍数
	// *
	// * 问题描述
	// * 已知一个正整数N，问从1~N中任选出三个数，他们的最小公倍数最大可以为多少。
	// * 输入格式
	// * 输入一个正整数N。
	// * 输出格式
	// * 输出一个整数，表示你找到的最小公倍数。
	// *
	// * 样例输入
	// * 9
	// * 样例输出
	// * 504
	// * 数据规模与约定
	// * 1 <= N <= 10^6。
	// * */
	// 60分
	@SuppressWarnings("unused")
	private static void ALGO_2() {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		sc.close();
		long ans = 0;

		if (n <= 2) {
			ans = n;
		} else if (n % 2 != 0) {
			ans = n * (n - 1) * (n - 2);
		} else {
			if (n % 3 != 0) {
				ans = n * (n - 1) * (n - 3);
			} else
				ans = (n - 3) * (n - 1) * (n - 2);
		}

		System.out.println(ans);

	}

	// /*
	// * 算法训练 区间k大数查询
	// *
	// * 问题描述
	// * 给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。
	// * 输入格式
	// * 第一行包含一个数n，表示序列长度。
	// * 第二行包含n个正整数，表示给定的序列。
	// * 第三个包含一个正整数m，表示询问个数。
	// * 接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，
	// * 从大往小第K大的数是哪个。序列元素从1开始标号。
	// * 输出格式
	// * 总共输出m行，每行一个数，表示询问的答案。
	// *
	// * 样例输入
	// * 5
	// * 1 2 3 4 5
	// * 2
	// * 1 5 2
	// * 2 3 2
	// * 样例输出
	// * 4
	// * 2
	// *
	// * 数据规模与约定
	// * 对于30%的数据，n,m<=100；
	// * 对于100%的数据，n,m<=1000；
	// * 保证k<=(r-l+1)，序列中的数<=106。
	// * */
	@SuppressWarnings("unused")
	private static void ALGO_1() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int array2[][] = new int[m][3];
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[i].length; j++) {
				array2[i][j] = sc.nextInt();
			}
		}
		sc.close();

		// for (int i = 0; i < array.length; i++) {
		// System.out.print(array[i]);
		// }

		for (int i = 0; i < m; i++) {
			int l = array2[i][0];
			int r = array2[i][1];
			int local = array2[i][2] - 1;
			int temp[] = new int[r - l + 1];

			for (int j = l - 1; j < r; j++) {
				temp[j - l + 1] = array[j];
			}
			// for (int j = 0; j < temp.length; j++) {
			// System.out.print(temp[j]);
			// }
			ALGO_1_Sort(temp);
			// for (int j = 0; j < temp.length; j++) {
			// System.out.print(temp[j]);
			// }

			System.out.println(temp[local]);

		}

	}

	private static void ALGO_1_Sort(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	// /*
	// * 算法训练 P1103
	// *
	// * 编程实现两个复数的运算。设有两个复数 和 ，则他们的运算公式为：
	// *
	// * 要求：
	// * （1）定义一个结构体类型来描述复数。
	// * （2）复数之间的加法、减法、乘法和除法分别用不用的函数来实现。
	// * （3）必须使用结构体指针的方法把函数的计算结果返回。
	// * 说明：用户输入：运算符号(+,-,*,/) a b c d.
	// * 输出：a+bi，输出时不管a,b是小于0或等于0都按该格式输出，输出时a,b都保留两位。
	// *
	// * 输入：
	// * - 2.5 3.6 1.5 4.9
	// * 输出：
	// * 1.00+-1.30i
	// */
	@SuppressWarnings("unused")
	private static void ALGO_142() {
		Scanner sc = new Scanner(System.in);
		String sign = sc.next();
		float a = sc.nextFloat();
		float b = sc.nextFloat();
		float c = sc.nextFloat();
		float d = sc.nextFloat();
		sc.close();

		if (sign.equals("*")) {
			ALGO_142_Mul(a, b, c, d);
		} else if (sign.equals("/")) {
			ALGO_142_Div(a, b, c, d);
		} else {
			ALGO_142_addOrSub(sign, a, b, c, d);
		}
	}

	private static void ALGO_142_Div(float a, float b, float c, float d) {
		float temp = (a * c + b * d) / (c * c + d * d);
		float tempI = (b * c - a * d) / (c * c + d * d);
		System.out.printf("%.2f+%.2fi", temp, tempI);
	}

	private static void ALGO_142_Mul(float a, float b, float c, float d) {
		float temp = a * c - b * d;
		float tempI = b * c + a * d;
		System.out.printf("%.2f+%.2fi", temp, tempI);
		// System.out.println(temp + "" + tempI + "i");
	}

	private static void ALGO_142_addOrSub(String sign, float a, float b, float c, float d) {
		if (sign.equals("+")) {
			float temp = a + c;
			float tempI = b + d;
			System.out.printf("%.2f+%.2fi", temp, tempI);
			// System.out.println(temp + "" + tempI + "i");
		} else if (sign.equals("-")) {
			float temp = a - c;
			float tempI = b - d;
			System.out.printf("%.2f+%.2fi", temp, tempI);
			// System.out.println(temp + "" + tempI + "i");
		}
	}
	
	
	
	
	private static void ALGO_116() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int a[] = new int[N];
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
		sc.close();

		int average = sum / (K + 1);

		// Arrays.sort(a);

		int temp[] = new int[K + 1];
		int j = 0;
		for (int i = 0; i < temp.length; i++) {
			for (; j < a.length; j++) {
				System.out.print(K - i + " ");
				System.out.println(a.length - 1 - j);
				if (temp[i] > average) {
					j++;
					break;
				}
				if (temp[i] < average && a.length - 1 - j >= K - i) {
					temp[i] += a[j];
					if (a.length - 1 - j == K - i) {
						j++;
						break;
					}
				}

			}
		}
		sum = 1;
		for (int i = 0; i < temp.length; i++) {
			sum *= temp[i];
			System.out.println(temp[i]);
		}
		System.out.println(sum);

	}

}
