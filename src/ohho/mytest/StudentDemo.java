package ohho.mytest;

public class StudentDemo {
	public static void main(String[] args) {
		//������Դ
		Student s = new Student();
		
		//���úͻ�ȡ����
		SetThread st = new SetThread(s);
		GetThread gt = new GetThread(s);

		//�߳���
		Thread t1 = new Thread(st);
		Thread t11 = new Thread(st);
		Thread t2 = new Thread(gt);
		Thread t22 = new Thread(gt);

		//�����߳�
		t1.start();
		t11.start();
		t2.start();
		t22.start();
	}
}
