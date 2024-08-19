import com.automationanywhere.botcommand.*;
import com.automationanywhere.botcommand.data.impl.BooleanValue;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestWorkingDay {
    @Test
    public void testWorkingDay() {
        String inputDate = "2024-01-27";
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
        //create WorkingDay object
        WorkingDay workingDay = new WorkingDay();
        //invoke action
        BooleanValue output = workingDay.action(inputDate, inputHolidays);

        System.out.println(output);
    }
}
