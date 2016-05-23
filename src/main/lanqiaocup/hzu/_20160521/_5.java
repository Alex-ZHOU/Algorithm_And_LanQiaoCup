package main.lanqiaocup.hzu._20160521;

import java.util.Scanner;

///*
// * 最大报销额
// * Time Limit: 1000MS
// * Memory Limit: 32768KB
// * 64bit IO Format: %I64d & %I64u
// * 
// * Description
// * 现有一笔经费可以报销一定额度的发票。允许报销的发票类型包括买图书
// * （A类）、文具（B类）、差旅（C类），要求每张发票的总额不得超过1000
// * 元，每张发票上，单项物品的价值不得超过600元。现请你编写程序，在
// * 给出的一堆发票中找出可以报销的、不超过给定额度的最大报销额。 
// * 
// * Input
// * 测试输入包含若干测试用例。每个测试用例的第1行包含两个正数 Q 和 N，
// * 其中 Q 是给定的报销额度，N（<=30）是发票张数。随后是 N 行输入，
// * 每行的格式为： 
// * m Type_1:price_1 Type_2:price_2 ... Type_m:price_m 
// * 其中正整数 m 是这张发票上所开物品的件数，Type_i 和 price_i 是
// * 第 i 项物品的种类和价值。物品种类用一个大写英文字母表示。当N为0时，
// * 全部输入结束，相应的结果不要输出。
// * Output
// * 对每个测试用例输出1行，即可以报销的最大数额，精确到小数点后2位。
// *  
// * Sample Input
// * 800.00 3
// * 2 A:23.50 B:100.00
// * 1 C:650.00
// * 3 A:59.99 A:120.00 X:10.00
// * 1200.00 2
// * 2 B:600.00 A:400.00
// * 1 C:200.50
// * 1200.50 3
// * 2 B:600.00 A:400.00
// * 1 C:200.50
// * 1 A:100.00
// * 100.00 0 
// * Sample Output
// * 123.50
// * 1000.00
// * 1200.50
// */
public class _5 {
	private static float Q = 0;
	private static int N = 0;

	private static class Invoice {
		int m;
		String type[];
		float money[];
		float sumMoney;
	}

	private static Invoice invoice[] = new Invoice[30];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			Q = sc.nextFloat();
			N = sc.nextInt();
			if (N == 0) {
				sc.close();
				return;
			}

			for (int i = 0; i < N; i++) {

				invoice[i] = new Invoice();
				invoice[i].m = sc.nextInt();

				invoice[i].money = new float[invoice[i].m];
				invoice[i].type = new String[invoice[i].m];

				for (int j = 0; j < invoice[i].m; j++) {

					String tempstr = sc.next();
					invoice[i].type[j] = tempstr.substring(0, 1);
					invoice[i].money[j] = Float.parseFloat(tempstr.substring(2, tempstr.length()));
					invoice[i].sumMoney += invoice[i].money[j];
					// System.out.print(invoice[i].type[j] + ":" +
					// invoice[i].money[j] + " ");
				}

			}
			System.out.println();
			System.out.printf("%.2f", dp(0, 0));

		}

	}

	private static float dp(int i, float money) {
		// System.out.println("i:" + i + " money:" + money);
		float re;

		if (i == N) {

			re = 0;
		} else if (invoice[i].sumMoney > 1000 || money + invoice[i].sumMoney > Q) {
			re = dp(i + 1, money);
		} else {
			boolean flag = false;
			for (int j = 0; j < invoice[i].m; j++) {

				if ((invoice[i].type[j].equals("A") || invoice[i].type[j].equals("B") || invoice[i].type[j].equals("C"))
						&& invoice[i].money[j] <= 600) {

				} else {
					flag = true;
					break;
				}
			}

			if (!flag) {
				float temp1 = dp(i + 1, money);
				float temp2 = dp(i + 1, money + invoice[i].sumMoney) + invoice[i].sumMoney;

				re = temp1 > temp2 ? temp1 : temp2;

			} else {
				re = dp(i + 1, money);
			}
		}
		return re;
	}
}
