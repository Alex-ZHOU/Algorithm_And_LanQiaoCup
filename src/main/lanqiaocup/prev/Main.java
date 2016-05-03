package main.lanqiaocup.prev;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		// System.out.println("蓝桥杯 历届试题");
		PREV_29();
		// PREV_11();
		// PREV_10();
		// PREV_9();
		// PREV_8();
		// PREV_7();

		// PREV_6();
		// PREV_5();
		// PREV_4();
		// PREV_3();
		// PREV_2();
		// PREV_1();
	}

	private static void PREV_29() {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		long p = sc.nextLong();
		sc.close();

		long fm = PREV_29_f((int) m);

		long modm = 0;
		for (int i = 1; i <= n; i++) {
			modm = ((modm + PREV_29_f(i) % fm) % fm);
		}

		System.out.println(modm % p);


	}

	private static long PREV_29_F[] = new long[1000];
	
	private static long PREV_29_f(int i) {
		
		if(PREV_29_F[i]>0){
			return PREV_29_F[i];
		}

		if (i == 1 || i == 2) {
			PREV_29_F[i] = 1;
			
		} else {
			PREV_29_F[i]  = PREV_29_f(i-1)+PREV_29_f(i-2);
		}
		return PREV_29_F[i];
	}

	
	
	
	private static int PREV_9_Load = 0;

	private static void PREV_9() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() - 1;
		int a[][] = new int[n][3];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();

		PREV_9_DFS(4, a);

		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a[i].length; j++) {
		// System.out.print(a[i][j]);
		// }
		// System.out.println();
		// }

		// int money = 0;
		//
		// for (int i = 1; i <= n; i++) {
		// money = i + 10 + money;
		// }
		// System.out.println(money);

	}

	private static void PREV_9_DFS(int data, int[][] a) {

	}

	// private static int PREV_4_Count = 0;
	// private static boolean PREV_4_Flag[][] = new boolean[10][10];
	// private static int PREV_4_M;
	// private static int PREV_4_N;
	// private static int PREV_4_Sum;
	// private static int PREV_4_Half;
	// private static int PREV_4_LeftUpHalf;
	//
	// private static void PREV_4() {
	// Scanner sc = new Scanner(System.in);
	// PREV_4_M = sc.nextInt();
	// PREV_4_N = sc.nextInt();
	// int a[][] = new int[PREV_4_M][PREV_4_N];
	// for (int i = 0; i < PREV_4_M; i++) {
	// for (int j = 0; j < PREV_4_N; j++) {
	// a[i][j] = sc.nextInt();
	// }
	// }
	// sc.close();
	// PREV_4_Sum = 0;
	// for (int i = 0; i < PREV_4_M; i++) {
	// for (int j = 0; j < PREV_4_N; j++) {
	// PREV_4_Sum += a[i][j];
	// }
	// }
	//
	// if (PREV_4_Sum % 2 != 0) {
	// System.out.println(0);
	// } else {
	// PREV_4_Flag[0][0] = true;
	// PREV_4_Half = PREV_4_Sum / 2;
	// PREV_4_Move(a, 0, 0);
	// }
	// System.out.println(PREV_4_Count);
	//
	// }
	//
	// private static void PREV_4_Move(int a[][], int x, int y) {
	// int move[][] = { { 1, 0 }, { 0, 1 }, { 1, 1 } };
	// if (PREV_4_Flag[x][y]) {
	// for (int z = 0; z < 3; z++) {
	// int i = x + move[z][0];
	// int j = y + move[z][1];
	// if (i < PREV_4_M && j < PREV_4_N) {
	// if ((PREV_4_LeftUpHalf + a[i][j]) <= PREV_4_Half) {
	// PREV_4_Flag[i][j] = true;
	// PREV_4_LeftUpHalf += a[i][j];
	// PREV_4_Count++;
	// PREV_4_Move(a, i, j);
	// // PREV_4_Flag[i][j] = false;
	// }
	// }
	// }
	// }
	//
	//
	//
	// }

	private static void PREV_11() {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		sc.close();

		String str[] = in.split(" ");

		int a[] = new int[str.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(str[i]);
		}

		PREV_11_Do(a);

	}

	private static void PREV_11_Do(int[] a) {

		if (a.length == 1) {
			return;
		}

		int first = a[0];
		boolean flagUp = false;
		boolean flagDown = false;
		int up = 0;
		int down = 0;
		int loactUp = 0;
		int loactDown = 0;
		for (int i = 0; i < a.length; i++) {
			if (first < a[i] && !flagUp) {
				flagUp = true;
				up = a[i];
				loactUp = i;
				continue;
			}
			if (first > a[i] && !flagDown) {
				flagDown = true;
				down = a[i];
				loactDown = i;
				continue;
			}
		}

		if (loactUp == 1) {
			int temp[] = new int[loactDown - loactUp];
			for (int i = loactUp; i < loactDown; i++) {
				temp[loactUp - temp.length] = a[i];
				PREV_11_Do(temp);
			}
		}

	}

	// /*
	// * 历届试题 幸运数
	// *
	// * 问题描述
	// * 幸运数是波兰数学家乌拉姆命名的。它采用与生成素数类似的“筛法”生成。
	// * 首先从1开始写出自然数1,2,3,4,5,6,....
	// * 1 就是第一个幸运数。
	// * 我们从2这个数开始。把所有序号能被2整除的项删除，变为：
	// * 1 _ 3 _ 5 _ 7 _ 9 ....
	// * 把它们缩紧，重新记序，为：
	// * 1 3 5 7 9 .... 。这时，3为第2个幸运数，然后把所有能被3整除的序号位置的数删去。
	// * 注意，是序号位置，不是那个数本身能否被3整除!! 删除的应该是5，11, 17, ...
	// * 此时7为第3个幸运数，然后再删去序号位置能被7整除的(19,39,...)
	// * 最后剩下的序列类似：
	// * 1, 3, 7, 9, 13, 15, 21, 25, 31, 33, 37, 43, 49, 51, 63, 67, 69, 73, 75,
	// 79, ...
	// * 输入格式
	// * 输入两个正整数m n, 用空格分开 (m < n < 1000*1000)
	// * 输出格式
	// * 程序输出 位于m和n之间的幸运数的个数（不包含m和n）。
	// *
	// * 样例输入1
	// * 1 20
	// * 样例输出1
	// * 5
	// * 样例输入2
	// * 30 69
	// * 样例输出1
	// * 8
	// * */
	private static void PREV_10() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();

		java.util.List<Integer> a = new java.util.ArrayList<Integer>();
		java.util.List<Integer> b = new java.util.ArrayList<Integer>();
		for (int i = 1; i <= m; i++) {
			a.add(i);
		}
		for (int i = 1; i <= n; i++) {
			b.add(i);
		}

		PREV_10_Do(b);
		PREV_10_Do(a);
		b.removeAll(a);
		System.out.println(b.size() - 1);

	}

	private static int PREV_10_Do(java.util.List<Integer> a) {
		if (a.size() < 2) {
			return 0;
		}

		int sum = 0;
		int flag = a.get(1);
		do {

			if (sum == 0) {
				flag = a.get(1);
			} else {
				flag = a.get(sum);
			}

			// System.out.println(flag);
			for (int j = 1; j < a.size(); j++) {
				if (j % flag == 0) {
					a.set(j - 1, -1);
				}
			}
			// System.out.println("shachuqian"+a);
			for (int j = 0; j < a.size(); j++) {
				if (a.get(j) == -1) {
					a.remove(j);
					j--;
				}
			}
			// System.out.println("shanchuhou"+a);
			sum++;
		} while (a.size() > sum);

		// System.out.println(a.size()-2);

		return (a.size() - 2);

	}

	// /*
	// * 历届试题 买不到的数目
	// *
	// * 问题描述
	// * 小明开了一家糖果店。他别出心裁：把水果糖包成4颗一包和7颗一包的两种。糖果不能拆包卖。
	// * 小朋友来买糖的时候，他就用这两种包装来组合。当然有些糖果数目是无法组合出来的，比如要买 10 颗糖。
	// * 你可以用计算机测试一下，在这种包装情况下，最大不能买到的数量是17。大于17的任何数字都可以用4和7组合出来。
	// * 本题的要求就是在已知两个包装的数量时，求最大不能组合出的数字。
	// * 输入格式
	// * 两个正整数，表示每种包装中糖的颗数(都不多于1000)
	// * 输出格式
	// * 一个正整数，表示最大不能买到的糖数
	// *
	// * 样例输入1
	// * 4 7
	// * 样例输出1
	// * 17
	// * 样例输入2
	// * 3 5
	// * 样例输出2
	// * 7
	// * */
	private static void PREV_8() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();

		int max = a * b;

		int n = b;
		int m = a;

		for (int i = max; i > 0; i--) {

			boolean flag = false;

			for (int j = 0; j <= n; j++) {
				for (int j2 = 0; j2 <= m; j2++) {
					if (j == 0 && j2 == 0) {
						continue;
					}
					if (i == a * j + b * j2) {
						flag = true;
					}
				}
			}

			if (!flag) {
				System.out.println(i);
				break;
			}
		}
		// 代码来自网上某大神，我也不知道是谁的
		// Scanner sc = new Scanner(System.in);
		// int a = sc.nextInt();
		// int b = sc.nextInt();
		// sc.close();
		// System.out.println(a * b - a - b);
	}

	// /*
	// * 历届试题 连号区间数
	// *
	// * 问题描述
	// * 小明这些天一直在思考这样一个奇怪而有趣的问题：
	// * 在1~N的某个全排列中有多少个连号区间呢？这里所说的连号区间的定义是：
	// * 如果区间[L, R] 里的所有元素（即此排列的第L个到第R个元素）递增排序后能得到一个长度为
	// * R-L+1的“连续”数列，则称这个区间连号区间。
	// * 当N很小的时候，小明可以很快地算出答案，但是当N变大的时候，问题就不是那么简单了，现在小明需要你的帮助。
	// * 输入格式
	// * 第一行是一个正整数N (1 <= N <= 50000), 表示全排列的规模。
	// * 第二行是N个不同的数字Pi(1 <= Pi <= N)， 表示这N个数字的某一全排列。
	// * 输出格式
	// * 输出一个整数，表示不同连号区间的数目。
	// *
	// * 样例输入1
	// * 4
	// * 3 2 4 1
	// * 样例输出1
	// * 7
	// * 样例输入2
	// * 5
	// * 3 4 2 5 1
	// * 样例输出1
	// * 9
	// * */
	private static void PREV_7() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		int flag = 0;
		for (int i = 0; i < a.length; i++) {
			int max = a[i];
			int min = a[i];
			for (int j = i; j < a.length; j++) {
				if (a[j] > max) {
					max = a[j];
				}
				if (a[j] < min) {
					min = a[j];
				}
				if (max - min == j - i) {
					flag++;
				}
			}
		}
		System.out.println(flag);
	}

	// /*
	// * 历届试题 翻硬币
	// *
	// * 问题描述
	// * 小明正在玩一个“翻硬币”的游戏。
	// * 桌上放着排成一排的若干硬币。我们用 * 表示正面，用 o 表示反面（是小写字母，不是零）。
	// * 比如，可能情形是：**oo***oooo
	// * 如果同时翻转左边的两个硬币，则变为：oooo***oooo
	// * 现在小明的问题是：如果已知了初始状态和要达到的目标状态，每次只能同时翻转相邻的两个硬币,
	// * 那么对特定的局面，最少要翻动多少次呢？
	// * 我们约定：把翻动相邻的两个硬币叫做一步操作，那么要求：
	// * 输入格式
	// * 两行等长的字符串，分别表示初始状态和要达到的目标状态。每行的长度<1000
	// * 输出格式
	// * 一个整数，表示最小操作步数。
	// *
	// * 样例输入1
	// * **********
	// * o****o****
	// * 样例输出1
	// * 5
	// * 样例输入2
	// * *o**o***o***
	// * *o***o**o***
	// * 样例输出2
	// * 1
	// * */
	private static void PREV_6() {
		Scanner sc = new Scanner(System.in);
		final String init = sc.next();
		String done = sc.next();
		sc.close();

		int flag = 0;

		for (int i = 0; i < init.length() - 1; i++) {
			if (init.charAt(i) == done.charAt(i)) {
				continue;
			} else {
				String m = "" + done.charAt(i);
				String n = "" + done.charAt(i + 1);
				// System.out.println(m+" "+n);
				StringBuilder sb = new StringBuilder(done);
				if (m.equals("*")) {
					m = "o";
				} else {
					m = "*";
				}
				if (n.equals("*")) {
					n = "o";
				} else {
					n = "*";
				}
				sb.replace(i, i + 1, m);
				sb.replace(i + 1, i + 2, n);
				done = sb.toString();
				// System.out.println(done);
				flag++;
			}
		}
		System.out.println(flag);
	}

	// /*
	// * 历届试题 错误票据
	// *
	// * 问题描述
	// * 某涉密单位下发了某种票据，并要在年终全部收回。
	// * 每张票据有唯一的ID号。全年所有票据的ID号是连续的，但ID的开始数码是随机选定的。
	// * 因为工作人员疏忽，在录入ID号的时候发生了一处错误，造成了某个ID断号，另外一个ID重号。
	// * 你的任务是通过编程，找出断号的ID和重号的ID。
	// * 假设断号不可能发生在最大和最小号。
	// * 输入格式
	// * 要求程序首先输入一个整数N(N<100)表示后面数据行数。
	// * 接着读入N行数据。
	// * 每行数据长度不等，是用空格分开的若干个（不大于100个）正整数（不大于100000），请注意行内和行末可能有多余的空格，你的
	// * 程序需要能处理这些空格。
	// * 每个整数代表一个ID号。
	// * 输出格式
	// * 要求程序输出1行，含两个整数m n，用空格分隔。
	// * 其中，m表示断号ID，n表示重号ID
	// *
	// * 样例输入1
	// * 2
	// * 5 6 8 11 9
	// * 10 12 9
	// * 样例输出1
	// * 7 9
	// * 样例输入2
	// * 6
	// * 164 178 108 109 180 155 141 159 104 182 179 118 137 184 115 124 125 129
	// 168 196
	// * 172 189 127 107 112 192 103 131 133 169 158
	// * 128 102 110 148 139 157 140 195 197
	// * 185 152 135 106 123 173 122 136 174 191 145 116 151 143 175 120 161 134
	// 162 190
	// * 149 138 142 146 199 126 165 156 153 193 144 166 170 121 171 132 101 194
	// 187 188
	// * 113 130 176 154 177 120 117 150 114 183 186 181 100 163 160 167 147 198
	// 111 119
	// * 样例输出2
	// * 105 120
	// * */
	private static void PREV_5() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String data[] = new String[n + 1];
		for (int i = 0; i <= n; i++) {
			data[i] = sc.nextLine();
		}
		sc.close();

		java.util.List<Integer> list = new java.util.ArrayList<Integer>();

		for (int i = 1; i < data.length; i++) {
			String[] sourceStrArray = data[i].split(" ");
			for (int j = 0; j < sourceStrArray.length; j++) {
				list.add(Integer.parseInt(sourceStrArray[j]));
			}
		}

		java.util.Collections.sort(list);
		// System.out.println(list);
		int chongfu = -1;
		int lost = -1;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).equals(list.get(i + 1))) {
				chongfu = list.get(i);
				break;
			}
		}

		for (int i = 0; i < list.size() - 1; i++) {
			if ((int) list.get(i + 1) - (int) (list.get(i)) == 2) {
				lost = (int) (list.get(i)) + 1;
			}

		}

		System.out.println(lost + " " + chongfu);
	}

	// /*
	// * 历届试题 带分数
	// *
	// * 问题描述
	// * 100 可以表示为带分数的形式：100 = 3 + 69258 / 714。
	// * 还可以表示为：100 = 82 + 3546 / 197。
	// * 注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
	// * 类似这样的带分数，100 有 11 种表示法。
	// * 输入格式
	// * 从标准输入读入一个正整数N (N<1000*1000)
	// * 输出格式
	// * 程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
	// * 注意：不要求输出每个表示，只统计有多少表示法！
	// *
	// * 样例输入1
	// * 100
	// * 样例输出1
	// * 11
	// * 样例输入2
	// * 105
	// * 样例输出2
	// * 6
	// * */
	// 该程序运行超时
	private static int PREV_3_N;
	private static int PREV_3_Count = 0;
	private static int[] PREV_3_A = new int[9];
	private static boolean[] PREV_3_Flag = new boolean[9];

	private static void PREV_3() {
		Scanner sc = new Scanner(System.in);
		PREV_3_N = sc.nextInt();
		sc.close();
		PREV_3_String(0);
		System.out.println(PREV_3_Count);
	}

	// 穷举所有可能的排列顺序
	private static void PREV_3_String(int i) {
		if (i == 9) {
			String string = "";
			for (int j = 0; j < PREV_3_A.length; j++) {
				string += PREV_3_A[j];
			}
			PREV_3_Count(string);
			// System.out.println(string);
		} else {
			for (int j = 0; j < PREV_3_A.length; j++) {
				if (!PREV_3_Flag[j]) {
					PREV_3_Flag[j] = true;
					PREV_3_A[i] = j + 1;
					PREV_3_String(i + 1);
					PREV_3_Flag[j] = false;
				}
			}

		}
	}

	private static void PREV_3_Count(String string) {
		int numLen = (PREV_3_N + "").length();

		for (int i = 0; i < numLen; i++) {
			int a = Integer.parseInt(string.substring(0, i + 1));
			// System.out.println(a);
			if (a < PREV_3_N) {
				for (int j = ((9 - i) / 2 + i); j < 9; j++) {
					long b = Long.parseLong(string.substring(i + 1, j));
					long c = Long.parseLong(string.substring(j));
					// System.out.println(b + " " + c);
					if (b % c != 0) {
						continue;
					} else {
						if (a + b / c == PREV_3_N) {
							PREV_3_Count++;
						}
					}
				}
			}
		}
	}

	// /*
	// * 历届试题 打印十字图
	// * 问题描述
	// * 小明为某机构设计了一个十字型的徽标（并非红十字会啊），如下所示：
	// * ..$$$$$$$$$$$$$..
	// * ..$...........$..
	// * $$$.$$$$$$$$$.$$$
	// * $...$.......$...$
	// * $.$$$.$$$$$.$$$.$
	// * $.$...$...$...$.$
	// * $.$.$$$.$.$$$.$.$
	// * $.$.$...$...$.$.$
	// * $.$.$.$$$$$.$.$.$
	// * $.$.$...$...$.$.$
	// * $.$.$$$.$.$$$.$.$
	// * $.$...$...$...$.$
	// * $.$$$.$$$$$.$$$.$
	// * $...$.......$...$
	// * $$$.$$$$$$$$$.$$$
	// * ..$...........$..
	// * ..$$$$$$$$$$$$$..
	// * 对方同时也需要在电脑dos窗口中以字符的形式输出该标志，并能任意控制层数。
	// * 输入格式
	// * 一个正整数 n (n<30) 表示要求打印图形的层数。
	// * 输出格式
	// * 对应包围层数的该标志。
	// * 样例输入1
	// * 1
	// * 样例输出1
	// * ..$$$$$..
	// * ..$...$..
	// * $$$.$.$$$
	// * $...$...$
	// * $.$$$$$.$
	// * $...$...$
	// * $$$.$.$$$
	// * ..$...$..
	// * ..$$$$$..
	// * 样例输入2
	// * 2
	// * ..$$$$$$$$$$$$$..
	// * ..$...........$..
	// * $$$.$$$$$$$$$.$$$
	// * $...$.......$...$
	// * $.$$$.$$$$$.$$$.$
	// * $.$...$...$...$.$
	// * $.$.$$$.$.$$$.$.$
	// * $.$.$...$...$.$.$
	// * $.$.$.$$$$$.$.$.$
	// * $.$.$...$...$.$.$
	// * $.$.$$$.$.$$$.$.$
	// * $.$...$...$...$.$
	// * $.$$$.$$$$$.$$$.$
	// * $...$.......$...$
	// * $$$.$$$$$$$$$.$$$
	// * ..$...........$..
	// * ..$$$$$$$$$$$$$..
	// *
	// * 提示
	// * 请仔细观察样例，尤其要注意句点的数量和输出位置。
	// * */
	private static void PREV_2() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int length = 4 * n + 5;

		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= length; j++) {
				if (PREV_2_Do(i, j, n) == 1) {
					System.out.print("$");
				} else {
					System.out.print(".");
				}

			}
			System.out.println();
		}

	}

	private static int PREV_2_Do(int i, int j, int n) {
		// 由于对称
		if (i > n * 2 + 3)
			i = n * 4 + 6 - i;
		if (j > n * 2 + 3)
			j = n * 4 + 6 - j;

		if (i <= 2 && j <= 2)
			return 0;// 前2行开头的两个"."
		if (i == 2 && j > 3)
			return 0;// 第二行中间的那些"."

		if (i > 2 && i % 2 == 1 && j % 2 == 0) {
			if (j == i + 1) {
				return 0;
			} else if (j <= i - 3) {
				return 0;
			}
		} // 奇数行中间的点

		if (i > 2 && i % 2 == 0) {
			if (j % 2 == 0 || j > i + 2) {
				return 0;
			} else if (j == i - 1) {
				return 0;
			}
		} // 偶数行中间的点

		return 1;
	}

	// /*
	// * 历届试题 核桃的数量
	// *
	// * 问题描述
	// * 小张是软件项目经理，他带领3个开发组。工期紧，今天都在加班呢。为鼓舞士气，小张打算给每个组发一袋核桃（据传言能补
	// * 脑）。他的要求是：
	// * 1. 各组的核桃数量必须相同
	// * 2. 各组内必须能平分核桃（当然是不能打碎的）
	// * 3. 尽量提供满足1,2条件的最小数量（节约闹革命嘛）
	// * 输入格式
	// * 输入包含三个正整数a, b, c，表示每个组正在加班的人数，用空格分开（a,b,c<30）
	// * 输出格式
	// * 输出一个正整数，表示每袋核桃的数量。
	// *
	// * 样例输入1
	// * 2 4 5
	// * 样例输出1
	// * 20
	// * 样例输入2
	// * 3 1 1
	// * 样例输出2
	// * 3
	// * */
	private static void PREV_1() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();

		int max = 0;
		if (a > max) {
			max = a;
		}
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}

		// System.out.println(max);
		for (int i = max; i <= a * b * c; i++) {
			if ((i % a == 0) && (i % b == 0) && (i % c == 0)) {
				System.out.println(i);
				break;
			}
		}

	}

}
