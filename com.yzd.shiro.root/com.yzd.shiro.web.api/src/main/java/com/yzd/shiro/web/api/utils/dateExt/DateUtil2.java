package com.yzd.shiro.web.api.utils.dateExt;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class DateUtil2 {
    private DateUtil2() {
        throw new IllegalStateException("Utility class");
    }

    private static final String SHORT_FORMAT = "yyyy-MM-dd";
    private static final String LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Integer getBetweenDay(Date stDate, Date endDate) {
        DateTime stTime = new DateTime(stDate);
        DateTime endTime = new DateTime(endDate);
        return Days.daysBetween(stTime, endTime).getDays();
    }

    public static String getYestdayStr() {
        DateTime dt = new DateTime(new Date());
        return dt.plusDays(-1).toString(SHORT_FORMAT);
    }

    public static String getDateStr(Date dt, String dateTimeFormat) {
        DateTime dateTime = new DateTime(dt);
        return dateTime.toString(dateTimeFormat);
    }

    public static String getDateStr(String dateStr, String dateTimeFormat) {
        DateTime dt = createDateTime(dateStr, null);
        return dt.toString(dateTimeFormat);
    }

    public static Date getDate(String dateStr) {
        DateTime dt = createDateTime(dateStr, null);
        return dt.toDate();
    }

    public static DateTime createDateTime(String dateStr, String formatStr) {
        formatStr = Optional.ofNullable(formatStr).orElse(LONG_FORMAT);
        DateTimeFormatter format = DateTimeFormat.forPattern(formatStr);
        //时间解析
        return DateTime.parse(dateStr, format);
    }

    public static Date plusMinutes(int val) {
        DateTime dt = new DateTime(new Date());
        dt = dt.plusMinutes(val);
        return dt.toDate();
    }

    public static Date plusHours(int val) {
        DateTime dt = new DateTime(new Date());
        dt = dt.plusHours(val);
        return dt.toDate();
    }

    /**
     * 获取今天的开始时间：比如：2014-06-19 00:00:00
     *
     * @param dateStr
     * @return
     */
    public static Date getStartOfDay(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        DateTime dt = createDateTime(dateStr, SHORT_FORMAT);
        return dt.withTimeAtStartOfDay().toDate();
    }

    /**
     * 获取今天的结束时间：比如：2014-06-19 23:59:59
     *
     * @param dateStr
     * @return
     */
    public static Date getEndOfDay(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        DateTime dt = createDateTime(dateStr, SHORT_FORMAT);
        return dt.millisOfDay().withMaximumValue().toDate();
    }
}
