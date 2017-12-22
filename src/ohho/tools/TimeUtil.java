package ohho.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {
	// ȡ�ñ���ʱ�䣺
    private Calendar cal = Calendar.getInstance();
    // ȡ��ʱ��ƫ������
    private int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
    // ȡ������ʱ�
    private int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);

    public static void main(String[] args) {
    	TimeUtil gc = new TimeUtil();
        long mill = gc.getUTCTimeStr();
        gc.setUTCTime(mill);

    }

    public long getUTCTimeStr() {

        System.out.println("local millis = " + cal.getTimeInMillis()); // ��ЧSystem.currentTimeMillis() , ͳһֵ������ʱ��

        // �ӱ���ʱ����۳���Щ������������ȡ��UTCʱ�䣺
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));

        long mills = cal.getTimeInMillis();
        System.out.println("UTC = " + mills);

        return mills;
    }

    public void setUTCTime(long millis) {

        cal.setTimeInMillis(millis);

        SimpleDateFormat foo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = foo.format(cal.getTime());
        System.out.println("GMT time= " + time);

        // �ӱ���ʱ����۳���Щ������������ȡ��UTCʱ�䣺
        cal.add(java.util.Calendar.MILLISECOND, (zoneOffset + dstOffset));
        time = foo.format(cal.getTime());
        System.out.println("Local time = " + time);

    }

    public void getGMTTime() {
        //mothed 2
        TimeZone gmtTime = TimeZone.getTimeZone("GMT");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(gmtTime);
        System.out.println("GMT Time: " + format.format(date));
        
        //method 2
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeZone(gmtTime);
        //System.out.println(calendar1.getTime());    //ʱ����Ч
        //System.out.println(calendar1.getTimeInMillis()); //ʱ����Ч
        System.out.println("GMT hour = " + calendar1.get(Calendar.HOUR));
    }
}
