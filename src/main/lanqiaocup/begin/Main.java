package main.lanqiaocup.begin;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		BEGIN_4();
		// BEGIN_3();
		// BEGIN_2();
		// BEGIN_1();
	}

	// /*
	// * 入门训练 Fibonacci数列
	// *
	// * 问题描述
	// * Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
	// * 当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
	// * 输入格式
	// * 输入包含一个整数n。
	// * 输出格式
	// * 输出一行，包含一个整数，表示Fn除以10007的余数。
	// *
	// * 样例输入
	// * 10
	// * 样例输出
	// * 55
	// * 样例输入
	// * 22
	// * 样例输出
	// * 7704
	// *
	// * 数据规模与约定
	// * 1 <= n <= 1,000,000。
	// * */
	public static void BEGIN_4() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[] F = new int[n];
		if (n == 1 || n == 2) {
			System.out.println(1);
		} else {
			F[0] = 1;
			F[1] = 1;
			for (int i = 2; i < F.length; i++) {
				F[i] = F[i - 1] + F[i - 2];
				F[i] = F[i] % 10007;
			}
			System.out.println(F[n - 1] % 10007);
		}

		// 输入为1时不成立
		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// sc.close();
		// int[] F = new int[n];
		// F[0] = 1;
		// F[1] = 1;
		// for (int i = 2; i < F.length; i++) {
		// F[i] = F[i - 1] + F[i - 2];
		// F[i] = F[i] % 10007;
		// }
		// System.out.println(F[n - 1] % 10007);

	}

	// /*
	// * 入门训练 圆的面积
	// *
	// * 问题描述
	// * 给定圆的半径r，求圆的面积。
	// * 输入格式
	// * 输入包含一个整数r，表示圆的半径。
	// * 输出格式
	// * 输出一行，包含一个实数，四舍五入保留小数点后7位，表示圆的面积。
	// *
	// * 样例输入
	// * 4
	// * 样例输出
	// * 50.2654825
	// *
	// * 数据规模与约定
	// * 1 <= r <= 10000。
	// *
	// * 提示
	// * 本题对精度要求较高，请注意π的值应该取较精确的值。你可以使用常量来表示π，比如PI=3.14159265358979323，
	// * 也可以使用数学公式来求π，比如PI=atan(1.0)*4。
	// * */
	private static void BEGIN_3() {
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		sc.close();
		double PI = 3.14159265358979323d;
		double area = PI * r * r;
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.0000000"); // 保留7为小数,四舍五入
		System.out.println(df.format(area));

		// 使用BigDecimal会将小数最后一个0去掉了
		// Scanner sc = new Scanner(System.in);
		// double r = sc.nextDouble();
		// sc.close();
		// double PI = 3.14159265358979323d;
		// double area = PI * r * r;
		// area = (double) (Math.round(area * 10000000)) / 10000000;
		// BigDecimal bdarea = BigDecimal.valueOf(area);
		// System.out.println(bdarea);
	}

	// /*
	// * 入门训练 序列求和
	// *
	// * 问题描述
	// * 求1+2+3+...+n的值。
	// * 输入格式
	// * 输入包括一个整数n。
	// * 输出格式
	// * 输出一行，包括一个整数，表示1+2+3+...+n的值。
	// *
	// * 样例输入
	// * 4
	// * 样例输出
	// * 10
	// * 样例输入
	// * 100
	// * 样例输出
	// * 5050
	// *
	// * 数据规模与约定
	// * 1 <= n <= 1,000,000,000。
	// * */
	private static void BEGIN_2() {
		Scanner sc = new Scanner(System.in);
		Long n = sc.nextLong();
		sc.close();
		Long sum = (n + 1) * n / 2;
		System.out.println(sum);

		// 运行超时1
		// Scanner sc = new Scanner(System.in);
		// BigInteger n = sc.nextBigInteger();
		// sc.close();
		// BigInteger temp = BigInteger.valueOf(0);
		// for (BigInteger i = BigInteger.valueOf(0);
		// !i.equals(n.add(BigInteger.valueOf(1)));
		// i=i.add(BigInteger.valueOf(1))) {
		// temp = temp.add(i);
		//
		// }
		// System.out.println(temp);

		// 运行超时2
		// Scanner sc = new Scanner(System.in);
		// Long n = sc.nextLong();
		// sc.close();
		// Long temp = 0l;
		// for (Long i = 0l; i < n + 1; i++) {
		// temp = temp + i;
		// }
		// System.out.println(temp);
	}

	// /*
	// * 入门训练 A+B问题
	// *
	// * 问题描述
	// * 输入A、B，输出A+B。
	// * 输入格式
	// * 输入的第一行包括两个整数，由空格分隔，分别表示A、B。
	// * 输出格式
	// * 输出一行，包括一个整数，表示A+B的值。
	// *
	// * 样例输入
	// * 2
	// * 样例输出
	// * 7
	// *
	// * 数据规模与约定
	// * -10000 <= A, B <= 10000。
	// * */
	private static void BEGIN_1() {
		Scanner sc = new Scanner(System.in);
		Integer a = sc.nextInt();
		Integer b = sc.nextInt();
		System.out.println(a + b);
		sc.close();
	}
}

