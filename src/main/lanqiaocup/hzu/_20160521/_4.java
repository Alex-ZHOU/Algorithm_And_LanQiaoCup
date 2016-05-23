package main.lanqiaocup.hzu._20160521;

import java.util.Scanner;

///*
// * 敌兵布阵
// * 
// * Time Limit: 1000MS
// * Memory Limit: 32768KB
// * 64bit IO Format: %I64d & %I64u
// * 
// * Description
// * C国的死对头A国这段时间正在进行军事演习，所以C国间谍头子Derek和他手下Tidy又开始忙乎了。
// * A国在海岸线沿直线布置了N个工兵营地,Derek和Tidy的任务就是要监视这些工兵营地的活动情况。
// * 由于采取了某种先进的监测手段，所以每个工兵营地的人数C国都掌握的一清二楚,每个工兵营地的人
// * 数都有可能发生变动，可能增加或减少若干人手,但这些都逃不过C国的监视。
// * 中央情报局要研究敌人究竟演习什么战术,所以Tidy要随时向Derek汇报某一段连续的工兵营地一共
// * 有多少人,例如Derek问:“Tidy,马上汇报第3个营地到第10个营地共有多少人!”Tidy就要马上开
// * 始计算这一段的总人数并汇报。但敌兵营地的人数经常变动，而Derek每次询问的段都不一样，所以
// * Tidy不得不每次都一个一个营地的去数，很快就精疲力尽了，Derek对Tidy的计算速度越来越不满:
// * "你个死肥仔，算得这么慢，我炒你鱿鱼!”Tidy想：“你自己来算算看，这可真是一项累人的工作!我
// * 恨不得你炒我鱿鱼呢!”无奈之下，Tidy只好打电话向计算机专家Windbreaker求救,
// * Windbreaker说：“死肥仔，叫你平时做多点acm题和看多点算法书，现在尝到苦果了吧!”Tidy说：
// * "我知错了。。。"但Windbreaker已经挂掉电话了。Tidy很苦恼，这么算他真的会崩溃的，聪明的
// * 读者，你能写个程序帮他完成这项工作吗？不过如果你的程序效率不够高的话，Tidy还是会受到
// * Derek的责骂的. 
// * 
// * Input
// * 第一行一个整数T，表示有T组数据。 
// * 每组数据第一行一个正整数N（N<=50000）,表示敌人有N个工兵营地，接下来有N个正整数,第i个正
// * 整数ai代表第i个工兵营地里开始时有ai个人（1<=ai<=50）。 
// * 接下来每行有一条命令，命令有4种形式： 
// * (1) Add i j,i和j为正整数,表示第i个营地增加j个人（j不超过30） 
// * (2)Sub i j ,i和j为正整数,表示第i个营地减少j个人（j不超过30）; 
// * (3)Query i j ,i和j为正整数,i<=j，表示询问第i到第j个营地的总人数; 
// * (4)End 表示结束，这条命令在每组数据最后出现; 
// * 每组数据最多有40000条命令 
// * Output
// * 对第i组数据,首先输出“Case i:”和回车, 
// * 对于每个Query询问，输出一个整数并回车,表示询问的段中的总人数,这个数保持在int以内。 
// * 
// * Sample Input
// * 1101 2 3 4 5 6 7 8 9 10
// * Query 1 3
// * Add 3 6
// * Query 2 7
// * Sub 10 2
// * Add 6 3
// * Query 3 10
// * End 
// * Sample Output
// * Case 1:
// * 6
// * 33
// * 59 
// */
public class _4 {

	private static class Node {
		int l = 0;
		int r = 0;
		int num = 0;
	}

	private static Node mNode[] = new Node[500000];

	public static void main(String[] args) {
		for (int l = 0; l < mNode.length; l++) {
			mNode[l] = new Node();
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N[] = new int[T];

		for (int k = 0; k < T; k++) {
			N[k] = sc.nextInt();

			// 初始化线段树
			init(1, N[k], 1);
			// 打印初始化的树
			// System.out.println();
			// for (int l = 0; l < mNode.length; l++) {
			// if (mNode[l].l != 0) {
			// System.out.println("node:" + l + " " + mNode[l].l + " " +
			// mNode[l].r);
			// }
			// }

			System.out.println();
			System.out.println("Case " + (k + 1) + ":");

			int a[] = new int[N[k]];

			for (int l = 0; l < a.length; l++) {
				a[l] = sc.nextInt();
				// System.out.print(a[l] + " ");
				add(1, l + 1, a[l]);
			}
			// 插入值之后监测
			// System.out.println();
			// for (int l = 0; l < mNode.length; l++) {
			// if (mNode[l].l == mNode[l].r && mNode[l].num != 0) {
			// System.out.println("node:" + l + " " + mNode[l].num);
			// }
			// }
			String str = "";
			while (true) {
				str = sc.nextLine();
				if (str.equals("")) {
					continue;
				}
				if (str.equals("End ")) {
					// System.out.println("break");
					break;
				}
				// System.out.println(str);
				String strArray[] = str.split(" ");
				int i = Integer.parseInt(strArray[1]);
				int j = Integer.parseInt(strArray[2]);

				switch (strArray[0]) {
				case "Query":

					System.out.println(query(1, i, j));
					break;
				case "Add":
					add(1, i, j);
					break;
				case "Sub":
					add(1, i, -j);
					break;
				}
				// for (int l = 0; l < mNode.length; l++) {
				// if (mNode[l].l == mNode[l].r && mNode[l].num != 0) {
				// System.out.println("node:" + l + " " + mNode[l].num);
				// }
				// }
			}

		}
		sc.close();
	}

	private static int query(int local, int i, int j) {
		int sum = 0;
		int l = mNode[local].l;
		int r = mNode[local].r;

		if (l == i && r == j) {
			return mNode[local].num;
		}

		int mid = (l + r) / 2;

		if (j <= mid) {
			return query(local * 2, i, j);
		}
		if (i > mid) {
			return query(local * 2 + 1, i, j);
		}

		sum = query(local * 2, i, mid) + query(local * 2 + 1, mid + 1, j);

		return sum;
	}

	private static void add(int local, int i, int num) {
		int l = mNode[local].l;
		int r = mNode[local].r;

		if (l == r) {
			mNode[local].num += num;
			return;
		}

		if (l <= i && i <= r) {

			int mid = (l + r) / 2;

			if (i <= mid) {
				add(local * 2, i, num);
			} else {
				add(local * 2 + 1, i, num);
			}

			mNode[local].num = mNode[local * 2].num + mNode[local * 2 + 1].num;
		}
	}

	private static void init(int l, int r, int i) {
		if (l == r) {
			mNode[i].l = l;
			mNode[i].r = r;
			return;
		}

		int mid = (l + r) / 2;

		init(l, mid, i * 2);
		init(mid + 1, r, i * 2 + 1);

		mNode[i] = new Node();
		mNode[i].l = l;
		mNode[i].r = r;

	}
}
