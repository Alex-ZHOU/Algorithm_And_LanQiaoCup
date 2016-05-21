package main.lanqiaocup.hzu._20160521;

// a+b+c+e=100 这个方程组的解数 只考虑正整数的情况

public class _3 {
	public static void main(String[] args) {
		int total = 0;
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					if (i + j + k < 100) {
						total++;
					}
				}
			}
		}
		System.out.println(total);
	}

}
