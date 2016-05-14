package main.lanqiaocup.hzu._20160514;

// 由曲线y=е^x,x=2,y=1围成的封闭图形的面积为?

public class _1 {
	public static void main(String[] args) {

		double e = 1, sum = 1;
		int i = 1;
		while (sum < Math.pow(10, 1000000)) {
			sum = i * sum;
			e = 1.0 / sum + e;
			i++;
		}

		System.out.println("e=" + e);

		System.out.println("Answer:" + ((Math.pow(e, 2) - 1) - 2));

	}
}
