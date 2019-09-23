package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonDate {
    public static String getToday() {
        return getDate(new Date());
    }

    public static String getDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        return format.format(date);
    }

    public static String getTimeAsString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        return format.format(date);
    }
}
