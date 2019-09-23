package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonDate {
    public static String getToday() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();

        return format.format(now);
    }
}
