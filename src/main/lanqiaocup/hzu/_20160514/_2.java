package main.lanqiaocup.hzu._20160514;

// 将数字1，2，3，4填入标号为1.2.3.4的四个方格，每格填一个数，则每个方格的
// 标号与所填数字均不相同的填法有多少种。
public class _2 {
	private static int ans = 0;

	public static void main(String[] args) {
		baoli();
		System.out.println(ans);
	}

	private static void baoli() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				for (int j2 = 1; j2 < 5; j2++) {
					for (int k = 1; k < 5; k++) {
						if (i != j && i != j2 && i != k && j != j2 && j != k && j2 != k) {
							// 判断下标与数字不相等
							if (i != 1 && j != 2 && j2 != 3 && k != 4) {
								System.out.println(i + " " + j + " " + j2 + " " + k);
								ans++;
							}
						}
					}
				}
			}
		}
	}

}
