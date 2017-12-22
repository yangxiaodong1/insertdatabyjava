package ohho.servlet;
import java.util.UUID;

import ohho.dao.TokenDao;;
public class AddToken {
	public  void add_token(int user_id){
		TokenDao token_instance = new TokenDao();
		String token = UUID.randomUUID().toString().replaceAll("-", "");
		token_instance.insert_token(user_id, token);
	}
}
