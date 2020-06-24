package learningforinterview;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.parse("2019-01-10"));
        dates.add(LocalDate.parse("2019-01-20"));
        dates.add(LocalDate.parse("2019-01-25"));
        dates.add(LocalDate.parse("2019-02-10"));
        dates.add(LocalDate.parse("2019-02-20"));
        dates.add(LocalDate.parse("2019-02-25"));
        dates.add(LocalDate.parse("2019-03-10"));
        dates.add(LocalDate.parse("2019-03-20"));
        dates.add(LocalDate.parse("2019-03-25"));
        dates.add(LocalDate.parse("2019-04-10"));
        System.out.println(dates);
        List<LocalDate> newDates = new ArrayList<>();
        dates.forEach(date -> newDates.add(date.withDayOfMonth(1)));
        System.out.println(newDates);
        System.out.println(newDates.stream().distinct().collect(Collectors.toList()));
    }
}
