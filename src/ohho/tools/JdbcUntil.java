package ohho.tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class JdbcUntil {
//
//	public static final String url = "jdbc:mysql://localhost:3306/ohho?useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true";  
//    public static final String name = "com.mysql.jdbc.Driver";  
//    public static final String user = "root";  
//    public static final String password = "111111";  
  
	public static final String url = "jdbc:mysql://192.168.253.16:3306/ohho?useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "test";  
    public static final String password = "123456";
    
    public static Connection conn = null;  
     
    
    public  static Connection getConnection(){
   	 try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接
//            System.out.println("连接了");
          return conn;
        } catch (Exception e) {  
       	 throw new RuntimeException("链接错误");
           // e.printStackTrace();  
        }  
   }
  
    public  static void close() {  
        try {  
            
        	conn.close();  
//           System.out.println("关闭了吗");
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
       Connection c=JdbcUntil.getConnection();//接受返回的对象，connection相当于一个接口
       if(c!=null){
    	   System.out.println("链接数据库成功");
       }
	}
	
}

