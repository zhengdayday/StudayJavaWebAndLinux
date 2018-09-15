package Java;

import static java.time.temporal.TemporalAdjusters.dayOfWeekInMonth;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author zhengtt
 */
public class CheckDataTest {

    /**
     * 判断当天是否为拍牌日
     * @param date date
     * @return true/false
     */
    public static boolean checkData(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate thirdSaturday = localDate.with(dayOfWeekInMonth(3, DayOfWeek.SATURDAY));

        return localDate.isAfter(thirdSaturday);
    }

    public static void main(String[] args) {
        System.out.println(checkData("20180901") + " " + checkData("20180915") + " " + checkData("20180916"));
    }
}


