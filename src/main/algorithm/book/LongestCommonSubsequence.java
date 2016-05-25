package main.algorithm.book;

///*
// * 最长公共子序列问题
// * 
// * 给定两个字符串s1s2...sn和t1t2...tn。求出这两个字符串最长的公共
// * 子序列长度。字符串s1s2...sn的自序列指可以表示为si1si2...sin(i1<i2<...<im)
// * 的序列
// * 
// * 限制条件
// * 1<=n,m<=1000
// */
public class LongestCommonSubsequence {
	public static void main(String[] args) {
		int n = 4;
		int m = 4;
		char s[] = { 'a', 'b', 'c', 'd' };
		char t[] = { 'b', 'e', 'c', 'd' };
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < t.length; j++) {
				if (s[i] == t[j]) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
