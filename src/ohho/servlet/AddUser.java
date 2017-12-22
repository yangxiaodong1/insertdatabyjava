package ohho.servlet;

import ohho.dao.UserDao;

import java.util.UUID;
//import ohho.dao.UserDao;
public class AddUser {
	public  int add_user(String cellphone){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		UserDao user_obj = new UserDao();
		String username = uuid;
		String password = "1411678a0b9e25ee2f7c8b2f7ac92b6a74b3f9c5";
//		String cellphone = "12121212124";
		int country_code_id = 159;			
		int user_id = user_obj.insert_user(username, password, cellphone, country_code_id);
		return user_id ;
	}
	
//	public static void main(String[] args) {
//		AddUser u =new AddUser();
//		u.add_user("12121212109");
//	}

}
