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
		// ALGO_64();
		// ALGO_63();
		// ALGO_62();
		// ALGO_61();
		// ALGO_60(); //TODO
		// ALGO_59(); //TODO
		// ALGO_58();
		// ALGO_43();
		// ALGO_13();
		// ALGO_12();
		// ALGO_11();
		// ALGO_10();
		// ALGO_9();
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
	// * 算法训练 大小写判断
	// *
	// * 问题描述
	// * 给定一个英文字母判断这个字母是大写还是小写。
	// * 输入格式
	// * 输入只包含一个英文字母c。
	// * 输出格式
	// * 如果c是大写字母，输出“upper”，否则输出“lower”。
	// *
	// * 样例输入
	// * x
	// * 样例输出
	// * lower
	// * 样例输入
	// * B
	// * 样例输出
	// * upper
	// */
	@SuppressWarnings("unused")
	private static void ALGO_64() {
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		sc.close();

		char c = string.charAt(0);

		if (c > 96) {
			System.out.println("lower");
		} else {
			System.out.println("upper");
		}
	}

	// /*
	// * 算法训练 乘法表
	// *
	// * 问题描述
	// * 输出九九乘法表。
	// * 输出格式
	// * 输出格式见下面的样例。乘号用“*”表示。
	// *
	// * 样例输出
	// * 下面给出输出的前几行：
	// * 1*1=1
	// * 2*1=2 2*2=4
	// * 3*1=3 3*2=6 3*3=9
	// * 4*1=4 4*2=8 4*3=12 4*4=16
	// * ……
	// */
	@SuppressWarnings("unused")
	private static void ALGO_63() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + " ");
			}
			System.out.println();
		}
	}

	// /*
	// * 算法训练 平方计算
	// *
	// * 问题描述
	// * 输入正整数a, m，输出a^2%m，其中^表示乘方，即a^2表示a的平方，%表示取余。
	// * 输入格式
	// * 输入包含两个整数a, m，a不超过10000。
	// * 输出格式
	// * 输出一个整数，即a^2%m的值。
	// *
	// * 样例输入
	// * 5 6
	// * 样例输出
	// * 1
	// */
	@SuppressWarnings("unused")
	private static void ALGO_62() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int m = sc.nextInt();
		sc.close();

		System.out.println((a * a) % m);

	}

	// /*
	// * 算法训练 奇偶判断
	// *
	// * 问题描述
	// * 能被2整除的数称为偶数，不能被2整除的数称为奇数。给一个整数x，判断x是奇数还是偶数。
	// * 输入格式
	// * 输入包括一个整数x，0<=x<=100000000。
	// * 输出格式
	// * 如果x是奇数，则输出“odd”，如果是偶数，则输出“even”。
	// *
	// * 样例输入
	// * 10
	// * 样例输出
	// * even
	// * 样例输入
	// * 2009
	// * 样例输出
	// * odd
	// */
	@SuppressWarnings("unused")
	private static void ALGO_61() {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();

		if (x % 2 == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
	}

	// /*
	// * 算法训练 字串逆序
	// *
	// * 问题描述
	// * 给定一个字符串，将这个串的所有字母逆序后输出。
	// * 输入格式
	// * 输入包含一个字符串，长度不超过100，字符串中不含空格。
	// * 输出格式
	// * 输出包含一个字符串，为上面字符串的逆序。
	// *
	// * 样例输入
	// * tsinsen
	// * 样例输出
	// * nesnist
	// */
	@SuppressWarnings("unused")
	private static void ALGO_58() {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();

		StringBuffer sb = new StringBuffer(str);
		str = sb.reverse().toString();
		System.out.println(str);
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
	// * 算法训练 拦截导弹
	// *
	// * 问题描述
	// * 某国为了防御敌国的导弹袭击，发展出一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：虽然
	// * 它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。某天，雷达捕
	// * 捉到敌国的导弹来袭。由于该系统还在试用阶段，所以只有一套系统，因此有可能不能拦截所有的导弹。
	// * 输入导弹依次飞来的高度（雷达给出的高度数据是不大于30000的正整数），计算这套系统最多能拦截
	// * 多少导弹，如果要拦截所有导弹最少要配备多少套这种导弹拦截系统。
	// * 输入格式
	// * 一行，为导弹依次飞来的高度
	// * 输出格式
	// * 两行，分别是最多能拦截的导弹数与要拦截所有导弹最少要配备的系统数
	// *
	// * 样例输入
	// * 389 207 155 300 299 170 158 65
	// * 样例输出
	// * 6
	// * 2
	// */
	@SuppressWarnings("unused")
	private static void ALGO_13() {

		java.util.List<Integer> daodan = new java.util.ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);
		String strin = sc.nextLine();
		sc.close();

		String strnum[] = strin.split(" ");

		for (int i = 0; i < strnum.length; i++) {
			daodan.add(Integer.parseInt(strnum[i]));
		}

		int len = daodan.size();

		int num[] = new int[len];
		int dp[] = new int[len];

		int Max = dp[0] = 1;
		int Max2 = num[0] = 1;

		for (int i = 1; i < len; i++) {
			dp[i] = 1;
			num[i] = 1;

			for (int j = 0; j < len; j++) {

				if (daodan.get(i) < daodan.get(j) && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}

				if (daodan.get(i) > daodan.get(j) && num[i] <= num[j]) {
					num[i] = num[j] + 1;
				}

			}

			if (Max < dp[i])
				Max = dp[i];
			if (Max2 < num[i])
				Max2 = num[i];

		}
		System.out.println(Max);
		System.out.println(Max2);

	}

	// /*
	// * 算法训练 幂方分解
	// *
	// * 问题描述
	// * 任何一个正整数都可以用2的幂次方表示。例如：
	// * 137=2^7+2^3+2^0
	// * 同时约定方次用括号来表示，即a^b 可表示为a（b）。
	// * 由此可知，137可表示为：
	// * 2（7）+2（3）+2（0）
	// * 进一步：7= 2^2+2+2^0 （2^1用2表示）
	// * 3=2+2^0
	// * 所以最后137可表示为：
	// * 2（2（2）+2+2（0））+2（2+2（0））+2（0）
	// * 又如：
	// * 1315=2^10 +2^8 +2^5 +2+1
	// * 所以1315最后可表示为：
	// * 2（2（2+2（0））+2）+2（2（2+2（0）））+2（2（2）+2（0））+2+2（0）
	// * 输入格式
	// * 输入包含一个正整数N（N<=20000），为要求分解的整数。
	// * 输出格式
	// * 程序输出包含一行字符串，为符合约定的n的0，2表示（在表示中不能有空格）
	// */
	@SuppressWarnings("unused")
	private static void ALGO_12() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();

		System.out.println(ALGO_12_DO(num));

	}

	private static String ALGO_12_DO(int num) {

		Boolean[] _boolean = new Boolean[16];
		for (int i = 0; i < _boolean.length; i++) {
			_boolean[i] = false;
		}

		String ALGO_12_str = "";

		ALGO_12_DFS(0, num, -1, _boolean);

		boolean flag = true;
		for (int i = 0; i < _boolean.length; i++) {

			if (_boolean[i]) {
				if (i == 1) {
					if (flag) {
						ALGO_12_str = "2" + ALGO_12_str;
						flag = false;
					} else {
						ALGO_12_str = "2+" + ALGO_12_str;
					}

				} else if (i == 0) {
					if (flag) {
						ALGO_12_str = "2(0)" + ALGO_12_str;
						flag = false;
					} else {
						ALGO_12_str = "2(0)+" + ALGO_12_str;
					}
				} else if (i == 2) {
					if (flag) {
						ALGO_12_str = "2(2)" + ALGO_12_str;
						flag = false;
					} else {
						ALGO_12_str = "2(2)+" + ALGO_12_str;
					}
				} else {

					if (flag) {

						ALGO_12_str = "2(" + ALGO_12_DO(i) + ")" + ALGO_12_str;
						flag = false;
					} else {
						ALGO_12_str = "2(" + ALGO_12_DO(i) + ")+" + ALGO_12_str;
					}

				}

			}

		}
		return ALGO_12_str;

	}

	private static boolean ALGO_12_DFS(int sum, int num, int n, Boolean[] _boolean) {
		if (sum == num) {
			return true;
		}

		// if (sum > ALGO_12_n) {
		// return false;
		// }

		if (n == 15) {
			return sum == num;
		}
		_boolean[n + 1] = true;
		if (ALGO_12_DFS(sum + (int) Math.pow(2, n + 1), num, n + 1, _boolean)) {
			return true;
		}

		_boolean[n + 1] = false;
		if (ALGO_12_DFS(sum, num, n + 1, _boolean)) {
			return true;
		}

		return false;
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
	// * 算法训练 集合运算
	// *
	// * 问题描述
	// * 给出两个整数集合A、B，求出他们的交集、并集以及B在A中的余集。
	// * 输入格式
	// * 第一行为一个整数n，表示集合A中的元素个数。
	// * 第二行有n个互不相同的用空格隔开的整数，表示集合A中的元素。
	// * 第三行为一个整数m，表示集合B中的元素个数。
	// * 第四行有m个互不相同的用空格隔开的整数，表示集合B中的元素。
	// * 集合中的所有元素均为int范围内的整数，n、m<=1000。
	// * 输出格式
	// * 第一行按从小到大的顺序输出A、B交集中的所有元素。
	// * 第二行按从小到大的顺序输出A、B并集中的所有元素。
	// * 第三行按从小到大的顺序输出B在A中的余集中的所有元素。
	// *
	// * 样例输入
	// * 5
	// * 1 2 3 4 5
	// * 5
	// * 2 4 6 8 10
	// * 样例输出
	// * 2 4
	// * 1 2 3 4 5 6 8 10
	// * 1 3 5
	// * 样例输入
	// * 4
	// * 1 2 3 4
	// * 3
	// * 5 6 7
	// * 样例输出
	// * 1 2 3 4 5 6 7
	// * 1 2 3 4
	// */
	@SuppressWarnings("unused")
	private static void ALGO_10() {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int aa[] = new int[a];
		for (int i = 0; i < aa.length; i++) {
			aa[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		int ba[] = new int[b];
		for (int i = 0; i < ba.length; i++) {
			ba[i] = sc.nextInt();
		}
		sc.close();

		java.util.List<Integer> jiao = new java.util.ArrayList<Integer>();
		java.util.List<Integer> bing = new java.util.ArrayList<Integer>();
		java.util.List<Integer> yu = new java.util.ArrayList<Integer>();
		for (int i = 0; i < aa.length; i++) {
			bing.add(aa[i]);
		}
		for (int i = 0; i < ba.length; i++) {
			if (ALGO_10_Do(aa, ba[i])) {
				jiao.add(ba[i]);
			} else {
				bing.add(ba[i]);
			}
		}

		boolean flag;
		for (int j = 0; j < aa.length; j++) {
			flag = true;
			for (int i = 0; i < jiao.size(); i++) {
				if (aa[j] == jiao.get(i)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				yu.add(aa[j]);
			}
		}

		java.util.Collections.sort(jiao);
		java.util.Collections.sort(bing);
		java.util.Collections.sort(yu);

		for (int i = 0; i < jiao.size(); i++) {
			System.out.print(jiao.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < bing.size(); i++) {
			System.out.print(bing.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < yu.size(); i++) {
			System.out.print(yu.get(i) + " ");
		}
		System.out.println();

	}

	private static boolean ALGO_10_Do(int a[], int b) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] == b) {
				return true;
			}
		}
		return false;

	}

	// /*
	// * 算法训练 摆动序列
	// *
	// * 问题描述
	// * 如果一个序列满足下面的性质，我们就将它称为摆动序列：
	// * 1. 序列中的所有数都是不大于k的正整数；
	// * 2. 序列中至少有两个数。
	// * 3. 序列中的数两两不相等；
	// * 4. 如果第i – 1个数比第i – 2个数大，则第i个数比第i – 2个数小；如果
	// * 第i – 1个数比第i – 2个数小，则第i个数比第i – 2个数大。
	// * 比如，当k = 3时，有下面几个这样的序列：
	// * 1 2
	// * 1 3
	// * 2 1
	// * 2 1 3
	// * 2 3
	// * 2 3 1
	// * 3 1
	// * 3 2
	// * 一共有8种，给定k，请求出满足上面要求的序列的个数。
	// * 输入格式
	// * 输入包含了一个整数k。（k<=20）
	// * 输出格式
	// * 输出一个整数，表示满足要求的序列个数。
	// *
	// * 样例输入
	// * 3
	// * 样例输出
	// * 8
	// */
	@SuppressWarnings("unused")
	private static void ALGO_9() {
		Scanner sc = new Scanner(System.in);
		ALGO_9_n = sc.nextInt();
		sc.close();
		for (int i = 0; i < ALGO_9_IsVisit.length; i++) {
			ALGO_9_IsVisit[i] = false;
		}
		ALGO_9_DFS(1);
		System.out.println(ALGO_9_ans);

	}

	private static int ALGO_9_n = 0;
	private static int ALGO_9_ans = 0;
	private static int ALGO_9_a[] = new int[25];
	private static boolean ALGO_9_IsVisit[] = new boolean[25];

	private static boolean ALGO_9_IsCan(int num, int k) {
		if (k == 1 || k == 2)
			return true;
		if (ALGO_9_a[k - 1] > ALGO_9_a[k - 2] && num < ALGO_9_a[k - 2])
			return true;
		if (ALGO_9_a[k - 1] < ALGO_9_a[k - 2] && num > ALGO_9_a[k - 2])
			return true;
		return false;
	}

	private static void ALGO_9_DFS(int cur) {
		if (cur > ALGO_9_n)
			return;
		for (int i = 1; i <= ALGO_9_n; i++) {
			if (!ALGO_9_IsVisit[i] && ALGO_9_IsCan(i, cur)) {
				ALGO_9_IsVisit[i] = true;
				ALGO_9_a[cur] = i;
				if (cur >= 2) {
					ALGO_9_ans++;
				}
				ALGO_9_DFS(cur + 1);
				ALGO_9_IsVisit[i] = false;
			}
		}
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

	private static void ALGO_60() {
		float a[][] = new float[2][2];
		Scanner sc = new Scanner(System.in);
		float b = sc.nextFloat();
		float m = sc.nextFloat();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextFloat();
			}
		}
		sc.close();

		if (b == 0) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					if (i == j) {
						System.out.print(1 % m + " ");
					} else {
						System.out.print(0 + " ");
					}
				}
				System.out.println();
			}
			return;
		} else if (b % 2 == 0) {
			//
			//
			float temp[][] = new float[2][2];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					temp[i][j] = a[i][j];
				}
			}
			//
			for (int j2 = 0; j2 < b / 2; j2++) {
				temp = ALGO_60_Matrix(a, temp);
			}
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {

					temp[i][j] %= m;
				}
			}
			for (int j2 = 0; j2 < 2; j2++) {
				temp = ALGO_60_Matrix(temp, temp);
			}
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {

					System.out.print(temp[i][j] % m + " ");
				}
				System.out.println();
			}
		} else {
			//
			//
			float temp[][] = new float[2][2];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					temp[i][j] = a[i][j];
				}
			}
			//
			for (float j2 = 0; j2 < b - 1; j2++) {
				temp = ALGO_60_Matrix(temp, a);
			}
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					temp[i][j] %= m;
				}
			}

			temp = ALGO_60_Matrix(a, temp);
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					System.out.print(temp[i][j] % m + " ");
				}
				System.out.println();
			}
		}

	}

	private static float[][] ALGO_60_Matrix(float a[][], float b[][]) {
		float c[][] = new float[a.length][b[0].length];

		int x, i, j;
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < b[0].length; j++) {
				float temp = 0;
				for (x = 0; x < b.length; x++) {
					temp += a[i][x] * b[x][j];
				}
				c[i][j] = temp;

			}
		}
		return c;
	}

	private static void ALGO_59() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		ALGO_59_QuickSort(a, 0, a.length - 1);
		// java.util.Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}

	private static void ALGO_59_QuickSort(int arr[], int low, int high) {
		int l = low;
		int h = high;
		int povit = arr[l];

		while (l < h) {
			while (l < h && arr[h] > povit) {
				h--;
			}
			if (l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}

			while (l < h && arr[l] <= povit) {
				l++;
			}
			if (l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;

			}
		}

		if (l > low) {
			ALGO_59_QuickSort(arr, low, l - 1);
		}
		if (h < high) {
			ALGO_59_QuickSort(arr, l + 1, high);
		}

	}

}
