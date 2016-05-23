package main.lanqiaocup.hzu._20160522;

import java.util.Arrays;
import java.util.Scanner;

///*
// * 给定程序中，在函数fun的功能是：计算x所指数组中N个数
// * 的平均值（规定所有数均为正常），平均值通过参数返回主
// * 函数，将小于平均值且最接近平均值的数作为函数值返回，
// * 在主函数中输出：
// * 例如：在10个正数：46、30、32、40、6、17、45、15、
// * 48、26，平均值为：30.500000
// * 主函数中输出：m＝30
// */
public class _tu4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[] = new int[N];
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
		sc.close();
		float ave = sum / N;

		System.out.println(ave);
		Arrays.sort(a);

		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] <= ave) {
				System.out.println(a[i]);
				break;
			}
		}

	}
}
