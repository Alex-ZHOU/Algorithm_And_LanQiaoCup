package main.lanqiaocup.hzu._20160522;

//圆周率的计算变得十分容易了。其中比较常用且易于编程的是无穷级数法。
//π/4 = 1 – 1/3 + 1/5 – 1/7 + 1/9 - …
//是初学者特别喜欢的一个级数形式，但其缺点是收敛太慢。
//π/2 = 1 + 1/3 +1/3*2/5 + 1/3*2/5*3/7 + 1/3*2/5*3/7*4/9 + …
//是收敛很快的一个级数方法。下面的代码演示了用这种方法计算π值。
//    double x = 1;
//    double y = 1;
//    int a = 1;
//    int b = 3;
//   
//    while(y>1e-15)
//    {
//        y = __________;
//        x += y;
//        a++;
//        __________;
//    }
//   
//    System.out.println(__________);
public class _4 {
	public static void main(String[] args) {
		double x = 1;
		double y = 1;
		int a = 1;
		int b = 3;

		while (y > 1e-15) {
			y = y * a / b;
			x += y;
			a++;
			b += 2;
		}

		System.out.println(x * 2);
	}
}
