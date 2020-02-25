package com.alan.demo.utils;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 时间格式化
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/25
 */

public class DateUtils {


    /**
     * @param date 当前时间
     * @return 返回当前时间格式为 yyyy-MM-dd HH:mm:ss
     */
    public static String getDate(Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date);

        return dateStr;
    }
}
