package jom.com.softserve.s6.task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyUtils {
    public static String getDateAfterToday(int years, int months, int days) {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusYears(years).plusMonths(months).plusDays(days);
        return futureDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
