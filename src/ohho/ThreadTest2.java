package ohho;



public class ThreadTest2 {
	public static void main(String[] args) {
		long time1=System.currentTimeMillis();
		Thread t1 = new Add_thread2();
		Thread t2 = new Add_thread2();
//		Thread Add_thread = new Add_thread();
		t1.start();
//		t2.start();
		long time2=System.currentTimeMillis();
		long time3 = time2 -time1;
		System.out.println(time3);
		
	}
}
