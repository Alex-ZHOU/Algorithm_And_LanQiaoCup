package main.lanqiaocup.hzu._20160522;

//一百个元宝买了一百只鸡，其中公鸡2只10钱、母鸡4只12钱，小鸡2钱6只
//问一百只鸡中公鸡、母鸡、小鸡各多少？请补充缺少的代码。
//for(int cock=0; cock<=100; cock++)
//
//{
//
//for(int hen=0; hen<=100; hen++)
//
//{
//
//int chicken = 100 – cock – hen;
//
//if(chicken % 3 != 0) ________________;
//
//if(_________________________)
//
//System.out.println(“cock=” + cock + “,hen=” + hen + “,chicken=” + chicken);
//
//}
//
//}
public class _2 {
	public static void main(String[] args) {
		for (int cock = 0; cock <= 100; cock++) {

			for (int hen = 0; hen <= 100; hen++) {

				int chicken = 100 - cock - hen;

				if (chicken % 3 != 0) {
					continue;
				}

				if (chicken / 3 + cock * 5 + hen * 3 == 100)
					System.out.println("cock=" + cock + ",hen=" + hen + ",chicken=" + chicken);

			}
		}
	}
}
