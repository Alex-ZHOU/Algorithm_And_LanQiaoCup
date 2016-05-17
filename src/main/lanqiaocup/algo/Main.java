package main.lanqiaocup.algo;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		// ALGO_142();
		// ALGO_139();
		// ALGO_116();
		// ALGO_123();
		// ALGO_100();
		// ALGO_99();
		// ALGO_98();
		// ALGO_97();
		// ALGO_96();
		// ALGO_95();
		// ALGO_94();
		// ALGO_93();
		// ALGO_92();
		// ALGO_91();
		// ALGO_90();
		// ALGO_89();
		// ALGO_88();
		// ALGO_87();
		// ALGO_86();
		// ALGO_85();
		// ALGO_84();
		// ALGO_83();
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
		// ALGO_8();
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

	/// *
	// * 算法训练 整除问题
	// *
	// * 问题描述
	// * 编写一个程序，输入三个正整数min、max和factor，然后对于min到max之间的每一个整数（包括min和max），
	// * 如果它能被factor整除，就把它打印出来。
	// * 输入格式：
	// * 输入只有一行，包括三个整数min、max和factor。
	// * 输出格式：
	// * 输出只有一行，包括若干个整数。
	// *
	// * 输入输出样例
	// * 样例输入
	// * 1 10 3
	// * 样例输出
	// * 3 6 9
	// */
	@SuppressWarnings("unused")
	private static void ALGO_100() {
		Scanner sc = new Scanner(System.in);
		int min = sc.nextInt();
		int max = sc.nextInt();
		int factor = sc.nextInt();
		sc.close();

		while (!(min % factor == 0)) {
			min++;
		}

		for (int i = min; i <= max; i += factor) {
			System.out.print(i + " ");
		}
	}

	// /*
	// * 算法训练 薪水计算
	// *
	// * 问题描述
	// * 编写一个程序，计算员工的周薪。薪水的计算是以小时为单位，如果在一周的时间内，
	// * 员工工作的时间不超过40 个小时，那么他/她的总收入等于工作时间乘以每小时的薪
	// * 水。如果员工工作的时间在40 到50 个小时之间，那么对于前40 个小时，仍按常规
	// * 方法计算；而对于剩余的超额部分，每小时的薪水按1.5 倍计算。如果员工工作的时
	// * 间超过了50 个小时，那么对于前40 个小时，仍按常规方法计算；对于40～50 个小
	// * 时之间的部分，每小时的薪水按1.5 倍计算；而对于超出50 个小时的部分，每小时的
	// * 薪水按2 倍计算。请编写一个程序，输入员工的工作时间和每小时的薪水，然后计算并显
	// * 示他/她应该得到的周薪。
	// * 输入格式：
	// * 输入只有一行，包括一个整数和一个实数，分别表示工作时间和每小时薪水。
	// * 输出格式：
	// * 输出只有一个实数，表示周薪，保留小数点后2位。
	// *
	// * 输入输出样例
	// * 样例输入
	// * 40 50
	// * 样例输出
	// * 2000.00
	// */
	@SuppressWarnings("unused")
	private static void ALGO_99() {
		Scanner sc = new Scanner(System.in);
		float workTime = sc.nextFloat();
		float money = sc.nextFloat();
		sc.close();

		if (workTime <= 40) {
			System.out.printf("%.2f", (double) (workTime * money));
			return;
		} else if (workTime <= 50) {
			System.out.printf("%.2f", (double) (40 * money + (workTime - 40) * 1.5 * money));
			return;
		} else {
			System.out.printf("%.2f", (double) (40 * money + 10 * 1.5 * money + (workTime - 50) * 2 * money));
		}
	}

	// /*
	// * 算法训练 数位分离
	// *
	// * 问题描述
	// * 编写一个程序，输入一个1000 以内的正整数，然后把这个整数的每一位数字都分离出来，并逐一地显示。
	// * 输入格式：输入只有一行，即一个1000以内的正整数。
	// * 输出格式：输出只有一行，即该整数的每一位数字，之间用空格隔开。
	// *
	// * 输入输出样例
	// * 样例输入
	// * 769
	// * 样例输出
	// * 7 6 9
	// */
	@SuppressWarnings("unused")
	private static void ALGO_98() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();

		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) + " ");
		}
	}

	// /*
	// * 算法训练 排序
	// *
	// * 问题描述
	// * 编写一个程序，输入3个整数，然后程序将对这三个整数按照从大到小进行排列。
	// * 输入格式：输入只有一行，即三个整数，中间用空格隔开。
	// * 输出格式：输出只有一行，即排序后的结果。
	// *
	// * 输入输出样例
	// * 样例输入
	// * 9 2 30
	// * 样例输出
	// * 30 9 2
	// */
	@SuppressWarnings("unused")
	private static void ALGO_97() {
		int a[] = new int[3];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		java.util.Arrays.sort(a);
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
	}

	/// *
	// * 算法训练 Hello World!
	// *
	// * 描述
	// * 本题定义本学期作业题的输出格式，请认真阅读。
	// * 如无特殊说明，开头无空格，间隔符为1个空格，答案最后必须输出换行符("\n")。
	// * 输入格式
	// * 无
	// * 输出格式
	// * Hello World!
	// */
	@SuppressWarnings("unused")
	private static void ALGO_96() {
		System.out.println("Hello World!");
	}

	// /*
	// * 算法训练 2的次幂表示
	// *
	// * 问题描述
	// * 任何一个正整数都可以用2进制表示，例如：137的2进制表示为10001001。
	// * 将这种2进制表示写成2的次幂的和的形式，令次幂高的排在前面，可得到如下表达式：137=2^7+2^3+2^0
	// * 现在约定幂次用括号来表示，即a^b表示为a（b）
	// * 此时，137可表示为：2（7）+2（3）+2（0）
	// * 进一步：7=2^2+2+2^0 （2^1用2表示）
	// * 3=2+2^0
	// * 所以最后137可表示为：2（2（2）+2+2（0））+2（2+2（0））+2（0）
	// * 又如：1315=2^10+2^8+2^5+2+1
	// * 所以1315最后可表示为：
	// * 2（2（2+2（0））+2）+2（2（2+2（0）））+2（2（2）+2（0））+2+2（0）
	// * 输入格式
	// * 正整数（1<=n<=20000）
	// * 输出格式
	// * 符合约定的n的0，2表示（在表示中不能有空格)
	// *
	// * 样例输入
	// * 137
	// * 样例输入
	// * 2(2(2)+2+2(0))+2(2+2(0))+2(0)
	// * 样例输出
	// * 1315
	// * 样例输出
	// * 2(2(2+2(0))+2)+2(2(2+2(0)))+2(2(2)+2(0))+2+2(0)
	// *
	// * 提示
	// * 用递归实现会比较简单，可以一边递归一边输出
	// */
	@SuppressWarnings("unused")
	private static void ALGO_95() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();

		System.out.println(ALGO_95_DO(num));

	}

	private static String ALGO_95_DO(int num) {

		Boolean[] _boolean = new Boolean[16];
		for (int i = 0; i < _boolean.length; i++) {
			_boolean[i] = false;
		}

		String ALGO_95_str = "";

		ALGO_95_DFS(0, num, -1, _boolean);

		boolean flag = true;
		for (int i = 0; i < _boolean.length; i++) {

			if (_boolean[i]) {
				if (i == 1) {
					if (flag) {
						ALGO_95_str = "2" + ALGO_95_str;
						flag = false;
					} else {
						ALGO_95_str = "2+" + ALGO_95_str;
					}

				} else if (i == 0) {
					if (flag) {
						ALGO_95_str = "2(0)" + ALGO_95_str;
						flag = false;
					} else {
						ALGO_95_str = "2(0)+" + ALGO_95_str;
					}
				} else if (i == 2) {
					if (flag) {
						ALGO_95_str = "2(2)" + ALGO_95_str;
						flag = false;
					} else {
						ALGO_95_str = "2(2)+" + ALGO_95_str;
					}
				} else {

					if (flag) {

						ALGO_95_str = "2(" + ALGO_95_DO(i) + ")" + ALGO_95_str;
						flag = false;
					} else {
						ALGO_95_str = "2(" + ALGO_95_DO(i) + ")+" + ALGO_95_str;
					}

				}

			}

		}
		return ALGO_95_str;

	}

	private static boolean ALGO_95_DFS(int sum, int num, int n, Boolean[] _boolean) {
		if (sum == num) {
			return true;
		}
		if (n == 15) {
			return sum == num;
		}
		_boolean[n + 1] = true;
		if (ALGO_95_DFS(sum + (int) Math.pow(2, n + 1), num, n + 1, _boolean)) {
			return true;
		}

		_boolean[n + 1] = false;
		if (ALGO_95_DFS(sum, num, n + 1, _boolean)) {
			return true;
		}

		return false;
	}

	// /*
	// * 算法训练 新生舞会
	// * 问题描述
	// * 新生舞会开始了。n名新生每人有三个属性：姓名、学号、性别。其中，姓名用长度不超过20的仅由
	// * 大小写字母构成的字符串表示，学号用长度不超过10的仅由数字构成的字符串表示，性别用一个大写
	// * 字符‘F’或‘M’表示。任意两人的姓名、学号均互不相同。换言之，每个人可被其姓名或学号唯一确定。
	// * 给出m对两人的信息（姓名或学号），判断他们是否能共舞。两人能共舞的充要条件为两人性别相异。
	// * 输入
	// * 第一行一个整数n（2<=n<=1000），表示学生人数。接下来的n行每行依次包含一名新生的姓名、学
	// * 号、性别，分别用一个空格隔开。
	// * 之后的一行是一个整数m(1<=m<=1000)，表示询问的数目。接着的m行每行包含两个信息（姓名或学
	// * 号），保证两个信息不属于同一人，中间用一个空格隔开。
	// * 输出
	// * 对于每个询问输出一行，如果两人可以共舞，输出一个大写字母‘Y’，否则输出一个大写字母‘N’。
	// *
	// * 样例输入
	// * 4
	// * John 10 M
	// * Jack 11 M
	// * Kate 20 F
	// * Jim 21 M
	// * 3
	// * John 11
	// * 20 Jack
	// * Jim Jack
	// * 样例输出
	// * N
	// * Y
	// * N
	// */
	private static ALGO_94_Students ALGO_94_students[] = new ALGO_94_Students[1000];
	private static int ALGO_94_n;

	private static class ALGO_94_Students {
		String name;
		String num;
		// man is true and woman is false
		boolean sex;

	}

	@SuppressWarnings("unused")
	private static void ALGO_94() {
		Scanner sc = new Scanner(System.in);
		ALGO_94_n = sc.nextInt();
		for (int i = 0; i < ALGO_94_n; i++) {
			ALGO_94_students[i] = new ALGO_94_Students();
			ALGO_94_students[i].name = sc.next();
			ALGO_94_students[i].num = sc.next();
			ALGO_94_students[i].sex = (sc.next()).equals("M") ? true : false;
		}
		int m = sc.nextInt();
		String student1[] = new String[m];
		String student2[] = new String[m];
		for (int i = 0; i < m; i++) {
			student1[i] = sc.next();
			student2[i] = sc.next();
		}
		sc.close();

		for (int j = 0; j < m; j++) {
			// System.out.println(ALGO_94_FindStudent(student1[j]));
			// System.out.println(ALGO_94_FindStudent(student2[j]));
			if (ALGO_94_FindStudent(student2[j]) ^ ALGO_94_FindStudent(student1[j])) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		}

	}

	private static boolean ALGO_94_FindStudent(String str) {
		// System.out.println("FindStudent: " + str );
		for (int i = 0; i < ALGO_94_n; i++) {
			if ((ALGO_94_students[i].name).equals(str) || (ALGO_94_students[i]).num.equals(str)) {

				return ALGO_94_students[i].sex;
			}
		}
		return false;
	}

	// /*
	// * 算法训练 反置数
	// *
	// * 问题描述
	// * 一个整数的“反置数”指的是把该整数的每一位数字的顺序颠倒过来所得到的另一个整数。
	// * 如果一个整数的末尾是以0结尾，那么在它的反置数当中，这些0就被省略掉了。比如说，
	// * 1245的反置数是5421，而1200的反置数是21。请编写一个程序，输入两个整数，然后
	// * 计算这两个整数的反置数之和sum，然后再把sum的反置数打印出来。要求：由于在本题
	// * 中需要多次去计算一个整数的反置数，因此必须把这部分代码抽象为一个函数的形式。
	// * 输入格式：
	// * 输入只有一行，包括两个整数，中间用空格隔开。
	// * 输出格式：
	// * 输出只有一行，即相应的结果。
	// *
	// * 输入输出样例
	// * 样例输入
	// * 435 754
	// * 样例输出
	// * 199
	// */
	@SuppressWarnings("unused")
	private static void ALGO_93() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		a = ALGO_93_Fan(a);
		int b = sc.nextInt();
		b = ALGO_93_Fan(b);
		sc.close();
		System.out.println(ALGO_93_Fan(a + b));

	}

	private static int ALGO_93_Fan(int num) {
		String temp = num + "";
		String str = "";
		for (int i = temp.length() - 1; i >= 0; i--) {
			str = str + temp.charAt(i);
		}
		return Integer.parseInt(str);
	}

	// /*
	// * 算法训练 前缀表达式
	// *
	// * 问题描述
	// * 编写一个程序，以字符串方式输入一个前缀表达式，然后计算它的值。
	// * 输入格式为：“运算符 对象1 对象2”，其中，运算符为“+”（加法）、
	// * “-”（减法）、“*”（乘法）或“/”（除法），运算对象为不超过10的整
	// * 数，它们之间用一个空格隔开。要求：对于加、减、乘、除这四种运算，
	// * 分别设计相应的函数来实现。
	// * 输入格式：
	// * 输入只有一行，即一个前缀表达式字符串。
	// * 输出格式：
	// * 输出相应的计算结果（如果是除法，直接采用c语言的“/”运算符，结果为整数）。
	// *
	// * 输入输出样例
	// * 样例输入
	// * + 5 2
	// * 样例输出
	// * 7
	// */
	@SuppressWarnings("unused")
	private static void ALGO_92() {
		Scanner sc = new Scanner(System.in);
		String cha = sc.next();
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();

		if (cha.equals("+")) {
			System.out.println(m + n);
		} else if (cha.equals("-")) {
			System.out.println(n - m);
		} else if (cha.equals("*")) {
			System.out.println(m * n);
		} else if (cha.equals("/")) {
			System.out.println(n / m);
		}
	}

	/// *
	// * 算法训练 Anagrams问题
	// *
	// * 问题描述
	// * Anagrams指的是具有如下特性的两个单词：在这两个单词当中，每一个英
	// * 文字母（不区分大小写）所出现的次数都是相同的。例如，“Unclear”和“Nuclear”、
	// * “Rimon”和“MinOR”都是Anagrams。编写一个程序，输入两个单词，然后判断一下，这
	// * 两个单词是否是Anagrams。每一个单词的长度不会超过80个字符，而且是大小写无关的。
	// * 输入格式：
	// * 输入有两行，分别为两个单词。
	// * 输出格式：
	// * 输出只有一个字母Y或N，分别表示Yes和No。
	// *
	// * 输入输出样例
	// * 样例输入
	// * Unclear
	// * Nuclear
	// * 样例输出
	// * Y
	// */
	@SuppressWarnings("unused")
	private static void ALGO_91() {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str2 = sc.next();
		sc.close();
		if (ALGO_91_GetASCII(str) == ALGO_91_GetASCII(str2)) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
	}

	private static int ALGO_91_GetASCII(String str) {
		int sum = 0;
		char arrayChar[] = str.toCharArray();
		for (int i = 0; i < arrayChar.length; i++) {
			if (arrayChar[i] < 96) {
				sum += arrayChar[i] + 32;
			} else {
				sum += arrayChar[i];
			}
		}
		return sum;
	}

	// /*
	// * 算法训练 出现次数最多的整数
	// * 问题描述
	// * 编写一个程序，读入一组整数，这组整数是按照从小到大的顺序排列的，它们的个数N也
	// * 是由用户输入的，最多不会超过20。然后程序将对这个数组进行统计，把出现次数最多
	// * 的那个数组元素值打印出来。如果有两个元素值出现的次数相同，即并列第一，那么只打
	// * 印比较小的那个值
	// * 输入格式：
	// * 第一行是一个整数N，N £ 20；接下来有N行，每一行表示一个整数，并且按照从小到大的顺序排列。
	// * 输出格式：
	// * 输出只有一行，即出现次数最多的那个元素值。
	// *
	// * 输入输出样例
	// * 样例输入
	// * 5
	// * 100
	// * 150
	// * 150
	// * 200
	// * 250
	// * 样例输出
	// * 150
	// */
	@SuppressWarnings({ "resource", "unused" })
	private static void ALGO_90() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N < 1) {
			return;
		}
		int a[] = new int[N];

		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		int max = 0;
		int maxTimeNum = 0;
		int tempmax = 0;
		int temp = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != temp) {
				temp = a[i];
				tempmax = 1;
			} else {
				tempmax++;
			}
			if (tempmax > max) {
				max = tempmax;
				maxTimeNum = a[i];
			}
		}
		System.out.println(maxTimeNum);

	}

	// /*
	// * 算法训练 字符删除
	// *
	// * 问题描述
	// * 编写一个程序，先输入一个字符串str（长度不超过20），再输入单独的一个字
	// * 符ch，然后程序会把字符串str当中出现的所有的ch字符都删掉，从而得到一个
	// * 新的字符串str2，然后把这个字符串打印出来。
	// * 输入格式：
	// * 输入有两行，第一行是一个字符串（内部没有空格），第二行是一个字符。
	// * 输出格式：
	// * 经过处理以后的字符串。
	// *
	// * 样例输入
	// * 123-45-678
	// * -
	// * 样例输出
	// * 12345678
	// */
	@SuppressWarnings({ "resource", "unused" })
	private static void ALGO_89() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if (str.equals("")) {
			return;
		}
		String chr = sc.next();
		sc.close();
		char charArray[] = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (chr.charAt(0) == charArray[i]) {
				continue;
			} else {
				System.out.print(charArray[i]);
			}
		}
	}

	// /*
	// * 算法训练 字串统计
	// *
	// * 问题描述
	// * 给定一个长度为n的字符串S，还有一个数字L，统计长度大于等于L的出现次数最多的子
	// * 串（不同的出现可以相交），如果有多个，输出最长的，如果仍然有多个，输出第一次出
	// * 现最早的。
	// * 输入格式
	// * 第一行一个数字L。
	// * 第二行是字符串S。
	// * L大于0，且不超过S的长度。
	// * 输出格式
	// * 一行，题目要求的字符串。
	// *
	// * 输入样例1：
	// * 4
	// * bbaabbaaaaa
	// * 输出样例1：
	// * bbaa
	// * 输入样例2：
	// * 2
	// * bbaabbaaaaa
	// * 输出样例2：
	// * aa
	// *
	// * 数据规模和约定
	// * n<=60
	// * S中所有字符都是小写英文字母。
	// * 提示
	// * 枚举所有可能的子串，统计出现次数，找出符合条件的那个
	// */
	private static class ALGO_88_str {
		String str;
		int num;
	}

	@SuppressWarnings("unused")
	private static void ALGO_88() {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String S = sc.next();
		sc.close();

		int n = S.length() - L;
		String str[] = new String[n + 1];
		java.util.List<ALGO_88_str> list = new java.util.ArrayList<ALGO_88_str>();
		for (int i = 0; i <= n; i++) {
			boolean flag = false;
			str[i] = S.substring(i, i + L);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).str.equals(str[i])) {
					list.get(j).num++;
					flag = true;
					break;
				}
			}
			if (!flag) {
				ALGO_88_str a88str = new ALGO_88_str();
				a88str.str = str[i];
				a88str.num = 1;
				list.add(a88str);
			}
			// System.out.println(str[i]);
		}
		int max = 0;
		String maxStr = "";

		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).num + " " + list.get(i).str);
			if (list.get(i).num > max) {
				max = list.get(i).num;
				maxStr = list.get(i).str;
			}
		}
		System.out.println(maxStr);
	}

	// /*
	// * 算法训练 字串统计
	// *
	// * 问题描述
	// * 给定一个长度为n的字符串S，还有一个数字L，统计长度大于等于L的出现次数最多的子
	// * 串（不同的出现可以相交），如果有多个，输出最长的，如果仍然有多个，输出第一次出
	// * 现最早的。
	// * 输入格式
	// * 第一行一个数字L。
	// * 第二行是字符串S。
	// * L大于0，且不超过S的长度。
	// * 输出格式
	// * 一行，题目要求的字符串。
	// *
	// * 输入样例1：
	// * 4
	// * bbaabbaaaaa
	// * 输出样例1：
	// * bbaa
	// * 输入样例2：
	// * 2
	// * bbaabbaaaaa
	// * 输出样例2：
	// * aa
	// *
	// * 数据规模和约定
	// * n<=60
	// * S中所有字符都是小写英文字母。
	// * 提示
	// * 枚举所有可能的子串，统计出现次数，找出符合条件的那个
	// */
	private static class ALGO_87_str {
		String str;
		int num;
	}

	@SuppressWarnings("unused")
	private static void ALGO_87() {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String S = sc.next();
		sc.close();

		int n = S.length() - L;
		String str[] = new String[n + 1];
		java.util.List<ALGO_87_str> list = new java.util.ArrayList<ALGO_87_str>();
		for (int i = 0; i <= n; i++) {
			boolean flag = false;
			str[i] = S.substring(i, i + L);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).str.equals(str[i])) {
					list.get(j).num++;
					flag = true;
					break;
				}
			}
			if (!flag) {
				ALGO_87_str a87str = new ALGO_87_str();
				a87str.str = str[i];
				a87str.num = 1;
				list.add(a87str);
			}
			// System.out.println(str[i]);
		}
		int max = 0;
		String maxStr = "";

		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).num + " " + list.get(i).str);
			if (list.get(i).num > max) {
				max = list.get(i).num;
				maxStr = list.get(i).str;
			}
		}
		System.out.println(maxStr);
	}

	// /*
	// * 算法训练 矩阵乘法
	// *
	// * 问题描述
	// * 输入两个矩阵，分别是m*s，s*n大小。输出两个矩阵相乘的结果。
	// * 输入格式
	// * 第一行，空格隔开的三个正整数m,s,n（均不超过200）。
	// * 接下来m行，每行s个空格隔开的整数，表示矩阵A（i，j）。
	// * 接下来s行，每行n个空格隔开的整数，表示矩阵B（i，j）。
	// * 输出格式
	// * m行，每行n个空格隔开的整数，输出相乘後的矩阵C（i，j）的值。
	// *
	// * 样例输入
	// * 2 3 2
	// * 1 0 -1
	// * 1 1 -3
	// * 0 3
	// * 1 2
	// * 3 1
	// * 样例输出
	// * -3 2
	// * -8 2
	// *
	// * 提示
	// * 矩阵C应该是m行n列，其中C(i,j)等于矩阵A第i行行向量与矩阵B第j列列向量的内积。
	// * 例如样例中C(1,1)=(1,0,-1)*(0,1,3) = 1 * 0 +0*1+(-1)*3=-3
	// */
	// 超时，java太慢
	@SuppressWarnings("unused")
	private static void ALGO_86() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int s = sc.nextInt();
		int n = sc.nextInt();
		int A[][] = new int[m][s];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		int B[][] = new int[s][n];
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[i].length; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		sc.close();

		int C[][] = new int[m][n];

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[i].length; j++) {
				C[i][j] = 0;
				for (int j2 = 0; j2 < s; j2++) {
					C[i][j] += A[i][j2] * B[j2][j];
				}
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}

	}

	// /*
	// * 算法训练 进制转换
	// *
	// * 问题描述
	// * 编写一个程序，输入一个二进制的字符串（长度不超过32），然后计算出相应的十进制整数，并把它打印出来。
	// * 输入格式：
	// * 输入为一个字符串，每个字符都是’0’或’1’，字符串的长度不超过32。
	// * 输出格式：
	// * 输出一个整数。
	// *
	// * 输入输出样例
	// * 样例输入
	// * 1101
	// * 样例输出
	// * 13
	// */
	@SuppressWarnings("unused")
	private static void ALGO_85() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(str.length() - i - 1) == '1') {
				sum = (int) (sum + Math.pow(2, i));
			}
		}
		System.out.println(sum);
	}

	// /*
	// * 算法训练 大小写转换
	// *
	// * 问题描述
	// * 编写一个程序，输入一个字符串（长度不超过20），然后把这个字符串内的每一个字符进行大小写变换，即将大写字母变
	// * 成小写，小写字母变成大写，然后把这个新的字符串输出。
	// * 输入格式：
	// * 输入一个字符串，而且这个字符串当中只包含英文字母，不包含其他类型的字符，也没有空格。
	// * 输出格式：
	// * 输出经过转换后的字符串。
	// *
	// * 输入输出样例
	// * 样例输入
	// * AeDb
	// * 样例输出
	// * aEdB
	// */
	@SuppressWarnings("unused")
	private static void ALGO_84() {
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		sc.close();
		char arrayChar[] = string.toCharArray();

		for (int i = 0; i < arrayChar.length; i++) {
			if (arrayChar[i] > 96) {
				System.out.print((char) (arrayChar[i] - 32));
			} else {
				System.out.print((char) (arrayChar[i] + 32));
			}
		}
		System.out.println();
	}

	// /*
	// * 算法训练 阶乘
	// *
	// * 问题描述
	// * 一个整数n的阶乘可以写成n!，它表示从1到n这n个整数的乘积。阶乘的增长速度非常快，
	// * 例如，13!就已经比较大了，已经无法存放在一个整型变量中；而35!就更大了，它已经无
	// * 法存放在一个浮点型变量中。因此，当n比较大时，去计算n!是非常困难的。幸运的是，在
	// * 本题中，我们的任务不是去计算n!，而是去计算n!最右边的那个非0的数字是多少。例如，
	// * 5! = 1*2*3*4*5 = 120，因此5!最右边的那个非0的数字是2。再如：7! = 5040，因
	// * 此7!最右边的那个非0的数字是4。请编写一个程序，输入一个整数n(n<=100)，然后输出n!
	// * 最右边的那个非0的数字是多少。
	// * 输入格式：
	// * 输入只有一个整数n。
	// * 输出格式：
	// * 输出只有一个整数，即n! 最右边的那个非0的数字。
	// *
	// * 输入输出样例
	// * 样例输入
	// * 6
	// * 样例输出
	// * 2
	// */
	@SuppressWarnings("unused")
	private static void ALGO_83() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int lastNum = 1;

		for (int i = 1; i <= n; i++) {
			String str = String.valueOf(lastNum * i);

			for (int j = str.length() - 1; j >= 0; j--) {
				if (str.charAt(j) == '0') {
					continue;
				} else {
					// System.out.println("j: " + j);
					if (j == 0) {
						// 保留1位
						lastNum = Integer.parseInt(String.valueOf(str.charAt(j)));
					} else if (j == 1) {
						// System.out.println("str: " + str.substring(j - 1, j +
						// 1));
						// 保留2位
						lastNum = Integer.parseInt(str.substring(j - 1, j + 1));
					} else {
						// System.out.println("str: " + str.substring(j - 2, j +
						// 1));
						// 保留3位
						lastNum = Integer.parseInt(str.substring(j - 2, j + 1));
					}
					break;
				}
			}

		}

		System.out.println(String.valueOf(lastNum).charAt(String.valueOf(lastNum).length() - 1));

		// 方法二
		// java.math.BigInteger bigInt = java.math.BigInteger.valueOf(1);
		// for (int i = 1; i <= n; i++) {
		// bigInt = bigInt.multiply(BigInteger.valueOf(i));
		// }
		// System.out.println(bigInt);
		// String str = bigInt.toString();
		// for (int i = str.length() - 1; i >= 0; i--) {
		// if (str.charAt(i) != '0') {
		// System.out.println(str.charAt(i));
		// break;
		// }
		// }

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
	// * 算法训练 操作格子
	// *
	// * 问题描述
	// * 有n个格子，从左到右放成一排，编号为1-n。
	// * 共有m次操作，有3种操作类型：
	// * 1.修改一个格子的权值，
	// * 2.求连续一段格子权值和，
	// * 3.求连续一段格子的最大值。
	// * 对于每个2、3操作输出你所求出的结果。
	// *
	// * 输入格式
	// * 第一行2个整数n，m。
	// * 接下来一行n个整数表示n个格子的初始权值。
	// * 接下来m行，每行3个整数p,x,y，p表示操作类型，p=1时表示修改格子x的权值为y，p=2时表示求区间[x,y]内格子权
	// * 值和，p=3时表示求区间[x,y]内格子最大的权值。
	// * 输出格式
	// * 有若干行，行数等于p=2或3的操作总数。
	// * 每行1个整数，对应了每个p=2或3操作的结果。
	// *
	// * 样例输入
	// * 4 3
	// * 1 2 3 4
	// * 2 1 3
	// * 1 4 3
	// * 3 1 4
	// * 样例输出
	// * 6
	// * 3
	// *
	// * 数据规模与约定
	// * 对于20%的数据n <= 100，m <= 200。
	// * 对于50%的数据n <= 5000，m <= 5000。
	// * 对于100%的数据1 <= n <= 100000，m <= 100000，0 <= 格子权值 <= 10000。
	// */
	// 超时因为java太慢，相同逻辑c++可以满分通过
	private static class ALGO_8_Node {
		// 左
		int l;
		// 右
		int r;
		// 当前的值
		int n;
		// 子树总和
		int sum;
	}

	private static ALGO_8_Node ALGO_8_node[] = new ALGO_8_Node[1000000];

	@SuppressWarnings("unused")
	private static void ALGO_8() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int na[] = new int[n];
		for (int i = 0; i < na.length; i++) {
			na[i] = sc.nextInt();
		}
		int line[][] = new int[m][3];

		for (int i = 0; i < line.length; i++) {
			for (int j = 0; j < line[i].length; j++) {
				line[i][j] = sc.nextInt();
			}
		}
		sc.close();

		ALGO_8_Init(1, n, 1);

		for (int i = 1; i <= na.length; i++) {
			ALGO_8_Insert(1, i, na[i - 1]);
		}

		for (int i = 0; i < line.length; i++) {
			switch (line[i][0]) {
			case 1:
				ALGO_8_Insert(1, line[i][1], line[i][2]);
				break;
			case 2:
				System.out.println(ALGO_8_FindSum(line[i][1], line[i][2], 1));
				break;
			case 3:
				System.out.println(ALGO_8_FindMax(line[i][1], line[i][2], 1));
				break;

			}
		}

	}

	// 初始化线段树，还没插入值
	private static void ALGO_8_Init(int l, int r, int i) {
		ALGO_8_node[i] = new ALGO_8_Node();
		ALGO_8_node[i].l = l;
		ALGO_8_node[i].r = r;
		ALGO_8_node[i].n = 0;
		ALGO_8_node[i].sum = 0;

		if (l != r) {
			int mid = (l + r) / 2;
			ALGO_8_Init(l, mid, 2 * i);
			ALGO_8_Init(mid + 1, r, 2 * i + 1);
		}
	}

	// 线段树插入值
	private static void ALGO_8_Insert(int i, int x, int m) {
		if (x >= ALGO_8_node[i].l && x <= ALGO_8_node[i].r) {
			ALGO_8_node[i].n = m;
			ALGO_8_node[i].sum = m;
		}
		if (ALGO_8_node[i].l == ALGO_8_node[i].r)
			return;
		int mid = (ALGO_8_node[i].l + ALGO_8_node[i].r) / 2;
		if (x > mid)
			ALGO_8_Insert(2 * i + 1, x, m);
		else
			ALGO_8_Insert(2 * i, x, m);
		ALGO_8_node[i].sum = ALGO_8_node[2 * i].sum + ALGO_8_node[2 * i + 1].sum;

		ALGO_8_node[i].n = ALGO_8_node[2 * i].n > ALGO_8_node[2 * i + 1].n ? ALGO_8_node[2 * i].n
				: ALGO_8_node[2 * i + 1].n;

	}

	private static int ALGO_8_FindMax(int x, int y, int i) {
		if (x == ALGO_8_node[i].l && y == ALGO_8_node[i].r)
			return ALGO_8_node[i].n;
		int mid = (ALGO_8_node[i].l + ALGO_8_node[i].r) / 2;
		if (x > mid)
			return ALGO_8_FindMax(x, y, 2 * i + 1);
		else if (y <= mid)
			return ALGO_8_FindMax(x, y, 2 * i);
		else
			return (ALGO_8_FindMax(x, mid, 2 * i) > ALGO_8_FindMax(mid + 1, y, 2 * i + 1)
					? ALGO_8_FindMax(x, mid, 2 * i) : ALGO_8_FindMax(mid + 1, y, 2 * i + 1));
	}

	private static int ALGO_8_FindSum(int x, int y, int i) {
		if (ALGO_8_node[i].l == x && ALGO_8_node[i].r == y)
			return ALGO_8_node[i].sum;
		int mid = (ALGO_8_node[i].l + ALGO_8_node[i].r) / 2;
		if (x > mid)
			return ALGO_8_FindSum(x, y, 2 * i + 1);
		else if (y <= mid)
			return ALGO_8_FindSum(x, y, 2 * i);
		else
			return ALGO_8_FindSum(x, mid, 2 * i) + ALGO_8_FindSum(mid + 1, y, 2 * i + 1);
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
