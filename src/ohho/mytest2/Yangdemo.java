package ohho.mytest2;

public class Yangdemo {
	public static void main(String[] args) {
		YangThread yt = new YangThread();
		
		for (int i=0;i<10000;i++){
			System.out.println("yang: " + i);
		}
		Thread t = new Thread(yt);
		t.start();
		
		for (int i=0;i<100;i++){
			System.out.println("dong: " + i);
		}
	}
}
