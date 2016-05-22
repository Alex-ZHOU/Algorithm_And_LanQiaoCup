package main.lanqiaocup.hzu._20160522;

///*
// * 题目描述金明今天很开心，家里购置的新房就要领钥匙了，新房里有一间
// * 他自己专用的很宽敞的房间。更让他高兴的是，妈妈昨天对他说：“你的房
// * 间需要购买哪些物品，怎么布置，你说了算，只要不超过N 元钱就行”。今
// * 天一早金明就开始做预算，但是他想买的东西太多了，肯定会超过妈妈限定
// * 的N 元。于是，他把每件物品规定了一个重要度，分为5 等：用整数1~5 
// * 表示，第5 等最重要。他还从因特网上查到了每件物品的价格（都是整数
// * 元）。他希望在不超过N 元（可以等于N 元）的前提下，使每件物品的价
// * 格与重要度的乘积的总和最大。设第j 件物品的价格为v[j]，重要度为w[j]，
// * 共选中了k 件物品，编号依次为j1...jk，则所求的总和为：v[j1]*w[j1]+..+v[jk]*w[jk]
// * 请你帮助金明设计一个满足要求的购物单.
// * 
// * 输入格式
// * 输入的第1 行，为两个正整数，用一个空格隔开：
// * N m
// * （其中N（<30000）表示总钱数，m(<25)为希望购买物品的个数。）从第2
// * 行到第m+1 行，第j 行给出了编号为j-1的物品的基本数据，每行有2 个非
// * 负整数v p（其中v 表示该物品的价格（v≤10000），p 表示该物品的重要
// * 度（1~5））
// * 输出格式
// * 输出只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的
// * 最大值（<100000000）
// * 
// * 样例输入 
// * 1000 5
// * 800 2
// * 400 5
// * 300 5
// * 400 3
// * 200 2
// * 样例输出 
// * 3900
// */
import java.util.Scanner;

public class _6 {
	private static int N;
	private static int m;
	private static int a[][] = new int[10000][2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();

		System.out.println(select(0, 0, 0));

	}

	private static int select(int money, int value, int i) {

		int thisvalue = a[i][0] * a[i][1];

		if (i == m) {
			thisvalue = 0;
		} else if (money + a[i][0] > N) {
			value = select(money, value, i + 1);
		} else {
			value = select(money, value, i + 1) > select(money + a[i][0], value + thisvalue, i + 1)
					? select(money, value, i + 1) : select(money + a[i][0], value + thisvalue, i + 1);
		}

		return value;
	}

}
