package main.lanqiaocup.algo;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		// ALGO_142();
		// ALGO_139();
		// ALGO_116();
		// ALGO_123();
		// ALGO_72();
		// ALGO_71();
		// ALGO_70();
		// ALGO_69();
		// ALGO_68();
		// ALGO_67();
		// ALGO_66();
		// ALGO_43();
		// ALGO_11();
		// ALGO_4();
		// ALGO_3();
		// ALGO_2();
		// ALGO_1();
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

	// /*
	// * 算法训练 s01串
	// *
	// * 问题描述
	// * s01串初始为"0"
	// * 按以下方式变换
	// * 0变1，1变01
	// * 输入格式
	// * 1个整数(0~19)
	// * 输出格式
	// * n次变换后s01串
	// *
	// * 样例输入
	// * 3
	// * 样例输出
	// * 101
	// *
	// * 数据规模和约定
	// * 0~19
	// */
	private static String ALGO_139_String;

	@SuppressWarnings("unused")
	private static void ALGO_139() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		ALGO_139_String = "0";
		for (int i = 0; i < n; i++) {
			ALGO_139_Do();
		}
		System.out.println(ALGO_139_String);
	}

	private static void ALGO_139_Do() {
		String temp = ALGO_139_String;
		ALGO_139_String = "";
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '0') {
				ALGO_139_String += "1";
			} else if (temp.charAt(i) == '1') {
				ALGO_139_String += "01";
			}
		}
	}

	// /*
	// * 算法训练 A+B problem
	// *
	// * 问题描述
	// * Given two integers A and B, your task is to output their sum, A+B.
	// * 输入格式
	// * The input contains of only one line, consisting of two integers A and
	// B. (0 ≤ A,B ≤ 1 000)
	// * 输出格式
	// * The output should contain only one number that is A+B.
	// * 样例输入
	// * 1 1
	// * 样例输出
	// * 2
	// */
	@SuppressWarnings("unused")
	private static void ALGO_123() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		System.out.println(a + b);
	}

	// /*
	// * 算法训练 成绩的等级输出
	// *
	// * 输入一个百分制的成绩t后，按下式输出它的等级。等级为：90~100为A，
	// * 80~89为B，70~79为C，60~69为D，0~59为E。
	// *
	// * 样例输入
	// * 98
	// * 样例输出
	// * A
	// */
	@SuppressWarnings("unused")
	private static void ALGO_72() {
		Scanner sc = new Scanner(System.in);
		float n = sc.nextFloat();
		sc.close();
		if (n >= 90) {
			System.out.println("A");
			return;
		} else if (n >= 80) {
			System.out.println("B");
			return;
		} else if (n >= 70) {
			System.out.println("C");
			return;
		} else if (n >= 60) {
			System.out.println("D");
			return;
		} else {
			System.out.println("E");
			return;
		}
	}

	// /*
	// * 算法训练 比较字符串
	// *
	// * 编程实现两个字符串s1和s2的字典序比较。（保证每一个字符串不是另一个的前缀，且长度在100以内）。
	// * 若s1和s2相等，输出0；若它们不相等，则指出其第一个不同字符的ASCII码的差值：如果s1>s2，则
	// * 差值为正；如果s1<s2，则差值为负。
	// *
	// * 样例输入
	// * java basic
	// * 样例输出
	// * 8
	// */
	@SuppressWarnings("unused")
	private static void ALGO_71() {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		sc.close();

		if (s1.equals(s2)) {
			System.out.println(0);
			return;
		} else {
			int temp = (s1.length() < s2.length() ? s1.length() : s2.length());
			for (int i = 0; i < temp; i++) {
				if ((s1.charAt(i) - s2.charAt(i)) == 0) {
					continue;
				} else {
					System.out.println(s1.charAt(i) - s2.charAt(i));
					break;
				}

			}
			return;
		}
	}

	// /*
	// * 算法训练 最长字符串
	// *
	// * 求出5个字符串中最长的字符串。每个字符串长度在100以内，且全为小写字母。
	// *
	// * 样例输入
	// * one two three four five
	// * 样例输出
	// * three
	// */
	@SuppressWarnings("unused")
	private static void ALGO_70() {
		String string[] = new String[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < string.length; i++) {
			string[i] = sc.next();
		}
		sc.close();

		String temp = "";
		for (int i = 0; i < string.length; i++) {
			if (temp.length() < string[i].length()) {
				temp = string[i];
			}
		}
		System.out.println(temp);
	}

	// /*
	// * 算法训练 字符串逆序
	// *
	// * 输入一个字符串，长度在100以内，按相反次序输出其中的所有字符。
	// *
	// * 样例输入
	// * tsinghua
	// * 样例输出
	// * auhgnist
	// */
	@SuppressWarnings("unused")
	private static void ALGO_69() {
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		sc.close();

		char a[] = string.toCharArray();
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i]);
		}
		System.out.println();

	}

	// /*
	// * 算法训练 判定数字
	// *
	// * 编写函数，判断某个给定字符是否为数字。
	// *
	// * 样例输入
	// * 9
	// * 样例输出
	// * yes
	// */
	@SuppressWarnings("unused")
	private static void ALGO_68() {
		Scanner sc = new Scanner(System.in);
		try {
			sc.nextDouble();
			System.out.println("yes");
		} catch (Exception e) {
			System.out.println("no");
		} finally {
			sc.close();
		}
	}

	// /*
	// * 算法训练 最大值与最小值的计算
	// *
	// * 输入11个整数，计算它们的最大值和最小值。
	// *
	// * 样例输入
	// * 0 1 2 3 4 5 6 7 8 9 10
	// * 样例输出
	// * 10 0
	// */
	@SuppressWarnings("unused")
	private static void ALGO_67() {
		int a[] = new int[11];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		java.util.Arrays.sort(a);

		System.out.println(a[a.length - 1] + " " + a[0]);
	}

	// /*
	// * 算法训练 字符串编辑
	// *
	// * 问题描述
	// * 从键盘输入一个字符串（长度<=40个字符），并以字符 ’.’ 结束。编辑功能有：
	// * 1 D：删除一个字符，命令的方式为： D a 其中a为被删除的字符，例如：D s
	// * 表示删除字符 ’s’ ，若字符串中有多个 ‘s’，则删除第一次出现的。
	// * 2 I：插入一个字符，命令的格式为：I a1 a2 其中a1表示插入到指定字符前面，
	// * a2表示将要插入的字符。例如：I s d 表示在指定字符 ’s’ 的前面插入字符 ‘d’ ，
	// * 若原串中有多个 ‘s’ ，则插入在最后一个字符的前面。
	// * 3 R：替换一个字符，命令格式为：R a1 a2 其中a1为被替换的字符，a2为替换
	// * 的字符，若在原串中有多个a1则应全部替换。
	// * 在编辑过程中，若出现被改的字符不存在时，则给出提示信息。
	// * 输入格式
	// * 输入共两行，第一行为原串(以’.’结束)，第二行为命令（输入方式参见“问题描述” 。
	// * 输出格式
	// * 输出共一行，为修改后的字符串或输出指定字符不存在的提示信息。
	// *
	// * 样例输入
	// * This is a book.
	// * D s
	// * 样例输出
	// * Thi is a book.
	// * 输入输出样例解释
	// * 命令为删去s，第一个在字符中出现的s在This中，即得到结果。
	// */
	@SuppressWarnings("unused")
	private static void ALGO_66() {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		char type = sc.next().charAt(0);
		String letter = null;
		String letter1 = null;
		if (type == 'D') {
			letter = sc.next();
		} else {
			letter = sc.next();
			letter1 = sc.next();
		}

		sc.close();

		if (!string.contains(letter)) {
			System.out.println("指定字符不存在");
			return;
		}

		switch (type) {
		case 'D':
			System.out.println(string.replaceFirst(letter, ""));
			break;
		case 'I':
			char a[] = string.toCharArray();
			String str = "";
			boolean isDone = false;
			for (int i = a.length - 1; i >= 0; i--) {
				if (a[i] == letter.charAt(0)) {
					if (isDone) {
						str += a[i];
					} else {
						str += a[i] + letter1;
						isDone = true;
					}
				} else {
					str += a[i];
				}
			}
			StringBuffer sb = new StringBuffer(str);
			string = sb.reverse().toString();
			System.out.println(string);
			break;
		case 'R':
			System.out.println(string.replaceAll(letter, letter1));
			break;
		default:
			break;
		}

	}

	// /*
	// * 算法训练 A+B Problem
	// *
	// * 问题描述
	// * 输入A,B。
	// * 输出A+B。
	// * 输入格式
	// * 输入包含两个整数A,B，用一个空格分隔。
	// * 输出格式
	// * 输出一个整数，表示A+B的值。
	// *
	// * 样例输入
	// * 5 8
	// * 样例输出
	// * 13
	// *
	// * 数据规模和约定
	// * -1,000,000,000<=A,B<=1,000,000,000。
	// */
	@SuppressWarnings("unused")
	private static void ALGO_43() {
		Scanner sc = new Scanner(System.in);
		java.math.BigInteger a = sc.nextBigInteger();
		java.math.BigInteger b = sc.nextBigInteger();
		sc.close();
		System.out.println(a.add(b));
	}

	// /*
	// * 算法训练 瓷砖铺放
	// *
	// * 问题描述
	// * 有一长度为N(1<=Ｎ<=10)的地板，给定两种不同瓷砖：一种长度为1，另一种长度为2，数目不限。
	// * 要将这个长度为N的地板铺满，一共有多少种不同的铺法？
	// * 例如，长度为4的地面一共有如下5种铺法：
	// * 4=1+1+1+1
	// * 4=2+1+1
	// * 4=1+2+1
	// * 4=1+1+2
	// * 4=2+2
	// * 编程用递归的方法求解上述问题。
	// * 输入格式
	// * 只有一个数N，代表地板的长度
	// * 输出格式
	// * 输出一个数，代表所有不同的瓷砖铺放方法的总数
	// *
	// * 样例输入
	// * 4
	// * 样例输出
	// * 5
	// */
	private static int ALGO_11_Sum;

	@SuppressWarnings("unused")
	private static void ALGO_11() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		ALGO_11_Sum = 0;
		ALGO_11_dfs(N);
		System.out.println(ALGO_11_Sum);

	}

	private static boolean ALGO_11_dfs(int n) {
		if (n == 1) {
			ALGO_11_Sum += 1;
			return false;
		}
		if (n == 2) {
			ALGO_11_Sum += 2;
			return false;
		}
		ALGO_11_dfs(n - 1);
		ALGO_11_dfs(n - 2);
		return true;
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

	// 下面都是没完全正确的
	//
	//
	//
	//
	//
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

	private static void ALGO_4() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int b[][] = new int[n - 1][2];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = sc.nextInt();
			}
		}
		sc.close();

	}

}
