package main.datastructures;

// 线段树

public class SegmentTree {

	private static class Node {
		int left;
		int right;
		int n;
	}

	private static Node node[] = new Node[100];

	private static void init(int left, int right, int i) {
		node[i] = new Node();
		node[i].left = left;
		node[i].right = right;
		if (left == right) {
			return;
		}
		int mid = (left + right) / 2;
		init(left, mid, i * 2);
		init(mid + 1, right, i * 2 + 1);
	}

	private static void insert(int i, int x, int num) {
		if (x >= node[i].left && x <= node[i].right) {
			node[i].n = num;
		}
		if (node[i].left == node[i].right) {
			return;
		}
		int mid = (node[i].left + node[i].right) / 2;
		if (x > mid) {
			insert(i * 2 + 1, x, num);
		} else {
			insert(i * 2, x, num);
		}

		node[i].n = node[2 * i].n > node[2 * i + 1].n ? node[2 * i].n : node[2 * i + 1].n;

	}

	public static void main(String[] args) {
		System.out.println("This is a SegmentTree");
		int a[] = { 1, 2, 3, 4 };
		init(1, a.length, 1);
		for (int i = 1; i <= a.length; i++) {
			insert(1, i, a[i - 1]);
		}

		for (int i = 4; i < a.length + 4; i++) {
			System.out.println(node[i].n);
		}
	}

}
