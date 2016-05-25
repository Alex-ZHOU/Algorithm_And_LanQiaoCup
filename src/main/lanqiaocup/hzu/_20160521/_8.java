package main.lanqiaocup.hzu._20160521;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

///*
// * 排列2
// * 
// * Time Limit: 1000MS
// * Memory Limit: 32768KB
// * 64bit IO Format: %I64d & %I64u
// * 
// * Description
// * Ray又对数字的列产生了兴趣： 现有四张卡片，用这四张卡片能排列出很多不同的4
// * 位数，要求按从小到大的顺序输出这些4位数。
// * 
// * Input
// * 每组数据占一行，代表四张卡片上的数字（0<=数字<=9），如果四张卡片都是0，则
// * 输入结束。
// * Output
// * 对每组卡片按从小到大的顺序输出所有能由这四张卡片组成的4位数，千位数字相同的
// * 在同一行，同一行中每个四位数间用空格分隔。 每组输出数据间空一行，最后一组数
// * 据后面没有空行。
// * 
// * Sample Input
// * 1 2 3 4
// * 1 1 2 3
// * 0 1 2 3
// * 0 0 0 0 
// * Sample Output
// * 1234 1243 1324 1342 1423 1432
// * 2134 2143 2314 2341 2413 2431
// * 3124 3142 3214 3241 3412 3421
// * 4123 4132 4213 4231 4312 4321
// * 
// * 1123 1132 1213 1231 1312 1321
// * 2113 2131 2311
// * 3112 3121 3211
// * 
// * 1023 1032 1203 1230 1302 1320
// * 2013 2031 2103 2130 2301 2310
// * 3012 3021 3102 3120 3201 3210 
// */
public class _8 {

	private static int a[] = new int[4];
	private static int num[] = new int[24];
	private static int total = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			if (a[0] == 0 && a[1] == 0 && a[2] == 0 && a[3] == 0) {
				sc.close();
				break;
			}

			total = 0;

			for (int i = 0; i < num.length; i++) {
				num[i] = 0;
			}

			paixu(0);
			// System.out.println(total);
			// for (int i = 0; i < num.length; i++) {
			// System.out.println(num[i]);
			// }

			Arrays.sort(num);
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < num.length; i++) {
				if (num[i] == Integer.MAX_VALUE) {
					break;
				} else {
					list.add(num[i]);
				}
				// System.out.println(num[i]);
			}

			// 去重
			for (int i = 0; i < list.size() - 1; i++) {
				// System.out.println((int) list.get(i) == (int) list.get(i +
				// 1));
				if ((int) list.get(i) == (int) list.get(i + 1)) {
					list.remove(i);
					i--;
				}
			}
			// System.out.println(list.size());
			System.out.println();
			int first = list.get(0) / 1000;
			for (int i = 0; i < list.size(); i++) {
				if (first == list.get(i) / 1000) {
					System.out.print(list.get(i) + " ");
				} else {
					System.out.println();
					System.out.print(list.get(i) + " ");
					first = list.get(i) / 1000;
				}
			}
			System.out.println();
		}
	}

	private static void paixu(int k) {
		// System.out.println("k: " + k);
		if (k == 3) {
			for (int i = 0; i < a.length; i++) {
				num[total] += a[i] * Math.pow(10, 3 - i);
				// System.out.print(a[i] + " ");
			}
			if (num[total] < 1000) {
				num[total] = Integer.MAX_VALUE;
			}
			// System.out.println();
			total++;
		}

		for (int i = k; i <= 4 - 1; i++) {
			// swap
			int temp = a[k];
			a[k] = a[i];
			a[i] = temp;

			paixu(k + 1);

			// swap
			temp = a[k];
			a[k] = a[i];
			a[i] = temp;
		}

	}

}
