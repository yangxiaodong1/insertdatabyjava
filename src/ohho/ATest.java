package ohho;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;
public class ATest {
	public static void main(String[] args) {
		long currentTime = new Date().getTime();
		System.out.println(currentTime);
		java.util.Calendar cal = java.util.Calendar.getInstance();
		
		System.out.println(cal);
		Date date_a = new Date();
		System.out.println(date_a);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(uuid);
		
	}
}
