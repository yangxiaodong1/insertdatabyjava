package ohho.mytest;

public class StudentDemo {
	public static void main(String[] args) {
		//创建资源
		Student s = new Student();
		
		//设置和获取的类
		SetThread st = new SetThread(s);
		GetThread gt = new GetThread(s);

		//线程类
		Thread t1 = new Thread(st);
		Thread t11 = new Thread(st);
		Thread t2 = new Thread(gt);
		Thread t22 = new Thread(gt);

		//启动线程
		t1.start();
		t11.start();
		t2.start();
		t22.start();
	}
}
