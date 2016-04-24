package com.wz.lanyue.banke.util;

import android.support.annotation.NonNull;
import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by BANBEICHAS on 2016/3/30.
 */
public class DateUtil {
//	"created_at": "Wed Jun 17 14:26:24 +0800 2015"

  public static final long ONE_MINUTE_MILLIONS = 60 * 1000;
  public static final long ONE_HOUR_MILLIONS = 60 * ONE_MINUTE_MILLIONS;
  public static final long ONE_DAY_MILLIONS = 24 * ONE_HOUR_MILLIONS;
  public static String getDate( String dateStr){

    String str = "";
    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
    str = getString(dateStr, str, sdf);

    return str;
  }

  @NonNull
  private static String getString(String dateStr, String str, SimpleDateFormat sdf) {
    try {
      Date date = sdf.parse(dateStr);
      Date curDate = new Date();

      long durTime = curDate.getTime() - date.getTime();
      int dayStatus = calculateDayStatus(date, curDate);

      if(durTime <= 3 * ONE_MINUTE_MILLIONS) {
        str = "刚刚";
      } else if(durTime < ONE_HOUR_MILLIONS) {
        str = durTime / ONE_MINUTE_MILLIONS + "分钟前";
      } else if(dayStatus == 0) {
        str = durTime / ONE_HOUR_MILLIONS + "小时前";
      } else if(dayStatus == -1) {
        str = "昨天 " + DateFormat.format("HH:mm", date);
      } else if(isSameYear(date, curDate) && dayStatus < -1) {
        str = DateFormat.format("MM-dd", date).toString();
      } else {
        str = DateFormat.format("yyyy-MM", date).toString();
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return str;
  }

  public static String getZHdate(String dateStr){
  String str = "";
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    str = getString(dateStr, str, sdf);
    return str;
}
  public static boolean isSameYear(Date targetTime, Date compareTime) {
    Calendar tarCalendar = Calendar.getInstance();
    tarCalendar.setTime(targetTime);
    int tarYear = tarCalendar.get(Calendar.YEAR);

    Calendar compareCalendar = Calendar.getInstance();
    compareCalendar.setTime(compareTime);
    int comYear = compareCalendar.get(Calendar.YEAR);

    return tarYear == comYear;
  }

  public static int calculateDayStatus(Date targetTime, Date compareTime) {
    Calendar tarCalendar = Calendar.getInstance();
    tarCalendar.setTime(targetTime);
    int tarDayOfYear = tarCalendar.get(Calendar.DAY_OF_YEAR);
    Calendar compareCalendar = Calendar.getInstance();
    compareCalendar.setTime(compareTime);
    int comDayOfYear = compareCalendar.get(Calendar.DAY_OF_YEAR);
    return tarDayOfYear - comDayOfYear;
  }

}
