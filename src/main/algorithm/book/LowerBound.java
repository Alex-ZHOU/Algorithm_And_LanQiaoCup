package main.algorithm.book;

///**
// * 从有序数组中查找某个值
// * 
// * 给定长度为n的单调不下降数列a0...an和一个数k，求满足ai>=k 条件的最小的i。不存在的情况下输出n。
// * 
// * 限制条件 1<=n<=10^6 0<=a0<=...<=an-1<10^9 0<=k<=10^9
// * 
// * 解法 二分搜索
// * 
// * @author Alex
// *
// */
public class LowerBound {
	public static void main(String[] args) {

		// 输入
		int n = 5;
		int a[] = { 2, 3, 3, 5, 6 };
		int k = 3;

		solve(n, a, k);

	}

	private static void solve(int n, int a[], int k) {
		// 设置解的范围
		int lb = -1;
		int ub = n;
		
		// 直到解存在的范围不大于1
		while (ub - lb > 1) {

			int mid = (lb + ub) / 2;

			if (a[mid] >= k) {
				// 解的范围（lb,mid）
				ub = mid;
			} else {
				// 解的范围（mid,ub）
				lb = mid;
			}

		}

		// 输出结果，此时lb＋1=ub
		System.out.println(ub);

	}
}
