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
            Class.forName(name);//ָ����������  
            conn = DriverManager.getConnection(url, user, password);//��ȡ����
//            System.out.println("������");
          return conn;
        } catch (Exception e) {  
       	 throw new RuntimeException("���Ӵ���");
           // e.printStackTrace();  
        }  
   }
  
    public  static void close() {  
        try {  
            
        	conn.close();  
//           System.out.println("�ر�����");
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
       Connection c=JdbcUntil.getConnection();//���ܷ��صĶ���connection�൱��һ���ӿ�
       if(c!=null){
    	   System.out.println("�������ݿ�ɹ�");
       }
	}
	
}

