package ohho.mytest2;

import ohho.dao.UserDao;

public class CellphoneUserDemo {
	public static void main(String[] args) {
		UserDao user_dao = new UserDao();
		String cellphone = user_dao.get_cellphone();
		CellphoneUser cel = new CellphoneUser() ;
		cel.cellphone = cellphone;
//		cel.cellphone = "100";
		SetThread st = new SetThread(cel);
		SetThread st2 = new SetThread(cel);
		SetThread st3 = new SetThread(cel);
		SetThread st4 = new SetThread(cel);

		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st2);
		Thread t3 = new Thread(st3);
		Thread t4 = new Thread(st4);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
//		System.out.println("jieshu");
		
	}
}
