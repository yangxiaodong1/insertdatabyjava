package ohho.mytest2;

import ohho.dao.UserDao;
import ohho.servlet.AddExtension;
import ohho.servlet.AddToken;
import ohho.servlet.AddUser;

public class SetThread2 implements Runnable{
	private CellphoneUser c;
	private int x = 0;
	private UserDao user_dao;
	private AddUser add_user;
	private AddToken add_token;
	private AddExtension add_extension;
	
	private long time1;
	
	
	public SetThread2(CellphoneUser c) {
		// TODO Auto-generated constructor stub
		this.c = c;
		this.user_dao = new UserDao();
		this.add_user = new AddUser();
		this.add_token = new AddToken();
		this.add_extension = new AddExtension();
	}
	@Override
	public void run() {
		long t1=System.currentTimeMillis();				
		// TODO Auto-generated method stub
		while (x<5000){
			synchronized (c) {
				long cellphone_long = Long.parseLong(c.cellphone) + 1;
				c.cellphone = String.valueOf(cellphone_long);
				
				int user_id = add_user.add_user(String.valueOf(cellphone_long));
				add_token.add_token(user_id);
				add_extension.add_extension(user_id);
				
				System.out.println(c.cellphone);
				x++;
				System.out.println(Thread.currentThread().getName());
			}
		}
		long t2=System.currentTimeMillis();
		
		System.out.println("time");
		
		System.out.println(t2 - t1);
	}

}
