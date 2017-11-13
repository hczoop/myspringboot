package com.example.demo.guava;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * joda-time时间工具类
 * 1 、 DateTime
 最常用的一个类，处理时间日期功能最全，以毫
 秒及精度封装时间上的某个瞬间时刻，包含日期和时
 间、时区，类似于 java.util.Clendar 。
 2 、 LocalDate
 – 只包含日期部分信息，专注于日期方面的处
 理，类似 java.util.Date ，没有时区概念。
 */
public class TimeTest {

    public static DateTimeFormatter fmts = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");//自定义日期格式

    public static void main(String[] args) {
        System.out.println(comparison());
        base();
    }

    public static   void base(){
        DateTime in = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");//自定义日期格式
        System.out.println(in.now().toString(fmt));
        System.out.println(in.now());  //国际标准时间
        System.out.println(in.getYear()); //当年
        System.out.println(in.getMonthOfYear()); //当月
        System.out.println(in.getDayOfMonth());  //当月第几天
        System.out.println(in.getDayOfWeek());//本周第几天
        System.out.println(in.getDayOfYear());//本年第几天
        System.out.println(in.plusDays(10));// 增加天
        System.out.println(in.getHourOfDay());//时
        System.out.println(in.getMinuteOfHour());//分
        System.out.println(in.getMinuteOfDay());//当天第几分钟
        System.out.println(in.getSecondOfMinute());//秒
        System.out.println(in.getSecondOfDay());//当天第几秒
        System.out.println(in.getWeekOfWeekyear());//本年第几周
        System.out.println(in.getZone());//所在时区
        System.out.println(in.dayOfWeek().getAsText()); //当天是星期几，例如：星期五
        System.out.println(in.yearOfEra().isLeap()); //当你是不是闰年，返回boolean值
        System.out.println(in.dayOfMonth().getMaximumValue());//当月day里面最大的值
    }


    //计算两个日期的相隔天数
    public static int comparisonDate(){
        DateTime nowTime = new DateTime();
        DateTime futureTime = new DateTime(2017, 7, 10, 0, 0, 0);
        return Days.daysBetween(nowTime, futureTime).getDays();
    }

    //计算两个日期的相隔天数
    public static int comparison(){
        LocalDate start=new LocalDate(2017, 12,14);
        LocalDate end=new LocalDate(2017, 12, 15);
        return Days.daysBetween(start, end).getDays();
    }


    public static void getData(){
        DateTime nowTime = new DateTime();
        //获取今天的开始时间：比如：2014-06-19 00:00:00
        DateTime startOfDay =  nowTime.withTimeAtStartOfDay();
        System.out.println(startOfDay);
        //获取今天的结束时间：比如：2014-06-19 23:59:59
        DateTime endOfDay =  nowTime.millisOfDay().withMaximumValue();
        System.out.println("endOfDay="+endOfDay);
        //获取现在距离今天结束还有多长时间
        long time = endOfDay.getMillis() - nowTime.getMillis();
        System.out.println(time);
    }

    //日期比较
    public  void comTo(){
        DateTime in = new DateTime();
        DateTime in2 = new DateTime(in.getMillis() + 10);
        in.equals(in2);  //false
        in.compareTo(in2); //-1
        in.isEqual(in2); //false
        in.isAfter(in2); //false
        in.isBefore(in2);//true
    }

    //与JDK互操作
    public void tojdkdata(){
        Date date = new Date();//通过jdk时间对象构造
        DateTime dateTime = new DateTime(date);

        Calendar calendar = Calendar.getInstance();
        dateTime = new DateTime(calendar);

        // Joda-time 各种操作.....
        dateTime = dateTime.plusDays(1) // 增加天
                .plusYears(1)// 增加年
                .plusMonths(1)// 增加月
                .plusWeeks(1)// 增加星期
                .minusMillis(1)// 减分钟
                .minusHours(1)// 减小时
                .minusSeconds(1);// 减秒数

        // 计算完转换成jdk 对象
        Date date2 = dateTime.toDate();
        Calendar calendar2 = dateTime.toCalendar(Locale.CHINA);
    }

}
