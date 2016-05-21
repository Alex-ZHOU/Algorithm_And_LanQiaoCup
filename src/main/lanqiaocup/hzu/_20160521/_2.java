package main.lanqiaocup.hzu._20160521;

// 10名军人分成3队,其中一队4人,?另两队3人但正副军长不能分在同一组,有多少种不同的分组方法

public class _2 {
	public static void main(String[] args) {
		int C83 = 56;
		int C52 = 10;
		int C84 = 70;
		int C42 = 6;
		System.out.println(C83 * C52 * 2 + C84 * C42);
	}
}
