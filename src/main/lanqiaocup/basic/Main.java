package main.lanqiaocup.basic;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("sjhdak");
		// BASIC_30();
		// BASIC_29();
		// BASIC_28();
		// BASIC_27();
		// BASIC_26();
		// BASIC_25();
		// BASIC_24();
		// BASIC_23();
		// BASIC_22();
		// BASIC_21();
		// BASIC_20();
		// BASIC_19();
		// BASIC_18();
		// BASIC_17();
		// BASIC_16();
		// BASIC_15();
		// BASIC_14();
		// BASIC_13();
		// BASIC_12();
		// BASIC_11();
		// BASIC_10();
		// BASIC_9();
		// BASIC_8();
		// BASIC_7();
		// BASIC_6();
		// BASIC_5();
		// BASIC_4();
		// BASIC_3();
		// BASIC_2();
		// BASIC_1();
	}

	// /*
	// * 基础练习 阶乘计算
	// *
	// * 问题描述
	// * 输入一个正整数n，输出n!的值。
	// * 其中n!=1*2*3*…*n。
	// * 算法描述
	// * n!可能很大，而计算机能表示的整数范围有限，需要使用高精度计算的方法。使用一个数组A来表示一个大整
	// * 数a，A[0]表示a的个位，A[1]表示a的十位，依次类推。
	// * 将a乘以一个整数k变为将数组A的每一个元素都乘以k，请注意处理相应的进位。
	// * 首先将a设为1，然后乘2，乘3，当乘到n时，即得到了n!的值。
	// * 输入格式
	// * 输入包含一个正整数n，n<=1000。
	// * 输出格式
	// * 输出n!的准确值。
	// *
	// * 样例输入
	// * 10
	// * 样例输出
	// * 3628800
	// * */
	private static void BASIC_30() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		if (n == 1) {
			System.out.println(1);
			return;
		}

		String sum = "1";
		for (int i = 1; i < n; i++) {
			sum = BASIC_30_multiplication((i + 1) + "", sum);
		}
		System.out.println(sum);
	}

	private static String BASIC_30_multiplication(String aString, String bString) {
		String result = "0";

		// System.out.println("aString:"+aString+" bString:"+bString);

		char aChar[] = aString.toCharArray();
		char bChar[] = bString.toCharArray();

		for (int i = 0; i < aChar.length; i++) {
			for (int j = 0; j < bChar.length; j++) {
				// int temp = (bChar[bChar.length - j - 1] -
				// 48)*(aChar[aChar.length - i - 1] -
				// 48)*(BASIC_30_mi(10,i))*(BASIC_30_mi(10,j));
				// result = BASIC_30_add(temp+"",result);
				String temp = (bChar[bChar.length - j - 1] - 48) * (aChar[aChar.length - i - 1] - 48) + "";
				for (int k = 0; k < i + j; k++) {
					temp = temp + "0";
				}
				result = BASIC_30_add(temp, result);

			}
		}
		// System.out.println("BASIC_30_multiplication:"+result);
		return result;
	}

	private static int BASIC_30_mi(int num, int n) {
		int sum = 1;
		for (int i = 0; i < n; i++) {
			sum *= num;
		}
		return sum;
	}

	private static String BASIC_30_add(String aString, String bString) {
		String result = "";

		char aChar[] = aString.toCharArray();
		char bChar[] = bString.toCharArray();

		int longer = aChar.length > bChar.length ? aChar.length : bChar.length;

		int a[] = new int[longer];
		int b[] = new int[longer];

		for (int i = 0; i < aChar.length; i++) {
			a[i] = aChar[aChar.length - i - 1] - 48;
		}
		for (int i = 0; i < bChar.length; i++) {
			b[i] = bChar[bChar.length - i - 1] - 48;
		}

		int[] sum = new int[longer + 1];
		for (int i = 0; i < longer; i++) {
			if (i < a.length && i < b.length) {
				if (a[i] + b[i] + sum[i] < 10) {
					sum[i] = a[i] + b[i] + sum[i];
				} else {
					sum[i] = a[i] + b[i] + sum[i] - 10;
					sum[i + 1] = 1;
				}
			}
		}

		for (int i = sum.length - 1; i >= 0; i--) {
			if (i == sum.length - 1 && sum[i] == 0) {
				continue;
			}
			result = result + sum[i];
		}
		// System.out.println("BASIC_30_add_result:"+result);

		return result;
	}

	// /*
	// * 基础练习 高精度加法
	// *
	// * 问题描述
	// * 输入两个整数a和b，输出这两个整数的和。a和b都不超过100位。
	// * 算法描述
	// * 由于a和b都比较大，所以不能直接使用语言中的标准数据类型来存储。对于这种问题，一般使用数组来处理。
	// * 定义一个数组A，A[0]用于存储a的个位，A[1]用于存储a的十位，依此类推。同样可以用一个数组B来存储b。
	// * 计算c = a + b的时候，首先将A[0]与B[0]相加，如果有进位产生，则把进位（即和的十位数）存入r，把和的个位数存入C[0]，
	// *
	// 即C[0]等于(A[0]+B[0])%10。然后计算A[1]与B[1]相加，这时还应将低位进上来的值r也加起来，即C[1]应该是A[1]、B[1]和r三个
	// * 数的和．如果又有进位产生，则仍可将新的进位存入到r中，和的个位存到C[1]中。依此类推，即可求出C的所有位。
	// * 最后将C输出即可。
	// * 输入格式
	// * 输入包括两行，第一行为一个非负整数a，第二行为一个非负整数b。两个整数都不超过100位，两数的最高位都不是0。
	// * 输出格式
	// * 输出一行，表示a + b的值。
	// *
	// * 样例输入
	// * 20100122201001221234567890
	// * 2010012220100122
	// * 样例输出
	// * 20100122203011233454668012
	// * */
	private static void BASIC_29() {
		Scanner sc = new Scanner(System.in);
		String aString = sc.next();
		String bString = sc.next();
		sc.close();

		char aChar[] = aString.toCharArray();
		char bChar[] = bString.toCharArray();

		int longer = aChar.length > bChar.length ? aChar.length : bChar.length;

		int a[] = new int[longer];
		int b[] = new int[longer];

		// System.out.println("longer:"+longer);
		// System.out.println("aChar.length:"+aChar.length);
		// System.out.println("bChar.length:"+bChar.length);

		for (int i = 0; i < aChar.length; i++) {
			a[i] = aChar[aChar.length - i - 1] - 48;
		}
		for (int i = 0; i < bChar.length; i++) {
			b[i] = bChar[bChar.length - i - 1] - 48;
		}

		int[] sum = new int[longer + 1];
		for (int i = 0; i < longer; i++) {
			if (i < a.length && i < b.length) {
				if (a[i] + b[i] + sum[i] < 10) {
					sum[i] = a[i] + b[i] + sum[i];
				} else {
					sum[i] = a[i] + b[i] + sum[i] - 10;
					sum[i + 1] = 1;
				}
			}
		}

		for (int i = sum.length - 1; i >= 0; i--) {
			if (i == sum.length - 1 && sum[i] == 0) {
				continue;
			}
			System.out.print(sum[i]);
		}
	}

	// /*
	// * 基础练习 Huffuman树
	// *
	// * 问题描述
	// * Huffman树在编码中有着广泛的应用。在这里，我们只关心Huffman树的构造过程。
	// * 给出一列数{pi}={p0, p1, …, pn-1}，用这列数构造Huffman树的过程如下：
	// * 1. 找到{pi}中最小的两个数，设为pa和pb，将pa和pb从{pi}中删除掉，然后将它们的和加入到{pi}中。这个过程的费用记为pa +
	// * pb。
	// * 2. 重复步骤1，直到{pi}中只剩下一个数。
	// * 在上面的操作过程中，把所有的费用相加，就得到了构造Huffman树的总费用。
	// * 本题任务：对于给定的一个数列，现在请你求出用该数列构造Huffman树的总费用。
	// * 例如，对于数列{pi}={5, 3, 8, 2, 9}，Huffman树的构造过程如下：
	// * 1. 找到{5, 3, 8, 2, 9}中最小的两个数，分别是2和3，从{pi}中删除它们并将和5加入，得到{5, 8, 9,
	// * 5}，费用为5。
	// * 2. 找到{5, 8, 9, 5}中最小的两个数，分别是5和5，从{pi}中删除它们并将和10加入，得到{8, 9, 10}，费用为10。
	// * 3. 找到{8, 9, 10}中最小的两个数，分别是8和9，从{pi}中删除它们并将和17加入，得到{10, 17}，费用为17。
	// * 4. 找到{10, 17}中最小的两个数，分别是10和17，从{pi}中删除它们并将和27加入，得到{27}，费用为27。
	// * 5. 现在，数列中只剩下一个数27，构造过程结束，总费用为5+10+17+27=59。
	// * 输入格式
	// * 输入的第一行包含一个正整数n（n<=100）。
	// * 接下来是n个正整数，表示p0, p1, …, pn-1，每个数不超过1000。
	// * 输出格式
	// * 输出用这些数构造Huffman树的总费用。
	// *
	// * 样例输入
	// * 5
	// * 5 3 8 2 9
	// * 样例输出
	// * 59
	// * */
	private static void BASIC_28() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		java.util.List<Integer> aList = new java.util.ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			aList.add(a[i]);
		}

		int small[] = new int[2];
		int smallLoacl[] = new int[2];
		int sum = 0;
		while (aList.size() > 1) {
			for (int i = 0; i < aList.size(); i++) {
				if (i < 2) {
					small[i] = aList.get(i);
					smallLoacl[i] = i;
				} else {
					int temp = small[0] < small[1] ? 1 : 0;
					if (aList.get(i) < small[temp]) {
						small[temp] = aList.get(i);
						smallLoacl[temp] = i;
						continue;
					}
				}
			}

			java.util.List<Integer> tempList = new java.util.ArrayList<Integer>();
			tempList.addAll(aList);

			aList.clear();
			for (int i = 0; i < tempList.size(); i++) {
				if (i == smallLoacl[1] || i == smallLoacl[0]) {
					continue;
				} else {
					aList.add(tempList.get(i));
				}
			}

			aList.add((small[0] + small[1]));

			// for (int i = 0; i < aList.size(); i++) {
			// System.out.print(aList.get(i) + " ");
			// }
			// System.out.println();

			sum = sum + aList.get(aList.size() - 1);
		}
		System.out.println(sum);
	}

	// /*
	// * 基础练习 2n皇后问题
	// *
	// * 问题描述
	// * 给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，使任意的两个黑皇后都不在同
	// * 一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
	// * 输入格式
	// * 输入的第一行为一个整数n，表示棋盘的大小。
	// * 接下来n行，每行n个0或1的整数，如果一个整数为1，表示对应的位置可以放皇后，如果一个整数为0，表示对应的位置不可以放
	// * 皇后。
	// * 输出格式
	// * 输出一个整数，表示总共有多少种放法。
	// *
	// * 样例输入
	// * 4
	// * 1 1 1 1
	// * 1 1 1 1
	// * 1 1 1 1
	// * 1 1 1 1
	// * 样例输出
	// * 2
	// * 样例输入
	// * 4
	// * 1 0 1 1
	// * 1 1 1 1
	// * 1 1 1 1
	// * 1 1 1 1
	// * 样例输出
	// * 0
	// * */
	private static void BASIC_27() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();
		BASIC_27_DLS(0, 1, a);
		System.out.println(BASIC_27_sum);
	}

	static int BASIC_27_sum = 0;

	private static void BASIC_27_DLS(int i, int T, int[][] queen) {
		int black = 2, white = 3;

		if (i >= queen.length) {
			if (T != 1) {
				T = 1;
				BASIC_27_sum++;
				return;
			}
			T = 0;
			i = 0;
		}

		if (T == 1) {
			for (int j = 0; j < queen.length; j++)
				if (BASIC_27_judgeQueen(i, j, black, queen) && queen[i][j] == 1) {
					queen[i][j] = black;
					BASIC_27_DLS(i + 1, T, queen);
					queen[i][j] = 1;
				}
		} else {
			for (int j = 0; j < queen.length; j++)
				if (BASIC_27_judgeQueen(i, j, white, queen) && queen[i][j] == 1) {
					queen[i][j] = white;
					BASIC_27_DLS(i + 1, T, queen);
					queen[i][j] = 1;
				}
		}

	}

	private static boolean BASIC_27_judgeQueen(int i, int j, int k, int[][] queen) {

		for (int x = 0; x < queen.length; x++) {
			if (queen[x][j] == k || queen[i][x] == k) {
				return false;
			}
		}

		for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
			if (queen[x][y] == k) {
				return false;
			}
		}

		for (int x = i + 1, y = j + 1; x < queen.length && y < queen.length; x++, y++) {
			if (queen[x][y] == k) {
				return false;
			}
		}

		for (int x = i - 1, y = j + 1; x >= 0 && y < queen.length; x--, y++) {
			if (queen[x][y] == k) {
				return false;
			}
		}

		for (int x = i + 1, y = j - 1; x < queen.length && y >= 0; x++, y--) {
			if (queen[x][y] == k) {
				return false;
			}
		}
		return true;
	}

	private static void BASIC_26() {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		sc.close();

		String string[] = new String[2];

		for (int i = 0; i < 2; i++) {
			int temp = 0;

			switch (i) {
			case 0:
				temp = h;
				break;
			case 1:
				temp = m;
				break;
			}

			switch (temp) {
			case 0:
				if (i == 0) {
					string[i] = "zero";
				} else {
					string[i] = "o'clock";
				}
				break;
			case 1:
				string[i] = "one";
				break;
			case 2:
				string[i] = "two";
				break;
			case 3:
				string[i] = "three";
				break;
			case 4:
				string[i] = "four";
				break;
			case 5:
				string[i] = "five";
				break;
			case 6:
				string[i] = "six";
				break;
			case 7:
				string[i] = "seven";
				break;
			case 8:
				string[i] = "eight";
				break;
			case 9:
				string[i] = "nine";
				break;
			case 10:
				string[i] = "ten";
				break;
			case 11:
				string[i] = "eleven";
				break;
			case 12:
				string[i] = "twelve";
				break;
			case 13:
				string[i] = "thirteen";
				break;
			case 14:
				string[i] = "fourteen";
				break;
			case 15:
				string[i] = "fifteen";
				break;
			case 16:
				string[i] = "sixteen";
				break;
			case 17:
				string[i] = "seventeen";
				break;
			case 18:
				string[i] = "eighteen";
				break;
			case 19:
				string[i] = "nineteen";
				break;
			case 20:
				string[i] = "twenty";
				break;
			default:
				string[i] = BASIC_26_biggerThenTwenty(temp);
				break;
			}

		}
		System.out.println(string[0] + " " + string[1]);
	}

	// /*
	// * 基础练习 报时助手
	// *
	// * 问题描述
	// * 给定当前的时间，请用英文的读法将它读出来。
	// * 时间用时h和分m表示，在英文的读法中，读一个时间的方法是：
	// * 如果m为0，则将时读出来，然后加上“o'clock”，如3:00读作“three o'clock”。
	// * 如果m不为0，则将时读出来，然后将分读出来，如5:30读作“five thirty”。
	// * 时和分的读法使用的是英文数字的读法，其中0~20读作：
	// * 0:zero, 1: one, 2:two, 3:three, 4:four, 5:five, 6:six, 7:seven,
	// 8:eight, 9:nine, 10:ten, 11:eleven,
	// * 12:twelve, 13:thirteen, 14:fourteen, 15:fifteen, 16:sixteen,
	// 17:seventeen, 18:eighteen, 19:nineteen,
	// * 20:twenty。
	// * 30读作thirty，40读作forty，50读作fifty。
	// * 对于大于20小于60的数字，首先读整十的数，然后再加上个位数。如31首先读30再加1的读法，读作“thirty one”。
	// * 按上面的规则21:54读作“twenty one fifty four”，9:07读作“nine seven”，0:15读作“zero
	// fifteen”。
	// * 输入格式
	// * 输入包含两个非负整数h和m，表示时间的时和分。非零的数字前没有前导0。h小于24，m小于60。
	// * 输出格式
	// * 输出时间时刻的英文。
	// *
	// * 样例输入
	// * 0 15
	// * 样例输出
	// * zero fifteen
	// * */
	private static String BASIC_26_biggerThenTwenty(int temp) {
		String string = "";

		int a = -1;
		if (temp - 20 < 10) {
			a = 20;
		} else if (temp - 30 < 10) {
			a = 30;
		} else if (temp - 40 < 10) {
			a = 40;
		} else if (temp - 50 < 10) {
			a = 50;
		}

		switch (a) {
		case 20:
			string = "twenty ";
			break;
		case 30:
			string = "thirty ";
			break;
		case 40:
			string = "forty ";
			break;
		case 50:
			string = "fifty ";
			break;
		}

		switch (temp - a) {
		case 1:
			string = string + "one";
			break;
		case 2:
			string = string + "two";
			break;
		case 3:
			string = string + "three";
			break;
		case 4:
			string = string + "four";
			break;
		case 5:
			string = string + "five";
			break;
		case 6:
			string = string + "six";
			break;
		case 7:
			string = string + "seven";
			break;
		case 8:
			string = string + "eight";
			break;
		case 9:
			string = string + "nine";
			break;
		}

		return string;
	}

	// /*
	// * 基础练习 回形取数
	// *
	// * 问题描述
	// * 回形取数就是沿矩阵的边取数，若当前方向上无数可取或已经取过，则左转90度。一开始位于矩阵左上角，方向向下。
	// * 输入格式
	// * 输入第一行是两个不超过200的正整数m, n，表示矩阵的行和列。接下来m行每行n个整数，表示这个矩阵。
	// * 输出格式
	// * 输出只有一行，共mn个数，为输入矩阵回形取数得到的结果。数之间用一个空格分隔，行末不要有多余的空格。
	// *
	// * 样例输入
	// * 3 3
	// * 1 2 3
	// * 4 5 6
	// * 7 8 9
	// * 样例输出
	// * 1 4 7 8 9 6 3 2 5
	// * 样例输入
	// * 3 2
	// * 1 2
	// * 3 4
	// * 5 6
	// * 样例输出
	// * 1 3 5 6 4 2
	// * */
	private static void BASIC_25() {
		// java代码运行超时
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		int[][] a = new int[m][n];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();

		int tot = 0, x = -1, y = 0;

		while (tot < m * n) {
			while (x + 1 < m && a[x + 1][y] != -1) {
				System.out.print(" " + a[++x][y]);
				a[x][y] = -1;
				++tot;
			}
			while (y + 1 < n && a[x][y + 1] != -1) {
				System.out.print(" " + a[x][++y]);
				a[x][y] = -1;
				++tot;
			}
			while (x - 1 >= 0 && a[x - 1][y] != -1) {
				System.out.print(" " + a[--x][y]);
				a[x][y] = -1;
				++tot;
			}
			while (y - 1 >= 0 && a[x][y - 1] != -1) {
				System.out.print(" " + a[x][--y]);
				a[x][y] = -1;
				++tot;
			}
		}

		// C++相同逻辑代码
		// #include <cstdio>
		// #include <vector>
		// #include <cstring>
		// #include <iostream>
		// using namespace std;
		//
		// int main()
		// {
		// //freopen("input2(1).txt", "r", stdin);
		// int m, n;
		// int i, j, num = 0;
		// int a[205][205];
		// memset(a, -1, sizeof(a));
		// scanf("%d%d", &m, &n);
		// for(i = 0; i < m; i++)
		// for(j = 0; j < n; j++)
		// scanf("%d", &a[i][j]);
		// int tot = 0, x = -1, y = 0;
		// while(tot < m * n)
		// {
		// while(x + 1 < m && a[x + 1][y] != -1)
		// {
		// printf("%d ", a[++x][y]);
		// a[x][y] = -1;
		// ++tot;
		// }
		// while(y + 1 < n && a[x][y + 1] != -1)
		// {
		// printf("%d ", a[x][++y]);
		// a[x][y] = -1;
		// ++tot;
		// }
		// while(x - 1 >= 0 && a[x - 1][y] != -1)
		// {
		// printf("%d ", a[--x][y]);
		// a[x][y] = -1;
		// ++tot;
		// }
		// while(y - 1 >= 0 && a[x][y - 1] != -1)
		// {
		// printf("%d ", a[x][--y]);
		// a[x][y] = -1;
		// ++tot;
		// }
		// }
		// return 0;
		// }

		// 运行超时
		// Scanner sc = new Scanner(System.in);
		// int m = sc.nextInt();
		// int n = sc.nextInt();
		// // String[][] a = new String[m][n];
		// int[][] a = new int[m][n];
		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a[i].length; j++) {
		// // if(i==j && j==0){
		// // a[i][j] = sc.next();
		// // }else{
		// // a[i][j] = " "+sc.next();
		// // }
		// a[i][j] = sc.nextInt();
		// }
		// }
		// sc.close();

		// String result = "";
		//
		// for (int i = 0; i < ((m < n) ? m/2+1 : n/2+1); i++) {
		//
		// for (int j = 0; j < m; j++) {
		// if (a[j][i] == 0) {
		// // if(a[j][i].equals("")){
		// continue;
		// } else {
		// if(i==0 && j==0){
		// result = result + a[j][i];
		// }else{
		// result = result + " " + a[j][i];
		// }
		// // result = result + a[j][i];
		// a[j][i] = 0;
		// // a[j][i] = "";
		// }
		// }
		// for (int j = 0; j < n; j++) {
		// if (a[m - i - 1][j] == 0) {
		// // if(a[m-i-1][j].equals("")){
		// continue;
		// } else {
		// result = result + " " + a[m - i - 1][j];
		// // result = result + a[m - i - 1][j];
		// a[m - i - 1][j] = 0;
		// // a[m-i-1][j] = "";
		// }
		// }
		// for (int j = 0; j < m; j++) {
		// if (a[m - j - 1][n - i - 1] == 0) {
		// // if(a[m-j-1][n-i-1].equals("")){
		// continue;
		// } else {
		// result = result + " " + a[m - j - 1][n - i - 1];
		// // result = result + a[m - j - 1][n - i - 1];
		// a[m - j - 1][n - i - 1] = 0;
		// // a[m-j-1][n-i-1] = "";
		// }
		// }
		// for (int j = 0; j < n; j++) {
		// if (a[i][n - j - 1] == 0) {
		// // if(a[i][n-j-1].equals("")){
		// continue;
		// } else {
		// result = result + " " + a[i][n - j - 1];
		// // result = result + a[i][n - j - 1];
		// a[i][n - j - 1] = 0;
		// // a[i][n-j-1] = "";
		// }
		// }
		// }
		// System.out.println(result);

	}

	// /*
	// * 基础练习 龟兔赛跑预测
	// *
	// * 问题描述
	// * 话说这个世界上有各种各样的兔子和乌龟，但是研究发现，所有的兔子和乌龟都有一个共同的特点——喜欢赛跑。于是世界上各个角
	// * 落都不断在发生着乌龟和兔子的比赛，小华对此很感兴趣，于是决定研究不同兔子和乌龟的赛跑。他发现，兔子虽然跑比乌龟快，但它们
	// * 有众所周知的毛病——骄傲且懒惰，于是在与乌龟的比赛中，一旦任一秒结束后兔子发现自己领先t米或以上，它们就会停下来休息s秒。
	// * 对于不同的兔子，t，s的数值是不同的，但是所有的乌龟却是一致——它们不到终点决不停止。
	// * 然而有些比赛相当漫长，全程观看会耗费大量时间，而小华发现只要在每场比赛开始后记录下兔子和乌龟的数据——兔子的速度
	// * v1（表示每秒兔子能跑v1米），乌龟的速度v2，以及兔子对应的t，s值，以及赛道的长度l——就能预测出比赛的结果。但是小华很懒，
	// * 不想通过手工计算推测出比赛的结果，于是他找到了你——清华大学计算机系的高才生——请求帮助，请你写一个程序，对于输入的一场
	// * 比赛的数据v1，v2，t，s，l，预测该场比赛的结果。
	// * 输入格式
	// *
	// 输入只有一行，包含用空格隔开的五个正整数v1，v2，t，s，l，其中(v1,v2<=100;t<=300;s<=10;l<=10000且为v1,v2的公倍数)
	// * 输出格式
	// * 输出包含两行，第一行输出比赛结果——一个大写字母“T”或“R”或“D”，分别表示乌龟获胜，兔子获胜，或者两者同时到达终
	// * 点。
	// * 第二行输出一个正整数，表示获胜者（或者双方同时）到达终点所耗费的时间（秒数）。
	// *
	// * 样例输入
	// * 10 5 5 2 20
	// * 样例输出
	// * D
	// * 4
	// * 样例输入
	// * 10 5 5 1 20
	// * 样例输出
	// * R
	// * 3
	// * 样例输入
	// * 10 5 5 3 20
	// * 样例输出
	// * T
	// * 4
	// * */
	private static void BASIC_24() {
		Scanner sc = new Scanner(System.in);
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		int t = sc.nextInt();
		int s = sc.nextInt();
		int l = sc.nextInt();
		sc.close();

		int rabit = 0;
		int turtle = 0;
		boolean flag = false;
		int sleeptime = 0;

		for (int i = 0; i < l / v2; i++) {

			if (flag) {
				if (sleeptime > 0) {
					sleeptime--;
				} else {
					rabit = rabit + v1;
					flag = false;
				}
			} else {
				rabit = rabit + v1;
			}

			turtle = turtle + v2;

			if (rabit - turtle >= t && !flag) {
				flag = true;
				sleeptime = s;
			}

			if (rabit == l || turtle == l) {
				if (rabit == turtle) {
					System.out.println("D");
				} else if (rabit > turtle) {
					System.out.println("R");
				} else if (rabit < turtle) {
					System.out.println("T");
				}
				System.out.println(i + 1);
				// System.out.println(turtle +" "+rabit);
				break;
			}
		}
	}

	// /*
	// * 基础练习 芯片测试
	// *
	// * 问题描述
	// * 有n（2≤n≤20）块芯片，有好有坏，已知好芯片比坏芯片多。
	// * 每个芯片都能用来测试其他芯片。用好芯片测试其他芯片时，能正确给出被测试芯片是好还是坏。而用坏芯片测试其他芯片时，会随
	// * 机给出好或是坏的测试结果（即此结果与被测试芯片实际的好坏无关）。
	// * 给出所有芯片的测试结果，问哪些芯片是好芯片。
	// * 输入格式
	// * 输入数据第一行为一个整数n，表示芯片个数。
	// * 第二行到第n+1行为n*n的一张表，每行n个数据。表中的每个数据为0或1，在这n行中的第i行第j列（1≤i, j≤n）的数据表示用第i
	// * 块芯片测试第j块芯片时得到的测试结果，1表示好，0表示坏，i=j时一律为1（并不表示该芯片对本身的测试结果。芯片不能对本身进行
	// * 测试）。
	// * 输出格式
	// * 按从小到大的顺序输出所有好芯片的编号
	// *
	// * 样例输入
	// * 3
	// * 1 0 1
	// * 0 1 0
	// * 1 0 1
	// * 样例输出
	// * 1 3
	// * */
	private static void BASIC_23() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();

		int temp[] = new int[n];

		for (int j = 0; j < a.length; j++) {

			int flag = 0;
			for (int i = 0; i < a.length; i++) {
				if (java.util.Arrays.equals(a[j], a[i])) {
					flag++;
				}
			}
			if (flag > n / 2) {
				temp = a[j];
				break;
			}
		}

		for (int i = 0; i < temp.length; i++) {
			if (java.util.Arrays.equals(temp, a[i])) {
				System.out.print(i + 1 + " ");
			}
		}
	}

	// /*
	// * 基础练习 FJ的字符串
	// *
	// * 问题描述
	// * FJ在沙盘上写了这样一些字符串：
	// * A1 = “A”
	// * A2 = “ABA”
	// * A3 = “ABACABA”
	// * A4 = “ABACABADABACABA”
	// * … …
	// * 你能找出其中的规律并写所有的数列AN吗？
	// * 输入格式
	// * 仅有一个数：N ≤ 26。
	// * 输出格式
	// * 请输出相应的字符串AN，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
	// *
	// * 样例输入
	// * 3
	// * 样例输出
	// * ABACABA
	// * */
	private static void BASIC_22() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		String A[] = new String[n];
		char a = 'A';
		A[0] = "" + (char) (a + 0);
		for (int i = 1; i < n; i++) {
			A[i] = A[i - 1] + (char) (a + i) + A[i - 1];
		}
		System.out.println(A[n - 1]);
	}

	// /*
	// * 基础练习 Sine之舞
	// *
	// * 问题描述
	// * 最近FJ为他的奶牛们开设了数学分析课，FJ知道若要学好这门课，必须有一个好的三角函数基本功。所以他准备和奶牛们做一
	// * 个“Sine之舞”的游戏，寓教于乐，提高奶牛们的计算能力。
	// * 不妨设
	// * An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
	// * Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
	// * FJ想让奶牛们计算Sn的值，请你帮助FJ打印出Sn的完整表达式，以方便奶牛们做题。
	// * 输入格式
	// * 仅有一个数：N<201。
	// * 输出格式
	// * 请输出相应的表达式Sn，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
	// *
	// * 样例输入
	// * 3
	// * 样例输出
	// * ((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1
	// * */
	private static void BASIC_21() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		String[] A = new String[n];
		String Sn = "";

		for (int i = 0; i < n; i++) {
			String temp = "";

			for (int j = i + 1; j > 0; j--) {
				if ((j - 1) % 2 == 0) {
					if (j - 1 == 0) {
						temp = "sin(" + j + temp + ")";
					} else {
						temp = "+" + "sin(" + j + temp + ")";
					}
				} else {
					temp = "-" + "sin(" + j + temp + ")";
				}

			}
			A[i] = temp;
			// System.out.println("A[" + i + "]:" + A[i]);
		}

		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				Sn = Sn + A[i] + "+" + (n - i);
			} else {
				Sn = "(" + Sn + A[i] + "+" + (n - i) + ")";
			}
		}
		System.out.println(Sn);

	}

	// /*
	// * 基础练习 数的读法
	// *
	// * 问题描述
	// * Tom教授正在给研究生讲授一门关于基因的课程，有一件事情让他颇为头疼：一条染色体上有成千上万个碱基对，它们从0开始编号，
	// * 到几百万，几千万，甚至上亿。
	// * 比如说，在对学生讲解第1234567009号位置上的碱基时，光看着数字是很难准确的念出来的。
	// * 所以，他迫切地需要一个系统，然后当他输入12 3456 7009时，会给出相应的念法：
	// * 十二亿三千四百五十六万七千零九
	// * 用汉语拼音表示为
	// * shi er yi san qian si bai wu shi liu wan qi qian ling jiu
	// * 这样他只需要照着念就可以了。
	// * 你的任务是帮他设计这样一个系统：给定一个阿拉伯数字串，你帮他按照中文读写的规范转为汉语拼音字串，相邻的两个音节用一个
	// * 空格符格开。
	// * 注意必须严格按照规范，比如说“10010”读作“yi wan ling yi shi”而不是“yi wan ling
	// shi”，“100000”读作“shi
	// * wan”而不是“yi shi wan”，“2000”读作“er qian”而不是“liang qian”。
	// *
	// * 输入格式
	// * 有一个数字串，数值大小不超过2,000,000,000。
	// * 输出格式
	// * 是一个由小写英文字母，逗号和空格组成的字符串，表示该数的英文读法。
	// *
	// * 样例输入
	// * 1234567009
	// * 样例输出
	// * shi er yi san qian si bai wu shi liu wan qi qian ling jiu
	// * */
	private static void BASIC_20() {
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		sc.close();

		char[] a = string.toCharArray();

		for (int i = 0; i < a.length / 2; i++) {
			char temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		}

		String result = "";

		for (int j = 0; j < a.length; j++) {
			if (a[j] != '0') {
				switch (j % 4) {
				case 1:
					result = "shi " + result;
					break;
				case 2:
					result = "bai " + result;
					break;
				case 3:
					result = "qian " + result;
					break;
				default:
					break;
				}

				switch (j) {
				case 4:
					result = "wan " + result;
					break;
				case 8:
					result = "yi " + result;
					break;
				default:
					break;
				}

			}

			switch (a[j]) {
			case '0':

				if (!result.equals("") && a[j - 1] != '0') {
					result = "ling " + result;
				}
				break;
			case '1':
				if (j == 1 || j == 5 || j == 9) {

				} else {
					result = "yi " + result;
				}
				break;
			case '2':
				result = "er " + result;
				break;
			case '3':
				result = "san " + result;
				break;
			case '4':
				result = "si " + result;
				break;
			case '5':
				result = "wu " + result;
				break;
			case '6':
				result = "liu " + result;
				break;
			case '7':
				result = "qi " + result;
				break;
			case '8':
				result = "ba " + result;
				break;
			case '9':
				result = "jiu " + result;
				break;
			default:
				break;
			}
		}
		System.out.println(result);
	}

	// /*
	// * 基础练习 完美的代价
	// *
	// * 问题描述
	// * 回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。现在给你一个串，它不一定是
	// * 回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
	// * 交换的定义是：交换两个相邻的字符
	// * 例如mamad
	// * 第一次交换 ad : mamda
	// * 第二次交换 md : madma
	// * 第三次交换 ma : madam (回文！完美！)
	// * 输入格式
	// * 第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
	// * 第二行是一个字符串，长度为N.只包含小写字母
	// * 输出格式
	// * 如果可能，输出最少的交换次数。
	// * 否则输出Impossible
	// *
	// * 样例输入
	// * 5
	// * mamad
	// * 样例输出
	// * 3
	// * */
	private static void BASIC_19() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String string = sc.next();
		sc.close();

		char a[] = string.toCharArray();

		int b = a.length;
		int num = 0;
		if (n % 2 == 0) {

			for (int i = 0; i < n; i++) {
				int flag = 0;
				for (int j = b - i - 1; j >= i; j--) {
					if (a[i] == a[j]) {
						if (i == j) {
							System.out.println("Impossible");
							return;
						} else {
							for (int j2 = b - i - 1; j2 >= j; j2--) {
								char temp = a[j];
								a[j] = a[j2];
								a[j2] = temp;
								flag = b - i - 1 - j;
							}
							// System.out.println(flag);
							break;
						}
					}
				}
				num = num + flag;
				// for (int j = 0; j < a.length; j++) {
				// System.out.print(a[j]);
				// }
				// System.out.println();
			}
			System.out.println(num);
			return;
		} else {
			boolean flag2 = true;
			for (int i = 0; i < n; i++) {
				int flag = 0;
				for (int j = b - i - 1; j >= i; j--) {
					if (a[i] == a[j]) {

						if (i == n / 2) {
							System.out.println(num);
							return;
						} else if (i == j) {
							if (flag2) {
								for (int j2 = 0; j2 < a.length / 2; j2++) {
									char temp = a[j2];
									a[j2] = a[a.length - j2 - 1];
									a[a.length - j2 - 1] = temp;
								}
								i = i - 1;
								flag2 = false;
							} else {
								System.out.println("Impossible");
								return;
							}

							// no best
							// if(flag2){
							// char temp = a[i];
							// a[i] = a[n/2];
							// a[n/2] = temp;
							// flag = n/2 -i;
							// flag2 = false;
							// System.out.println(i+" "+flag2+" "+flag);
							// i = i - 1;
							// }
							// else{
							// System.out.println("Impossible");
							// return;
							// }

							break;
						} else {
							for (int j2 = b - i - 1; j2 >= j; j2--) {
								// no best
								// if (j2 == n / 2) {
								// flag2 = true;
								// }
								char temp = a[j];
								a[j] = a[j2];
								a[j2] = temp;
								flag = b - i - 1 - j;
							}
							// System.out.println(flag);
							break;
						}

					}
				}
				num = num + flag;
				// for (int j = 0; j < a.length; j++) {
				// System.out.print(a[j]);
				// }
				// System.out.println();
			}
			System.out.println(num);
			return;
		}

	}

	// /*
	// * 基础练习 矩形面积交
	// *
	// * 问题描述
	// * 平面上有两个矩形，它们的边平行于直角坐标系的X轴或Y轴。对于每个矩形，我们给出它的一对相对顶点的坐标，请你编程算出两个
	// * 矩形的交的面积。
	// * 输入格式
	// * 输入仅包含两行，每行描述一个矩形。
	// * 在每行中，给出矩形的一对相对顶点的坐标，每个点的坐标都用两个绝对值不超过10^7的实数表示。
	// * 输出格式
	// * 输出仅包含一个实数，为交的面积，保留到小数后两位。
	// *
	// * 样例输入
	// * 1 1 3 3
	// * 2 2 4 4
	// * 样例输出
	// * 1.00
	// * */
	private static void BASIC_18() {
		Scanner sc = new Scanner(System.in);
		double a[] = new double[4];
		double b[] = new double[4];
		// for (int i = 0; i < a.length; i++) {
		// a[i] = sc.nextDouble();
		// }
		// for (int i = 0; i < b.length; i++) {
		// b[i] = sc.nextDouble();
		// }
		for (int i = 0; i < 4; i++) {
			a[i] = sc.nextDouble();
			b[i] = sc.nextDouble();
		}
		sc.close();

		java.util.Arrays.sort(a, 0, 2);
		java.util.Arrays.sort(a, 2, 4);
		java.util.Arrays.sort(b, 0, 2);
		java.util.Arrays.sort(b, 2, 4);
		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i]+" ");
		// }
		if (a[1] <= a[2] || a[0] >= a[3] || b[0] >= b[3] || b[1] <= b[2]) {
			System.out.println("0.00");
		} else {
			java.util.Arrays.sort(a, 0, 4);
			java.util.Arrays.sort(b, 0, 4);
			// System.out.println(Math.abs((a[2] - a[1]) * (b[2] - b[1])));
			System.out.println(String.format("%.2f", Math.abs((a[2] - a[1]) * (b[2] - b[1]))));
		}

	}

	// /*
	// * 基础练习 矩阵乘法
	// *
	// * 问题描述
	// * 给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
	// * 例如：
	// * A =
	// * 1 2
	// * 3 4
	// * A的2次幂
	// * 7 10
	// * 15 22
	// * 输入格式
	// * 第一行是一个正整数N、M（1<=N<=30, 0<=M<=5），表示矩阵A的阶数和要求的幂数
	// * 接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
	// * 输出格式
	// * 输出共N行，每行N个整数，表示A的M次幂所对应的矩阵。相邻的数之间用一个空格隔开
	// *
	// * 样例输入
	// * 2 2
	// * 1 2
	// * 3 4
	// * 样例输出
	// * 7 10
	// * 15 22
	// * */
	private static void BASIC_17() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();

		int[][] temp = new int[n][n];

		switch (m) {
		case 0:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						temp[i][j] = 1;
					}
				}
			}

			break;
		case 1:
			temp = a;
			break;
		case 2:
			temp = BASIC_17_multiplicativeMatrix(a, a);
			break;
		case 3:
			temp = BASIC_17_multiplicativeMatrix(BASIC_17_multiplicativeMatrix(a, a), a);
			break;
		case 4:
			temp = BASIC_17_multiplicativeMatrix(BASIC_17_multiplicativeMatrix(a, a),
					BASIC_17_multiplicativeMatrix(a, a));
			break;
		case 5:
			temp = BASIC_17_multiplicativeMatrix(BASIC_17_multiplicativeMatrix(BASIC_17_multiplicativeMatrix(a, a),
					BASIC_17_multiplicativeMatrix(a, a)), a);
			break;
		default:
			break;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int[][] BASIC_17_multiplicativeMatrix(int[][] a, int[][] b) {

		int c[][] = new int[a.length][b[0].length];

		int x, i, j;
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < b[0].length; j++) {
				int temp = 0;
				for (x = 0; x < b.length; x++) {
					temp += a[i][x] * b[x][j];
				}
				c[i][j] = temp;
			}
		}
		return c;
	}

	// /*
	// * 基础练习 分解质因数
	// *
	// * 问题描述
	// * 求出区间[a,b]中所有整数的质因数分解。
	// * 输入格式
	// * 输入两个整数a，b。
	// * 输出格式
	// * 每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
	// *
	// * 样例输入
	// * 3 10
	// * 样例输出
	// * 3=3
	// * 4=2*2
	// * 5=5
	// * 6=2*3
	// * 7=7
	// * 8=2*2*2
	// * 9=3*3
	// * 10=2*5
	// * 提示
	// * 先筛出所有素数，然后再分解。
	// *
	// * 数据规模和约定
	// * 2<=a<=b<=10000
	// * */
	private static void BASIC_16() {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		sc.close();

		for (int j = a; j < b + 1; j++) {
			int num = j;
			StringBuffer sb = new StringBuffer();
			sb.append(num + "=");
			while (true) {
				if (num < 2)
					break;
				boolean flag = false;
				for (int i = 2; i < num; i++) {
					if (num % i == 0) {
						sb.append(i + "*");
						flag = true;
						num = num / i;
						break;
					}
				}
				if (!flag)
					break;
			}
			sb.append(num);
			System.out.print(sb.toString());
			System.out.println();
		}
	}

	// /*
	// * 基础练习 字符串对比
	// *
	// * 问题描述
	// * 给定两个仅由大写字母或小写字母组成的字符串(长度介于1到10之间)，它们之间的关系是以下4中情况之一：
	// * 1：两个字符串长度不等。比如 Beijing 和 Hebei
	// * 2：两个字符串不仅长度相等，而且相应位置上的字符完全一致(区分大小写)，比如 Beijing 和 Beijing
	// * 3：两个字符串长度相等，相应位置上的字符仅在不区分大小写的前提下才能达到完全一致（也就是说，它并不满足情况2）。比如 beijing 和
	// BEIjing
	// * 4：两个字符串长度相等，但是即使是不区分大小写也不能使这两个字符串一致。比如 Beijing 和 Nanjing
	// * 编程判断输入的两个字符串之间的关系属于这四类中的哪一类，给出所属的类的编号。
	// * 输入格式
	// * 包括两行，每行都是一个字符串
	// * 输出格式
	// * 仅有一个数字，表明这两个字符串的关系编号
	// *
	// * 样例输入
	// * BEIjing
	// * beiJing
	// * 样例输出
	// * 3
	// * */
	private static void BASIC_15() {
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		String string2 = sc.next();
		sc.close();

		if (string.length() != string2.length()) {
			System.out.println(1);
			return;
		} else if (string.equals(string2)) {
			System.out.println(2);
			return;
		} else if (string.equalsIgnoreCase(string2)) {
			System.out.println(3);
			return;
		} else {
			System.out.println(4);
			return;
		}
	}

	// /*
	// * 基础练习 时间转换
	// *
	// * 问题描述
	// * 给定一个以秒为单位的时间t，要求用“<H>:<M>:<S>”的格式来表示这个时间。<H>表示时间，<M>表示分钟，而<S>表示秒，它们都
	// * 是整数且没有前导的“0”。例如，若t=0，则应输出是“0:0:0”；若t=3661，则输出“1:1:1”。
	// * 输入格式
	// * 输入只有一行，是一个整数t（0<=t<=86399）。
	// * 输出格式
	// * 输出只有一行，是以“<H>:<M>:<S>”的格式所表示的时间，不包括引号。
	// *
	// * 样例输入
	// * 0
	// * 样例输出
	// * 0:0:0
	// * 样例输入
	// * 5436
	// * 样例输出
	// * 1:30:36
	// * */
	private static void BASIC_14() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int h, m, s;
		h = n / 3600;
		n = n % 3600;
		m = n / 60;
		s = n % 60;

		System.out.println(h + ":" + m + ":" + s);
	}

	// /*
	// * 基础练习 数列排序
	// *
	// * 问题描述
	// * 给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
	// * 输入格式
	// * 第一行为一个整数n。
	// * 第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
	// * 输出格式
	// * 输出一行，按从小到大的顺序输出排序后的数列。
	// *
	// * 样例输入
	// * 5
	// * 8 3 6 4 9
	// * 样例输出
	// * 3 4 6 8 9
	// * */
	private static void BASIC_13() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();

		}
		sc.close();

		java.util.Arrays.sort(a);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

	// /*
	// * 基础练习 十六进制转八进制
	// *
	// * 问题描述
	// * 给定n个十六进制正整数，输出它们对应的八进制数。
	// * 输入格式
	// * 输入的第一行为一个正整数n （1<=n<=10）。
	// * 接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
	// * 输出格式
	// * 输出n行，每行为输入对应的八进制正整数。
	// * 【注意】
	// * 输入的十六进制数不会有前导0，比如012A。
	// * 输出的八进制数也不能有前导0。
	// *
	// * 样例输入
	// * 2
	// * 39
	// * 123ABC
	// * 样例输出
	// * 71
	// * 4435274
	// *
	// * 【提示】
	// * 先将十六进制数转换成某进制数，再由某进制数转换成八进制。
	// * */
	// TODO 运行超时
	private static void BASIC_12() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] string = new String[n];
		for (int i = 0; i < string.length; i++) {
			string[i] = sc.next();
		}
		sc.close();

		String data = "";
		for (int i = 0; i < string.length; i++) {
			data = "";
			char temp[] = string[i].toCharArray();

			for (int j = 0; j < temp.length; j++) {
				switch (temp[temp.length - j - 1]) {
				case '0':
					data = "0000" + data;
					break;
				case '1':
					data = "0001" + data;
					break;
				case '2':
					data = "0010" + data;
					break;
				case '3':
					data = "0011" + data;
					break;
				case '4':
					data = "0100" + data;
					break;
				case '5':
					data = "0101" + data;
					break;
				case '6':
					data = "0110" + data;
					break;
				case '7':
					data = "0111" + data;
					break;
				case '8':
					data = "1000" + data;
					break;
				case '9':
					data = "1001" + data;
					break;
				case 'A':
					data = "1010" + data;
					break;
				case 'B':
					data = "1011" + data;
					break;
				case 'C':
					data = "1100" + data;
					break;
				case 'D':
					data = "1101" + data;
					break;
				case 'E':
					data = "1110" + data;
					break;
				case 'F':
					data = "1111" + data;
					break;
				}

			}
			// 16To2
			// System.out.println("before:" + data);
			if (data.length() % 3 != 0) {
				for (int j2 = 0; j2 < data.length() % 3; j2++) {
					data = "0" + data;
				}
			}
			// System.out.println("after:" + data);
			// 2To8
			String value = "";
			for (int j = 0; j < data.length(); j += 3) {
				char threeChar[] = ((String) data.subSequence(j, j + 3)).toCharArray();
				int num = 0;
				for (int k = 0; k < threeChar.length; k++) {

					switch (threeChar[k]) {
					case '1':
						switch (k) {
						case 0:
							num = num + 4;
							break;
						case 1:
							num = num + 2;
							break;
						case 2:
							num = num + 1;
							break;
						case '0':
							break;
						}

					}

				}

				value = value + num;

			}
			System.out.println(value);
		}

	}

	// /*
	// * 基础练习 十六进制转十进制
	// *
	// * 问题描述
	// * 从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
	// * 注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
	// *
	// * 样例输入
	// * FFFF
	// * 样例输出
	// * 65535
	// * */
	private static void BASIC_11() {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		sc.close();

		long sum = 0;
		long flag = 0;
		for (int i = n.length() - 1; i >= 0; i--) {
			switch (n.charAt(i)) {
			case 'A':
				sum = 10 * BASIC_11_mathPow(16, flag) + sum;
				break;
			case 'B':
				sum = 11 * BASIC_11_mathPow(16, flag) + sum;
				break;
			case 'C':
				sum = 12 * BASIC_11_mathPow(16, flag) + sum;
				break;
			case 'D':
				sum = 13 * BASIC_11_mathPow(16, flag) + sum;
				break;
			case 'E':
				sum = 14 * BASIC_11_mathPow(16, flag) + sum;
				break;
			case 'F':
				sum = 15 * BASIC_11_mathPow(16, flag) + sum;
				break;

			default:
				sum = Integer.parseInt("" + n.charAt(i)) * BASIC_11_mathPow(16, flag) + sum;
				// System.out.println(Integer.parseInt(""+n.charAt(i))*1);
				break;
			}
			flag++;
		}
		System.out.println(sum);
	}

	private static long BASIC_11_mathPow(long n, long m) {
		if (m == 0) {
			return 1;
		}
		long sum = 1;
		for (long i = 0; i < m; i++) {
			sum = sum * n;
		}
		return sum;
	}

	// /*
	// * 基础练习 十进制转十六进制
	// *
	// * 问题描述
	// * 十六进制数是在程序设计时经常要使用到的一种整数的表示方式。它有0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F共16个符号，
	// * 分别表示十进制数的0至15。十六进制的计数方法是满16进1，所以十进制数16在十六进制中是10，而十进制的17在十六进制中是
	// * 11，以此类推，十进制的30在十六进制中是1E。
	// * 给出一个非负整数，将它表示成十六进制的形式。
	// * 输入格式
	// * 输入包含一个非负整数a，表示要转换的数。0<=a<=2147483647
	// * 输出格式
	// * 输出这个整数的16进制表示
	// *
	// * 样例输入
	// * 30
	// * 样例输出
	// * 1E
	// * */
	private static void BASIC_10() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		// System.out.println(Integer.toHexString(n));
		System.out.println(BASIC_10_toHex(n));

	}

	public static String BASIC_10_toHex(int num) {
		char[] HEX = "0123456789ABCDEF".toCharArray();

		if (num == 0) {
			return new String(HEX, 0, 1);
		}
		char[] chs = new char[Integer.SIZE / 4];
		int offset = chs.length - 1;
		while (num != 0) {
			chs[offset--] = HEX[num & 0xf];
			num >>>= 4;
		}
		return new String(chs, offset + 1, chs.length - offset - 1);
	}

	// /*
	// * 基础练习 特殊回文数
	// *
	// * 问题描述
	// * 123321是一个非常特殊的数，它从左边读和从右边读是一样的。
	// * 输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
	// * 输入格式
	// * 输入一行，包含一个正整数n。
	// * 输出格式
	// * 按从小到大的顺序输出满足条件的整数，每个整数占一行。
	// *
	// * 样例输入
	// * 52
	// * 样例输出
	// * 899998
	// * 989989
	// * 998899
	// *
	// * 数据规模和约定
	// * 1<=n<=54。
	// * */
	private static void BASIC_9() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int size5[] = new int[5];
		int size6[] = new int[6];
		int sum = 0;

		if (n % 2 == 0) {

			for (int i = 10001; i < 100000; i++) {
				size5[0] = i / 10000;
				size5[1] = (i - size5[0] * 10000) / 1000;
				size5[2] = (i - size5[0] * 10000 - size5[1] * 1000) / 100;
				if (size5[2] % 2 != 0) {
					continue;
				}
				size5[3] = (i - size5[0] * 10000 - size5[1] * 1000 - size5[2] * 100) / 10;
				size5[4] = i - size5[0] * 10000 - size5[1] * 1000 - size5[2] * 100 - size5[3] * 10;
				if (size5[0] == size5[4] && size5[3] == size5[1]) {
					sum = 0;
					for (int j = 0; j < size5.length; j++) {
						sum = sum + size5[j];

					}
					if (sum == n) {
						System.out.println(i);
					}
				}
			}

			for (int i = 100001; i < 1000000; i++) {
				size6[0] = i / 100000;
				size6[1] = (i - size6[0] * 100000) / 10000;
				size6[2] = (i - size6[0] * 100000 - size6[1] * 10000) / 1000;
				size6[3] = (i - size6[0] * 100000 - size6[1] * 10000 - size6[2] * 1000) / 100;
				size6[4] = (i - size6[0] * 100000 - size6[1] * 10000 - size6[2] * 1000 - size6[3] * 100) / 10;
				size6[5] = i - size6[0] * 100000 - size6[1] * 10000 - size6[2] * 1000 - size6[3] * 100 - size6[4] * 10;
				if (size6[0] == size6[5] && size6[1] == size6[4] && size6[2] == size6[3]) {
					sum = 0;
					for (int j = 0; j < size6.length; j++) {
						sum = sum + size6[j];
					}
					if (n == sum) {
						System.out.println(i);
					}
				}
			}

		} else {
			for (int i = 10001; i < 100000; i++) {
				size5[0] = i / 10000;
				size5[1] = (i - size5[0] * 10000) / 1000;
				size5[2] = (i - size5[0] * 10000 - size5[1] * 1000) / 100;
				if (size5[2] % 2 == 0) {
					continue;
				}
				size5[3] = (i - size5[0] * 10000 - size5[1] * 1000 - size5[2] * 100) / 10;
				size5[4] = i - size5[0] * 10000 - size5[1] * 1000 - size5[2] * 100 - size5[3] * 10;
				if (size5[0] == size5[4] && size5[3] == size5[1]) {
					sum = 0;
					for (int j = 0; j < size5.length; j++) {
						sum = sum + size5[j];

					}
					if (sum == n) {
						System.out.println(i);
					}
				}
			}

		}

		// 以下的方法是正确的
		// // size5
		// for (int i = 10001; i < 100000; i++) {
		// size5[0] = i / 10000;
		// size5[1] = (i - size5[0] * 10000) / 1000;
		// size5[2] = (i - size5[0] * 10000 - size5[1] * 1000) / 100;
		//
		// size5[3] = (i - size5[0] * 10000 - size5[1] * 1000 - size5[2] * 100)
		// / 10;
		// size5[4] = i - size5[0] * 10000 - size5[1] * 1000 - size5[2] * 100
		// - size5[3] * 10;
		// if (size5[0] == size5[4] && size5[3] == size5[1]) {
		// sum = 0;
		// for (int j = 0; j < size5.length; j++) {
		// sum = sum + size5[j];
		//
		// }
		// if (sum == n) {
		// System.out.println(i);
		// }
		//
		// }
		// }
		//
		// // size6
		// for (int i = 100001; i < 1000000; i++) {
		// size6[0] = i / 100000;
		// size6[1] = (i - size6[0] * 100000) / 10000;
		// size6[2] = (i - size6[0] * 100000 - size6[1] * 10000) / 1000;
		// size6[3] = (i - size6[0] * 100000 - size6[1] * 10000 - size6[2] *
		// 1000) / 100;
		// size6[4] = (i - size6[0] * 100000 - size6[1] * 10000 - size6[2]
		// * 1000 - size6[3] * 100) / 10;
		// size6[5] = i - size6[0] * 100000 - size6[1] * 10000 - size6[2]
		// * 1000 - size6[3] * 100 - size6[4] * 10;
		// if (size6[0] == size6[5] && size6[1] == size6[4]
		// && size6[2] == size6[3]) {
		// sum = 0;
		// for (int j = 0; j < size6.length; j++) {
		// sum = sum + size6[j];
		// }
		// if (n == sum) {
		// System.out.println(i);
		// }
		// }
		//
		// }

	}

	/*
	 * 基础练习 回文数 问题描述 1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。 输出格式
	 * 按从小到大的顺序输出满足条件的四位十进制数。
	 */
	private static void BASIC_8() {
		int[] a = new int[4];
		for (int i = 1000; i < 10000; i++) {
			a[0] = i / 1000;
			a[1] = (i - a[0] * 1000) / 100;
			a[2] = (i - a[0] * 1000 - a[1] * 100) / 10;
			a[3] = i - a[0] * 1000 - a[1] * 100 - a[2] * 10;
			if (a[0] == a[3] && a[2] == a[1]) {
				System.out.println(i);
			}
		}
	}

	// /*
	// * 基础练习 特殊的数字
	// *
	// * 问题描述
	// * 153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。
	// * 输出格式
	// * 按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。
	// * */
	private static void BASIC_7() {
		int g, s, b;
		for (int i = 100; i < 1000; i++) {
			b = i / 100;
			s = (i - b * 100) / 10;
			g = i - b * 100 - s * 10;

			if (i == (b * b * b + s * s * s + g * g * g)) {
				System.out.println(i);
			}
		}
	}

	/*
	 * 基础练习 杨辉三角形
	 * 
	 * 问题描述 杨辉三角形又称Pascal三角形，它的第i+1行是(a+b)i的展开式的系数。
	 * 它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。 下面给出了杨辉三角形的前4行： 1 1 1 1 2 1 1 3 3 1
	 * 给出n，输出它的前n行。 输入格式 输入包含一个数n。 输出格式
	 * 输出杨辉三角形的前n行。每一行从这一行的第一个数开始依次输出，中间使用一个空格分隔。请不要在前面输出多余的空格。
	 * 
	 * 样例输入 4 样例输出 1 1 1 1 2 1 1 3 3 1
	 * 
	 * 数据规模与约定 1 <= n <= 34。
	 */
	private static void BASIC_6() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int a[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					a[i][j] = 1;
				} else {
					a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
				}
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	// /*
	// * 基础练习 查找整数
	// *
	// * 问题描述
	// * 给出一个包含n个整数的数列，问整数a在数列中的第一次出现是第几个。
	// * 输入格式
	// * 第一行包含一个整数n。
	// * 第二行包含n个非负整数，为给定的数列，数列中的每个数都不大于10000。
	// * 第三行包含一个整数a，为待查找的数。
	// * 输出格式
	// * 如果a在数列中出现了，输出它第一次出现的位置(位置从1开始编号)，否则输出-1。
	// *
	// * 样例输入
	// * 6
	// * 1 9 4 8 3 9
	// * 9
	// * 样例输出
	// * 2
	// *
	// * 数据规模与约定
	// * 1 <= n <= 1000。
	// * */
	private static void BASIC_5() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		sc.close();

		int l = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == m) {
				l = i + 1;
				break;
			}
		}
		System.out.println(l);
	}

	// /*
	// * 基础练习 数列特征
	// *
	// * 问题描述
	// * 给出n个数，找出这n个数的最大值，最小值，和。
	// * 输入格式
	// * 第一行为整数n，表示数的个数。
	// * 第二行有n个数，为给定的n个数，每个数的绝对值都小于10000。
	// * 输出格式
	// * 输出三行，每行一个整数。第一行表示这些数中的最大值，第二行表示这些数中的最小值，第三行表示这些数的和。
	// *
	// * 样例输入
	// * 5
	// * 1 3 -2 4 5
	// * 样例输出
	// * 5
	// * -12
	// * 11
	// *
	// * 数据规模与约定
	// * 1 <= n <= 10000。
	// * */
	private static void BASIC_4() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		// 该排序算法运行超时
		// int temp = 0;
		// for (int i = 0; i < a.length; i++) {
		// for (int j = i + 1; j < a.length; j++) {
		// if (a[i] > a[j]) {
		// temp = a[j];
		// a[j] = a[i];
		// a[i] = temp;
		// }
		// }
		// }

		java.util.Arrays.sort(a);

		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		System.out.println(a[a.length - 1]);
		System.out.println(a[0]);
		System.out.println(sum);

	}

	// /*
	// * 基础练习 字母图形
	// *
	// * 问题描述
	// * 利用字母可以组成一些美丽的图形，下面给出了一个例子：
	// * ABCDEFG
	// * BABCDEF
	// * CBABCDE
	// * DCBABCD
	// * EDCBABC
	// * 这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形。
	// * 输入格式
	// * 输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
	// * 输出格式
	// * 输出n行，每个m个字符，为你的图形。
	// *
	// * 样例输入
	// * 5 7
	// * 样例输出
	// * ABCDEFG
	// * BABCDEF
	// * CBABCDE
	// * DCBABCD
	// * EDCBABC
	// *
	// * 数据规模与约定
	// * 1 <= n, m <= 26。
	// * */
	private static void BASIC_3() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		// System.out.println((byte)'A');
		char[] l = new char[26];
		for (int i = 0; i < l.length; i++) {
			l[i] = (char) (65 + i);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(l[Math.abs(i - j) % 26]);
			}
			System.out.println();
		}
	}

	// /*
	// * 基础练习 01字串
	// *
	// * 问题描述
	// * 对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：
	// * 00000
	// * 00001
	// * 00010
	// * 00011
	// * 00100
	// * 请按从小到大的顺序输出这32种01串。
	// * 输入格式
	// * 本试题没有输入。
	// * 输出格式
	// * 输出32行，按从小到大的顺序每行一个长度为5的01串。
	// *
	// * 样例输出
	// * 00000
	// * 00001
	// * 00010
	// * 00011
	// * <以下部分省略>
	// * */
	@SuppressWarnings("unused")
	private static void BASIC_2() {
		int a[] = new int[5];
		int temp;
		for (int i = 0; i < 32; i++) {
			// System.out.println(Integer.toBinaryString(i));
			temp = i;
			a[0] = temp / 16;
			temp = temp % 16;

			a[1] = temp / 8;
			temp = temp % 8;

			a[2] = temp / 4;
			temp = temp % 4;

			a[3] = temp / 2;
			temp = temp % 2;

			a[4] = temp / 1;

			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j]);
			}
			System.out.println();
		}
	}

	// /*
	// * 基础练习 闰年判断
	// *
	// * 问题描述
	// * 给定一个年份，判断这一年是不是闰年。
	// * 当以下情况之一满足时，这一年是闰年：
	// * 1. 年份是4的倍数而不是100的倍数；
	// * 2. 年份是400的倍数。
	// * 其他的年份都不是闰年。
	// * 输入格式
	// * 输入包含一个整数y，表示当前的年份。
	// * 输出格式
	// * 输出一行，如果给定的年份是闰年，则输出yes，否则输出no。
	// *
	// * 样例输入
	// * 2013
	// * 样例输出
	// * no
	// * 样例输入
	// * 2016
	// * 样例输出
	// * yes
	// *
	// * 数据规模与约定
	// * 1990 <= y <= 2050。
	// * */
	@SuppressWarnings("unused")
	private static void BASIC_1() {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		sc.close();
		if (year % 400 == 0) {
			System.out.println("yes");
		} else if (year % 4 == 0 && year % 100 != 0) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

}
