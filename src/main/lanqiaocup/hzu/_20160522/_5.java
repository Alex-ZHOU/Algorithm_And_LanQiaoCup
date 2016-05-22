package main.lanqiaocup.hzu._20160522;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

///*
// * 题目描述
// * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
// * 他先用计算机生成了N个1到1000之间的随机整数（N≤100），对于其
// * 中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不
// * 同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找
// * 同学做调查。请你协助明明完成“去重”与“排序”的工作。
// * 
// * 输入格式
// * 输入有2行，第1行为1个正整数，表示所生成的随机数的个数：
// * N
// * 第2行有N个用空格隔开的正整数，为所产生的随机数。
// * 输出格式
// * 输出也是2行，第1行为1个正整数M，表示不相同的随机数的个数。第2行
// * 为M个用空格隔开的正整数，为从小到大排好序的不相同的随机数。
// * 样例输入 
// * 10
// * 20 40 32 67 40 20 89 300 400 15
// * 样例输出 
// * 8
// * 15 20 32 40 67 89 300 400
// */
public class _5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			// list.add(sc.nextInt());
		}
		sc.close();
		Arrays.sort(a);
		list.add(a[0]);
		for (int i = 1; i < a.length; i++) {
			if (a[i] == list.get(list.size() - 1)) {
				continue;
			} else {
				list.add(a[i]);
			}
		}

		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}
}
