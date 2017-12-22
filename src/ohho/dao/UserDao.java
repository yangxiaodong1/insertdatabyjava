package ohho.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ohho.tools.JdbcUntil;

import java.util.UUID;

import com.mysql.jdbc.Statement;
public class UserDao {
	public  int insert_user(String username,String password,String cellphone, int country_code_id){
		
		Connection conn=JdbcUntil.getConnection();
		String sql="insert into ohho_user (username,password,cellphone,country_code_id,created_at,changed_at,timestamp,state) values(?,?,?,?,?,?,?,?)";
		ResultSet rs = null; 
		int id = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, cellphone);
			ps.setInt(4, country_code_id);
			ps.setTimestamp(5,new Timestamp(new Date().getTime()));
			ps.setTimestamp(6,new Timestamp(new Date().getTime()));
			ps.setLong(7, new Date().getTime());
			ps.setInt(8, 1);
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
	        if (rs.next()) {
	            id = rs.getInt(1); 
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUntil.close();
//		System.out.println(id);
		return id;
	}
	
public  List<Integer> insert_user_new(long number) throws SQLException{
		
		UserDao user_dao = new UserDao();
		List<Integer> user_id_list = new ArrayList<Integer>();
		
		String password = "1411678a0b9e25ee2f7c8b2f7ac92b6a74b3f9c5";	
		int country_code_id = 159;		
		String cellphone = "12345678912";
		long cellphone_long = 1234567891 ;
		cellphone = user_dao.get_cellphone();
		if (cellphone != null){
			cellphone_long = Long.parseLong(cellphone);
		}
		
		
		Connection conn=JdbcUntil.getConnection();
		String sql="insert into ohho_user (username,password,cellphone,country_code_id,created_at,changed_at,timestamp,state) values(?,?,?,?,?,?,?,?)";
		int id = 1;
		conn.setAutoCommit(false);
		try {
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			for (int i = 0; i < number; i++) {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");		
				String username = uuid;
				cellphone_long = cellphone_long + 1;
				
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, String.valueOf(cellphone_long));
				ps.setInt(4, country_code_id);
				ps.setTimestamp(5,new Timestamp(new Date().getTime()));
				ps.setTimestamp(6,new Timestamp(new Date().getTime()));
				ps.setLong(7, new Date().getTime());
				ps.setInt(8, 1);
				ps.addBatch();
//				if (i % 1000 == 0){
//					ps.executeBatch();
//				}
//				System.out.println("怎么回事"+ i);
			}		
			ps.executeBatch();
			conn.commit();
			
			ResultSet rs = ps.getGeneratedKeys() ;
	        while (rs.next()) {
	            id = rs.getInt(1);
//	            System.out.println("回去id"+ id);
	            user_id_list.add(id);
	        }
	        
	        ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUntil.close();
//		System.out.println("插入后"+user_id_list.size());
		return user_id_list;
	}
	

	public  String get_cellphone(){
		Connection conn=JdbcUntil.getConnection();
		String sql="SELECT cellphone FROM ohho_user where id in (SELECT MAX(id) from ohho_user)";
		String cellphone = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				cellphone = rs.getString("cellphone");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUntil.close();
//		System.out.println(cellphone);
		return cellphone;
		
	}
	
	public static void main(String[] args) throws Exception {
//		Date date_a = new Date();
//		System.out.println(date_a);
//		SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
//		Date date_sql = df.parse(df.format(new Date()));
////		new Timestamp(date_sql);
//		
//		new Timestamp(new Date().getTime());
////		System.out.println(new Timestamp(new Date().getTime().getTiem()));
//		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//		UserDao user = new UserDao();
//		
//		String username = uuid;
//		String password = "1411678a0b9e25ee2f7c8b2f7ac92b6a74b3f9c5";
//		String cellphone = "12121212122";
//		int country_code_id = 159;
//		
//		user.insert_user(username, password, cellphone, country_code_id);
		UserDao user = new UserDao();
		String a = user.get_cellphone();
		System.out.println(a);
	}

}
