package ohho;

import ohho.dao.UserDao;
import ohho.servlet.AddExtension;
import ohho.servlet.AddToken;
import ohho.servlet.AddUser;

public class Add_thread2 extends Thread{
	@Override
	public synchronized  void run() {
		// TODO Auto-generated method stub
		UserDao user_dao = new UserDao();
		AddUser add_user = new AddUser();
		AddToken add_token = new AddToken();
		AddExtension add_extension = new AddExtension();
		String cellphone = "12345678912";
		long cellphone_long = 1234567891 ;
		cellphone = user_dao.get_cellphone();
		if (cellphone != null){
			cellphone_long = Long.parseLong(cellphone);
		}
		
		long t1=System.currentTimeMillis();
		long number= 10000;
		for (int i=0;i<number;i++){
			if (cellphone != null){				
				cellphone_long = cellphone_long + 1;	
				System.out.println("线程2跑");
				int user_id = add_user.add_user(String.valueOf(cellphone_long));
				add_token.add_token(user_id);
				add_extension.add_extension(user_id);				
			}
		}
		long t2=System.currentTimeMillis();
		long t3 = t2 - t1;
		float t4 = t3 / 1000 /60;
		System.out.println("线程2执行时间");
		System.out.println(t3);
	}
}
