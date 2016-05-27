package main.lanqiaocup.adv;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		// System.out.println("蓝桥杯 算法提高");
		// ADV_205();
		// ADV_200();
		// ADV_178();
		// ADV_175();
		// ADV_171();
		// ADV_158();
		// ADV_148();
		// ADV_147();
		// ADV_144();
		// ADV_2();

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
	// * 算法提高 简单加法
	// *
	// * 问题描述
	// * 小于10的自然数中有四个数字能除尽3或5（3， 5， 6， 9），它们的和为23。
	// * 请计算所有小于1000的自然数中能除尽3或5的数字的合。然后使用标准输出cout，输出你的结果。
	// *
	// * 输入格式
	// * 无。
	// * 输出格式
	// * 一行一个整数，表示你的结果。
	// */
	@SuppressWarnings("unused")
	private static void ADV_178() {
		int sum = 0;
		for (int i = 0, j = 0; i < 1000 || j < 1000;) {
			if (i == j) {
				sum += i;
				i += 3;
				j += 5;
			} else if (i > j) {
				sum += j;
				j += 5;
			} else if (j > i) {
				sum += i;
				i += 3;
			}
		}
		System.out.println(sum);

	}

	// /*
	// * 算法提高 三个整数的排序
	// *
	// * 问题描述
	// * 输入三个数，比较其大小，并从大到小输出。
	// * 输入格式
	// * 一行三个整数。
	// * 输出格式
	// * 一行三个整数，从大到小排序。
	// *
	// * 样例输入
	// * 33 88 77
	// * 样例输出
	// * 88 77 33
	// */
	@SuppressWarnings("unused")
	private static void ADV_175() {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[3];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		java.util.Arrays.sort(a);

		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
	}

	// /*
	// * 算法提高 身份证号码升级
	// *
	// * 问题描述
	// * 从1999年10月1日开始，公民身份证号码由15位数字增至18位。(18位身份证号码简介)。升级方法为：
	// * 1、把15位身份证号码中的年份由2位(7,8位)改为四位。
	// * 2、最后添加一位验证码。验证码的计算方案：
	// * 将前 17 位分别乘以对应系数 (7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2) 并相加，然后除
	// * 以 11 取余数，0-10 分别对应 1 0 x 9 8 7 6 5 4 3 2。
	// * 请编写一个程序，用户输入15位身份证号码，程序生成18位身份证号码。假设所有要升级的身份证的四
	// * 位年份都是19××年
	// * 输入格式
	// * 一个15位的数字串，作为身份证号码
	// * 输出格式
	// * 一个18位的字符串，作为升级后的身份证号码
	// *
	// * 样例输入
	// * 110105491231002
	// * 样例输出
	// * 11010519491231002x
	// *
	// * 数据规模和约定
	// * 不用判断输入的15位字符串是否合理
	// */
	@SuppressWarnings("unused")
	private static void ADV_171() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();

		str = str.substring(0, 6) + "19" + str.substring(6, str.length());
		// System.out.println(str);
		int num[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		char chr[] = { '1', '0', 'x', '9', '8', '7', '6', '5', '4', '3', '2' };
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += (str.charAt(i) - 48) * num[i];
			// System.out.println((str.charAt(i) - 48) * num1[i]);
		}
		str += chr[sum %= 11];
		System.out.println(str);
	}

	// /*
	// * 算法提高 新建Microsoft Word文档
	// *
	// * 问题描述
	// * L正在出题，新建了一个word文档，想不好取什么名字，身旁一人惊问：“你出的题目叫
	// * 《新建Microsoft Word文档》吗？”，L大喜，一拍桌子，说：“好，就叫这个名字了。”
	// * 仔细观察，当你新建一个word文档时，会得到一个名为“新建 Microsoft Word 文档.doc”
	// * 的文件，再新建一个，则名为“新建 Microsoft Word 文档(2).doc”，再新建，便是“新建
	// * Microsoft Word 文档(3).doc”。不断新建，编号不断递增。倘若你现在新建了三个文档，
	// * 然后删除了“新建 Microsoft Word 文档(2).doc”，再新建就又会得到一个“新建 Microsoft
	// * Word 文档(2).doc”。
	// * 严格说，Windows在每次新建文档时，都会选取一个与已有文件编号不重复的最小正整数作为新
	// * 文档的编号。
	// * 请编程模拟以上过程，支持以下两种操作
	// * New：新建一个word文档，反馈新建的文档的编号
	// * Delete id：删除一个编号为id的word文档，反馈删除是否成功
	// * 初始时一个文件都没有，“新建 Microsoft Word 文档.doc”的编号算作1。
	// * 输入格式
	// * 第一行一个正整数n表示操作次数，接下来n行，每行表示一个操作。若该行为”New”，则表示新
	// * 建，为”Delete id”则表示要删除编号为id的文档，其中id为一个正整数。操作按输入顺序依
	// * 次进行。
	// * 输出格式
	// * 对于输入的每一行，输出其反馈结果。对于新建操作，输出新建的文档的编号；对于删除操作，反
	// * 馈删除是否成功：如果删除的文件存在，则删除成功，输出”Successful”，否则输出”Failed”。
	// *
	// * 样例输入
	// * 12
	// * New
	// * New
	// * New
	// * Delete 2
	// * New
	// * Delete 4
	// * Delete 3
	// * Delete 1
	// * New
	// * New
	// * New
	// * Delete 4
	// * 样例输出
	// * 1
	// * 2
	// * 3
	// * Successful
	// * 2
	// * Failed
	// * Successful
	// * Successful
	// * 1
	// * 3
	// * 4
	// * Successful
	// *
	// * 数据规模和约定
	// * 操作次数（即输入的行数）不超过1481
	// * 删除编号的数值不超过2012
	// */
	@SuppressWarnings("unused")
	private static void ADV_158() {
		int a[] = new int[2013];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.MAX_VALUE;
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str[] = new String[n];
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.next();
			if (str[i].equals("New")) {
				for (int j = 1; j < a.length; j++) {
					if (a[j] == Integer.MAX_VALUE) {
						a[j] = j;
						System.out.println(j);
						break;
					}
				}
			} else {
				int temp = sc.nextInt();
				if (a[temp] == temp) {
					a[temp] = Integer.MAX_VALUE;
					// System.out.print(temp + " ");
					System.out.println("Successful");

				} else {
					System.out.println("Failed");
				}
			}
		}
		sc.close();
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
		java.util.Arrays.sort(a);

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

	// /*
	// * 算法提高 学霸的迷宫
	// *
	// * 问题描述
	// * 学霸抢走了大家的作业，班长为了帮同学们找回作业，决定去找学霸决斗。但学霸为了不要别人打扰，
	// * 住在一个城堡里，城堡外面是一个二维的格子迷宫，要进城堡必须得先通过迷宫。因为班长还有妹子要
	// * 陪，磨刀不误砍柴功，他为了节约时间，从线人那里搞到了迷宫的地图，准备提前计算最短的路线。可
	// * 是他现在正向妹子解释这件事情，于是就委托你帮他找一条最短的路线。
	// * 输入格式
	// * 第一行两个整数n， m，为迷宫的长宽。
	// * 接下来n行，每行m个数，数之间没有间隔，为0或1中的一个。0表示这个格子可以通过，1表示不可以。
	// * 假设你现在已经在迷宫坐标(1,1)的地方，即左上角，迷宫的出口在(n,m)。每次移动时只能向上下左
	// * 右4个方向移动到另外一个可以通过的格子里，每次移动算一步。数据保证(1,1)，(n,m)可以通过。
	// * 输出格式
	// * 第一行一个数为需要的最少步数K。
	// * 第二行K个字符，每个字符∈{U,D,L,R},分别表示上下左右。如果有多条长度相同的最短路径，选择在
	// * 此表示方法下字典序最小的一个。
	// *
	// * 样例输入
	// * Input Sample 1:
	// * 3 3
	// * 001
	// * 100
	// * 110
	// *
	// * Input Sample 2:
	// * 3 3
	// * 000
	// * 000
	// * 000
	// * 样例输出
	// * Output Sample 1:
	// * 4
	// * RDRD
	// *
	// * Output Sample 2:
	// * 4
	// * DDRR
	// *
	// * 数据规模和约定
	// * 有20%的数据满足：1<=n,m<=10
	// * 有50%的数据满足：1<=n,m<=50
	// * 有100%的数据满足：1<=n,m<=500。
	// */
	private static class ADV_147_Struct {
		// 步数
		int num;
		// 路径
		String str;
		int x;
		int y;
	}

	@SuppressWarnings("unused")
	private static void ADV_147() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String str[] = new String[n];
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.next();
		}
		sc.close();
		int a[][] = new int[n + 1][m + 1];
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < a[i].length; j++) {
				a[i][j] = (int) str[i - 1].charAt(j - 1) - 48;
			}
		}
		java.util.Queue<ADV_147_Struct> q = new java.util.LinkedList<ADV_147_Struct>();
		ADV_147_Struct struct = new ADV_147_Struct();
		struct.num = 0;
		struct.str = "";
		struct.x = 1;
		struct.y = 1;
		q.offer(struct);
		a[1][1] = 1;

		char chr[] = { 'U', 'D', 'L', 'R' };

		while (q.size() > 0) {
			ADV_147_Struct tempS = q.poll();
			if (tempS.x == n && tempS.y == m) {
				System.out.println(tempS.num);
				System.out.println(tempS.str);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = 0;
				int ny = 0;
				switch (chr[i]) {
				case 'U':
					nx = tempS.x - 1;
					ny = tempS.y;
					break;
				case 'D':
					nx = tempS.x + 1;
					ny = tempS.y;
					break;
				case 'L':
					nx = tempS.x;
					ny = tempS.y - 1;
					break;
				case 'R':
					nx = tempS.x;
					ny = tempS.y + 1;
					break;

				}

				if (1 <= nx && nx <= n && 1 <= ny && ny <= m) {
					if (a[nx][ny] != 1 && a[nx][ny] == 0) {
						// System.out.println(a[nx][ny] + " " + nx + " " + ny +
						// " " + chr[i]);
						a[nx][ny] = 1;
						ADV_147_Struct temp2 = new ADV_147_Struct();
						temp2.num = tempS.num + 1;
						temp2.x = nx;
						temp2.y = ny;
						temp2.str = tempS.str + chr[i];
						q.offer(temp2);
					}
				}

			}

		}

	}

	// /*
	// * 算法提高 01背包
	// *
	// * 问题描述
	// * 给定N个物品,每个物品有一个重量W和一个价值V.你有一个能装M重量的背包.问怎么装使得所装价值最大.每个物品只有一个.
	// *
	// * 输入格式
	// * 输入的第一行包含两个整数n, m，分别表示物品的个数和背包能装重量。
	// * 以后N行每行两个数Wi和Vi,表示物品的重量和价值
	// * 输出格式
	// * 输出1行，包含一个整数，表示最大价值。
	// *
	// * 样例输入
	// * 3 5
	// * 2 3
	// * 3 5
	// * 4 7
	// * 样例输出
	// * 8
	// *
	// * 数据规模和约定
	// * 1<=N<=200,M<=5000.
	// */
	private static int ADV_144_N;
	private static int ADV_144_W[];
	private static int ADV_144_V[];
	private static int ADV_144_DP[][];

	@SuppressWarnings("unused")
	private static void ADV_144() {
		Scanner sc = new Scanner(System.in);
		ADV_144_N = sc.nextInt();
		int M = sc.nextInt();
		ADV_144_W = new int[ADV_144_N];
		ADV_144_V = new int[ADV_144_N];
		ADV_144_DP = new int[ADV_144_N + 1][M + 1];
		for (int i = 0; i < ADV_144_DP.length; i++) {
			for (int j = 0; j < ADV_144_DP[i].length; j++) {
				ADV_144_DP[i][j] = Integer.MIN_VALUE;
			}
		}

		for (int i = 0; i < ADV_144_N; i++) {
			ADV_144_W[i] = sc.nextInt();
			ADV_144_V[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(ADV_144_REC(0, M));
	}

	private static int ADV_144_REC(int i, int m) {
		if (ADV_144_DP[i][m] != Integer.MIN_VALUE) {
			return ADV_144_DP[i][m];
		}

		int res;
		if (i == ADV_144_N) {
			res = 0;
		} else if (m - ADV_144_W[i] < 0) {
			res = ADV_144_REC(i + 1, m);
		} else {
			res = Math.max(ADV_144_REC(i + 1, m), ADV_144_REC(i + 1, m - ADV_144_W[i]) + ADV_144_V[i]);
		}
		return ADV_144_DP[i][m] = res;
	}

	// private static int n = 0;
	// private static int a[];
	// private static int b[];
	//
	// private static void ADV_200() {
	// Scanner sc = new Scanner(System.in);
	// n = sc.nextInt();
	// a = new int[n];
	// b = new int[n];
	// for (int i = 0; i < n; i++) {
	// a[i] = sc.nextInt();
	// b[i] = sc.nextInt();
	// }
	// sc.close();
	// System.out.println(dp(0, 0));
	// }
	//
	// private static int dp(int sum, int i) {
	// int res = 0;
	// if (n == i) {
	// res = 0;
	// } else if (a[i] < 0 && b[i] < 0) {
	// res = dp(sum, i + 1);
	// } else if (a[i] > 0 && b[i] > 0) {
	// res = dp(sum + a[i] + b[i], i + 1) + a[i] + b[i];
	// } else {
	// int temp1 = dp(sum, i + 1);
	// int temp2 = dp(sum + a[i] + b[i], i + 1) + a[i] + b[i];
	// res = temp1 > temp2 ? temp1 : temp2;
	// }
	// return res;
	// }
	//
	// private static void ADV_2() {
	// Scanner sc = new Scanner(System.in);
	// int n = sc.nextInt();
	// int a[][] = new int[n][n];
	// for (int i = 0; i < a.length; i++) {
	// for (int j = 0; j < a[i].length; j++) {
	// a[i][j] = sc.nextInt();
	// }
	// }
	// sc.close();
	//
	// int x = (n + 1) / 2;
	//
	// int a2[][] = new int[x][x];
	//
	// for (int i = 0; i <= a.length - x; i++) {
	// for (int l = 0; l <= a[i].length - x; l++) {
	// int temp1 = 0;
	// int temp2 = 0;
	// for (int j = 0; j < a2.length; j++) {
	// for (int k = 0; k < a2[j].length; k++) {
	// a2[j][k] = a[i + j][l + k];
	// temp1 += a2[j][k];
	// a2[j][k] = a2[j][k] * (-1);
	// temp2 += a2[j][k];
	// }
	// }
	//
	// // System.out.println(temp2 + " " + temp1);
	// if (temp2 > temp1) {
	// // System.out.println("tran" + i + " " + l);
	// for (int j = 0; j < a2.length; j++) {
	// for (int k = 0; k < a2[j].length; k++) {
	// a[i + j][l + k] = a2[j][k];
	// }
	// }
	// }
	// }
	// }
	// int sum = 0;
	// for (int i = 0; i < a.length; i++) {
	// for (int l = 0; l < a[i].length; l++) {
	// sum += a[i][l];
	// // System.out.print(a[i][l] + " ");
	// }
	// // System.out.println();
	// }
	// System.out.println(sum);
	//
	// }

}
