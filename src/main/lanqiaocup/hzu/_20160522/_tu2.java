package main.lanqiaocup.hzu._20160522;

import java.util.Scanner;

///*
// * 给定程序中，函数fun的功能是：将NxN矩阵主对角线元素中
// * 的值与反对角线对应位置上元素的值进行交换。例如：若N＝3，
// * 有下列矩阵：
// * 1 2 3 
// * 4 5 6 
// * 7 8 9
// * 交换后为：
// * 3 2 1 
// * 4 5 6 
// * 9 8 7 
// */
public class _tu2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[][] = new int[N][N];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();

		for (int i = 0; i < N; i++) {
			// System.out.println(a[i][i] + " " + a[N - i - 1][N - i - 1] + " "
			// + i);
			int temp = a[i][i];
			a[i][i] = a[i][N - i - 1];
			a[i][N - i - 1] = temp;
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

	}
}