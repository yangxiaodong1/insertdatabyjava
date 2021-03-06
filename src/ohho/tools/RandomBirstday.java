package ohho.tools;


import java.text.SimpleDateFormat;  
import java.util.Date;  
  
public class RandomBirstday {  
  
    // 返回2007-01-01到2007-03-01的一个随机日期  
    public  void main(String[] args) {  
        Date randomDate = randomDate("1990-01-01", "2007-03-01");  
        System.out.println(randomDate.toString());
        System.out.println(randomDate.getTime());
    }  
  
  
    public  Date randomDate(String beginDate, String endDate) {  
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date start = format.parse(beginDate);// 构造开始日期  
            Date end = format.parse(endDate);// 构造结束日期  
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。  
            if (start.getTime() >= end.getTime()) {  
                return null;  
            }  
            long date = random(start.getTime(), end.getTime());  
  
            return new Date(date);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    public  long random(long begin, long end) {  
        long rtn = begin + (long) (Math.random() * (end - begin));  
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
        if (rtn == begin || rtn == end) {  
            return random(begin, end);  
        }  
        return rtn;  
    }  
  
}  