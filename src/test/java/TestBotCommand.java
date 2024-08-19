import com.automationanywhere.botcommand.*;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBotCommand {
    @Test
    public void testBotCommand() {
        //LocalDate date = (LocalDate.of(2024, 4, 29));
        List<String> inputHolidays = Arrays.asList(
                "2024-01-01",
                "2024-01-06",
                "2024-04-25",
                "2024-05-01",
                "2024-06-02",
                "2024-08-15",
                "2024-11-01",
                "2024-12-08",
                "2024-12-25",
                "2024-12-26"
        );

        DateOperations dateOp = new DateOperations();
        System.out.println(dateOp.convertToDateList(inputHolidays));
    };
}

//****** PREVIOUS TESTS ******

//DayOfWeek dayOfWeek = date.getDayOfWeek();
//String inputDate = "1995-01-27";
//int year = 2024;

//List<LocalDate> holidaysList = new ArrayList<>(List.of(
//        LocalDate.of(2024,1,1),
//        LocalDate.of(2024,1,6),
//        LocalDate.of(2024,4,25),
//        LocalDate.of(2024,5,1),
//        LocalDate.of(2024,6,2),
//        LocalDate.of(2024,8,15),
//        LocalDate.of(2024,11,1),
//        LocalDate.of(2024,12,8),
//        LocalDate.of(2024,12,25),
//        LocalDate.of(2024,12,26)
//));

//        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
//        // Saturday and Sunday should return false
//        Assert.assertFalse(dateOp.isWeekDay(date));
//        } else {
//        // Monday should return true
//        Assert.assertTrue(dateOp.isWeekDay(date));
//        }
//
//        System.out.println(date + " is a week day? " + dateOp.isWeekDay(date));
//        System.out.println("Easter date in " + year + ": " + dateOp.calculateEaster(year));
//        System.out.println("Easter Monday date in " + year + ": " + dateOp.calculateEasterMonday(year));
//        System.out.println("Stringified date " + date + ": " + dateOp.stringifyDate(date));
//        System.out.println("Input date " + inputDate);

//System.out.println(date + " is a working day? " + dateOp.isWorkingDay(date, holidaysList));
//        List<String> stringList = dateOp.convertToStringList(holidaysList);
//        System.out.println("Contents of the list:");
//        stringList.forEach(System.out::println);
//System.out.println(dateOp.convertToStringList(holidaysList));