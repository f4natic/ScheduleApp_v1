package ru.f4n.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateFormatUtils {
    private static String dateFormatPattern = "yyyy-MM-dd HH:mm";
    private static SimpleDateFormat dateFormat;

    public static Date getDate(String date) {
        dateFormat = new SimpleDateFormat(dateFormatPattern);
        Date parseDate = null;
        try {
             parseDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Неверный формат даты");
            return new Date();
        }
        return parseDate;
    }

    public static String getStringDate(Date date) {
        dateFormat = new SimpleDateFormat(dateFormatPattern);
        dateFormat.format(date);
        return dateFormat.format(date);
    }
}
