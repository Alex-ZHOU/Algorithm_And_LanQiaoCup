package main.lanqiaocup.hzu._20160522;

import java.util.Arrays;
import java.util.Scanner;

///*
// * 给定程序中，在函数fun的功能是将不带头的单向
// * 结点的单向链表数据域中的数据从小到大排序。即
// * 若原链表结点数据域从头到尾到数据尾：10、4、
// * 2、8、6，排序后链表结点数据域从头到尾到数据
// * 为：2、4、6、8、10。 
// */
public class _tu3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		Arrays.sort(a);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}
}
