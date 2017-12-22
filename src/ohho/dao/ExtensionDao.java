package ohho.dao;

import java.sql.Connection;
//import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ohho.tools.JdbcUntil;
import ohho.tools.RandomBirstday;

import com.mysql.jdbc.Statement;

public class ExtensionDao {
	public  void add_Extension(int user_id, int sex, Date birthday){
		Connection conn=JdbcUntil.getConnection();
		String sql="insert into ohho_user_accuracy_extension (user_id,sex,created_at,changed_at,timestamp,nickname,birthday,height,certification,able2match) values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, user_id);
			ps.setInt(2, sex);
			ps.setTimestamp(3,new Timestamp(new Date().getTime()));
			ps.setTimestamp(4,new Timestamp(new Date().getTime()));
			ps.setLong(5, new Date().getTime());
			ps.setString(6, "右右");
//			ps.setDate(7, birthday);
			ps.setTimestamp(7, new Timestamp(birthday.getTime()));
			ps.setFloat(8, 0);
			ps.setInt(9, 0);
			ps.setInt(10, 0);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUntil.close();
	}
	
	public  void add_Extension_new(List<Integer> list_user_id) throws SQLException{
		Connection conn=JdbcUntil.getConnection();
		String sql="insert into ohho_user_accuracy_extension (user_id,sex,created_at,changed_at,timestamp,nickname,birthday,height,certification,able2match) values(?,?,?,?,?,?,?,?,?,?)";
		conn.setAutoCommit(false);		
		try {
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			for (int i = 0; i < list_user_id.size(); i++) {
				
				RandomBirstday randomBirstday = new RandomBirstday();
				int[] sex_arr = {1,2,3};
				int index=(int)(Math.random()*sex_arr.length);
				int sex = sex_arr[index];
				Date random_birstday = randomBirstday.randomDate("1980-01-01", "2017-03-01");
				
				ps.setInt(1, list_user_id.get(i));
				ps.setInt(2, sex);
				ps.setTimestamp(3,new Timestamp(new Date().getTime()));
				ps.setTimestamp(4,new Timestamp(new Date().getTime()));
				ps.setLong(5, new Date().getTime());
				ps.setString(6, "右右");
				ps.setTimestamp(7, new Timestamp(random_birstday.getTime()));
				ps.setFloat(8, 0);
				ps.setInt(9, 0);
				ps.setInt(10, 0);
				ps.addBatch();
//				if (i % 1000 == 0){
//					ps.executeBatch();
//				}
				
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
