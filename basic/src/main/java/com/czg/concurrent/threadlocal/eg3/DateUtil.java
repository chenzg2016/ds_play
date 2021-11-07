package com.czg.concurrent.threadlocal.eg3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenzg
 * @date 8/3/21 9:59 PM
 * @description
 */
public class DateUtil {
    private static final ThreadLocal<SimpleDateFormat> sdf =  ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            ;

    public static Date parse(String dateStr) {
        Date date = null;
        try {
            date = sdf.get().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
