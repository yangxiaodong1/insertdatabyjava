package ohho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import ohho.tools.JdbcUntil;

import com.mysql.jdbc.Statement;

public class TokenDao {
public  void insert_token(int user_id,String token){
		
		Connection conn=JdbcUntil.getConnection();
		String sql="insert into ohho_user_token (user_id,token,created_at,changed_at,timestamp) values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, user_id);
			ps.setString(2, token);
			ps.setTimestamp(3,new Timestamp(new Date().getTime()));
			ps.setTimestamp(4,new Timestamp(new Date().getTime()));
			ps.setLong(5, new Date().getTime());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUntil.close();
		
		
	}
public void insert_token_new(List<Integer> list_user_id) throws SQLException{
	
	Connection conn=JdbcUntil.getConnection();
	String sql="insert into ohho_user_token (user_id,token,created_at,changed_at,timestamp) values(?,?,?,?,?)";
	
	conn.setAutoCommit(false);
	try {
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
//		System.out.println("进来大小"+list_user_id.size());
		for (int i = 0; i < list_user_id.size(); i++) {
			String token = UUID.randomUUID().toString().replaceAll("-", "");
			ps.setInt(1, list_user_id.get(i));
			ps.setString(2, token);
			ps.setTimestamp(3,new Timestamp(new Date().getTime()));
			ps.setTimestamp(4,new Timestamp(new Date().getTime()));
			ps.setLong(5, new Date().getTime());
			ps.addBatch();
//			if (i % 1000 == 0){
//				ps.executeBatch();
//			}
//			System.out.println("进来了多少次");
		}		
		ps.executeBatch();
		conn.commit();
		ps.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	JdbcUntil.close();
	
}
}
