package com.example.testofindia.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateFormateUtil {

    private static final String TAG = DateFormateUtil.class.getSimpleName();

    public static String parseDateToddMMyyyy(String time) {
        String inputPattern = "dd-MM-yyyy";
        String outputPattern = "dd/MMM/yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDate(Date date) {
        String outputPattern = "dd/MMM/yyyy";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        String str = null;

        str = outputFormat.format(date);
        return str;
    }

    public static String parseDayDateMonthYear(Date date) {
        String outputPattern = "E, dd-MMM yyyy";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        String str = null;

        str = outputFormat.format(date);
        return str;
    }

    public static String parseDateOrder(Date date) {
        String outputPattern = "dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        String str = null;

        str = outputFormat.format(date);
        return str;
    }

    public static String parseTime(Date date) {
        String outputPattern = "HH:mm:ss";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        String str = null;

        str = outputFormat.format(date);
        return str;
    }

    public static String parseDateNew2(Date date) {
        String outputPattern = "dd-MM-yyyy";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        String str = null;

        str = outputFormat.format(date);
        return str;
    }

    public static String getDateToLongDate(long timestamp) {

        String date_pattern = "dd MMMM yyyy";
        //  String time_pattern = "hh:mm a";

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(date_pattern);
        // SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(time_pattern);

        Date cal_date = new Date(timestamp);

        String date = simpleDateFormat1.format(cal_date);
        //  String time = simpleDateFormat2.format(cal_date);

        final String date_time = date;

        return date_time;
    }

    public static String getDayFromTimeStamp(long timestamp) {

        String date_pattern = "EEEE";
        // String time_pattern = "hh:mm a";

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(date_pattern);
        // SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(time_pattern);

        Date cal_date = new Date(timestamp);

        String date = simpleDateFormat1.format(cal_date);
        //  String time = simpleDateFormat2.format(cal_date);

        final String date_time = date;

        return date_time;
    }

    public static String parseDateNew(Date date) {
        String outputPattern = "yyyy-MM-dd";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        String str = null;

        str = outputFormat.format(date);
        return str;
    }

    public static String parseDateNewPHPtoNormal(String time) {

        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd-MM-yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDateNormal(String time) {

        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "MMM-dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDateNewPHPtoNormal2(String time) {

        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd MMM, yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDateDateToProper(String time) {

        String inputPattern = "dd-MM-yyyy";
        String outputPattern = "dd MMM,yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDateToMonthPHPTonormal(String time) {
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd MMM,yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDateToMonthPHPTonormalNew(String time) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        String outputPattern = "MM-yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDateNew3(long date) {
        String outputPattern = "dd-MM-yyyy";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        String str = null;

        str = outputFormat.format(date);
        return str;
    }

    public static String getTimeFromTimeStamp(long timestamp) {

        String date_pattern = "E, dd MMMM yyyy";
        String time_pattern = "hh:mm a";

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(date_pattern);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(time_pattern);

        Date cal_date = new Date(timestamp);

        String date = simpleDateFormat1.format(cal_date);
        String time = simpleDateFormat2.format(cal_date);

        final String date_time = date + " at " + time;

        return date_time;
    }

    public static String getTimeFromTimeStamp2(long timestamp) {

        String date_pattern = "dd MMMM (E)";
        String time_pattern = "hh:mm a";

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(date_pattern);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(time_pattern);

        Date cal_date = new Date(timestamp);

        String date = simpleDateFormat1.format(cal_date);
        String time = simpleDateFormat2.format(cal_date);

        final String date_time = date + " at " + time;

        return date_time;
    }

    public static String getOnlyTimeFromTimeStamp(long timestamp) {

        String time_pattern = "hh:mm a";

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(time_pattern);

        Date cal_date = new Date(timestamp);

        String time = simpleDateFormat2.format(cal_date);

        final String date_time = time;

        return date_time;
    }

    public static String getTimeFromTimeStampPHP(long timestamp) {

        String date_pattern = "E, dd MMMM yyyy";
        String time_pattern = "hh:mm a";

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(date_pattern);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(time_pattern);

        Date cal_date = new Date(timestamp * 1000);

        String date = simpleDateFormat1.format(cal_date);
        String time = simpleDateFormat2.format(cal_date);

        final String date_time = date + " at " + time;

        return date_time;
    }

    public static String parseDateToDay(Date date) {
        String outputPattern = "EEE";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        String str = null;

        str = outputFormat.format(date);
        return str;
    }

    public static String parseSpecialDateToDay(String time) {
        String inputPattern = "dd/MMM/yyyy";
        String outputPattern = "EEE";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDayToDate(Date date) {
        String outputPattern = "dd";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        String str = null;
        str = outputFormat.format(date);
        return str;
    }

    public static String parseDateToMonth(Date date) {
        String outputPattern = "MM-yyyy";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        String str = null;
        str = outputFormat.format(date);
        return str;
    }

    public static String parseDateToMonthOnly(Date date) {
        String outputPattern = "MM";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        String str = null;
        str = outputFormat.format(date);
        return str;
    }

    public static String parseDateToYearOnly(Date date) {
        String outputPattern = "yyyy";
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        String str = null;
        str = outputFormat.format(date);
        return str;
    }

    public static String parseSpecialMonthyear(String time) {
        String inputPattern = "MM-yyyy";
        String outputPattern = "MMMM, yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseSpecialDateToDate(String time) {
        String inputPattern = "dd/MMM/yyyy";
        String outputPattern = "dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }


    public static long convertDateToTimestamp(String str_date) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = (Date) formatter.parse(str_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Today is " + date.getTime());
        return date.getTime();
    }

    public static long convertDateToTimestamp3(String str_date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = (Date) formatter.parse(str_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Today is " + date.getTime());
        return date.getTime();
    }

    public static String getWeekEndDayCount(long startDate, long endDate) {

        List<Date> datesInRange = new ArrayList<>();

        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(startDate);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTimeInMillis(endDate);

        int weekDay = 0;
        int weekEnd = 0;
        while (calendar.before(endCalendar)) {
            Date result = calendar.getTime();
            int day = result.getDay();
            if (day == 0 || day == 6) {
                weekEnd = weekEnd + 1;
            } else {
                weekDay = weekDay + 1;
            }
            datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        //Date result = endCalendar.getTime();
        /*int day = result.getDay();
        if (day == 0 || day == 6) {
            weekEnd = weekEnd + 1;
        } else {
            weekDay = weekDay + 1;
        }*/
        //datesInRange.add(result);
        return "" + weekDay + "-" + weekEnd;
    }

    public static long convertDateToTimestamp2(String str_date) {
        DateFormat formatter = new SimpleDateFormat("E, dd-MMM yyyy");
        Date date = null;
        try {
            date = (Date) formatter.parse(str_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Today is " + date.getTime());
        return date.getTime();
    }

    public static long daysBetween(String startDate, String endDate) {
        long diff = 0;
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date1 = myFormat.parse(startDate);
            Date date2 = myFormat.parse(endDate);
            diff = date2.getTime() - date1.getTime();
            //   float days = (diff / (1000 * 60 * 60 * 24));
            // System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    /*public static Date getIndianDateInReturnDateFormat() {

        Date trueTime = TrueTimeRx.now();
        String currentTime = _formatDate(trueTime, "dd-MM-yyyy", TimeZone.getTimeZone("GMT+05:30"));
        // String currentTime = _formatDate(trueTime, "yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT+05:30"));

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = (Date) df.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "getIndianDateInReturnDateFormat: >>>>>>" + date, null);
        return date;
    }

    public static String getIndianDateInReturnStringFormat() {

        Date trueTime = TrueTimeRx.now();
        String currentTime = _formatDate(trueTime, "dd-MM-yyyy", TimeZone.getTimeZone("GMT+05:30"));
        // String currentTime = _formatDate(trueTime, "yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT+05:30"));

        Log.e(TAG, "getIndianDateInReturnStringFormat: >>>>>>" + currentTime, null);
        return currentTime;
    }*/

    public static String _formatDate(Date date, String pattern, TimeZone timeZone) {
        DateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
        format.setTimeZone(timeZone);
        return format.format(date);
    }

    public static String getTwitterDate(long getTime) {
        long different = System.currentTimeMillis() - getTime;
        String result = "now";
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        if (elapsedDays == 0) {
            if (elapsedHours == 0) {
                if (elapsedMinutes == 0) {
                    if (elapsedSeconds < 0) {
                        return "0" + " second";
                    } else {
                        if (elapsedSeconds > 0 && elapsedSeconds < 59) {
                            return "now";
                        }
                    }
                } else {
                    return elapsedMinutes + " minute ago";
                }
            } else {
                return elapsedHours + " hours ago";
            }

        } else {
            if (elapsedDays <= 29) {
                return String.valueOf(elapsedDays) + " days ago";
            }
            if (elapsedDays > 29 && elapsedDays <= 58) {
                return "1 month ago";
            }
            if (elapsedDays > 58 && elapsedDays <= 87) {
                return "2 months ago";
            }
            if (elapsedDays > 87 && elapsedDays <= 116) {
                return "3 months ago";
            }
            if (elapsedDays > 116 && elapsedDays <= 145) {
                return "4 months ago";
            }
            if (elapsedDays > 145 && elapsedDays <= 174) {
                return "5 months ago";
            }
            if (elapsedDays > 174 && elapsedDays <= 203) {
                return "6 months ago";
            }
            if (elapsedDays > 203 && elapsedDays <= 232) {
                return "7 months ago";
            }
            if (elapsedDays > 232 && elapsedDays <= 261) {
                return "8 months ago";
            }
            if (elapsedDays > 261 && elapsedDays <= 290) {
                return "9 months ago";
            }
            if (elapsedDays > 290 && elapsedDays <= 319) {
                return "10Mth ago";
            }
            if (elapsedDays > 319 && elapsedDays <= 348) {
                return "11 months ago";
            }
            if (elapsedDays > 348 && elapsedDays <= 360) {
                return "12 months ago";
            }

            if (elapsedDays > 360 && elapsedDays <= 720) {
                return "1 year ago";
            }
        }
        return result;
    }

}
