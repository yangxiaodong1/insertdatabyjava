package ohho;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ohho.dao.ExtensionDao;
import ohho.dao.TokenDao;
import ohho.dao.UserDao;
import ohho.servlet.AddUser;
import ohho.servlet.AddToken;
import ohho.servlet.AddExtension;
import ohho.dao.UserDao;
public class ATestnew {
	public static void main(String[] args) throws SQLException {
		UserDao user_dao = new UserDao();
		TokenDao token_dao = new TokenDao();
		ExtensionDao extension_dao = new ExtensionDao();		
		long t1=System.currentTimeMillis();
		
		long number= 500000;
		
		List<Integer> list = new ArrayList<Integer>();
		list = user_dao.insert_user_new(number);
		System.out.println("list" + list.size());
		token_dao.insert_token_new(list);
		extension_dao.add_Extension_new(list);
		long t2=System.currentTimeMillis();
		long t3 = t2 - t1;
		double t4 = t3 / 1000 /60;
		System.out.println("直接执行时间(毫秒)" + t3);
//		System.out.println("花费时间（分钟）："+ t4);
	}
}
