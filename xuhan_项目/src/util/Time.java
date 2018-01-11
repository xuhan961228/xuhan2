package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static String  time() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String t = dateFormat.format(date);
        return t;
    }
}
