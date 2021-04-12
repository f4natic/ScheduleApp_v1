package ru.f4n.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateFormatUtils {
    private static String dateFormatPattern = "yyyy-MM-dd hh:mm";
    private static SimpleDateFormat dateFormat;

    public static Date getDate(String date) {
        dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern(dateFormatPattern);
        Date parseDate = null;
        try {
             parseDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.print("Неверный формат даты");
            return new Date();
        }
        return parseDate;
    }

    public static String getStringDate(Date date) {
        dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern(dateFormatPattern);
        dateFormat.format(date);
        return dateFormat.format(date);
    }
}
