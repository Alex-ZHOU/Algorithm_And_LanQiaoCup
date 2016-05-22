package main.lanqiaocup.hzu._20160521;

import java.util.Scanner;

public class _8 {

	private static int a[] = new int[4];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		paixu(0);
		System.out.println(total);
	}

	private static int total = 0;

	private static void paixu(int k) {
		// System.out.println("k: " + k);
		if (k == 3) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			total++;
			System.out.println();
			// return;
		}

		for (int i = k; i <= 4 - 1; i++) {
			// swap
			int temp = a[k];
			a[k] = a[i];
			a[i] = temp;

			paixu(k + 1);

			// swap
			temp = a[k];
			a[k] = a[i];
			a[i] = temp;
		}

	}

}
