package edu.hw5;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tasks {

    public static Duration Task1(List<String> sessions) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

        return sessions.stream()
            .map(dateTime -> dateTime.split(" - "))
            .map(dateTime -> new LocalDateTime[] {
                LocalDateTime.parse(dateTime[0], dateTimeFormatter),
                LocalDateTime.parse(dateTime[1], dateTimeFormatter)})
            .map(dateTime -> Duration.between(dateTime[0], dateTime[1]))
            .reduce(Duration.ZERO, Duration::plus)
            .dividedBy(sessions.size());
    }

    public static List<LocalDate> Task2(int year) {
        List<LocalDate> ans = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, 1);
        while (date.getYear() == year) {
            date = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            if (date.getDayOfMonth() == 13) {
                ans.add(date);
            }
        }
        return ans;
    }

    public static Optional<LocalDate> Task3(String string) {
        List<DateTimeFormatter> dateTimeFormatters = List.of(
            DateTimeFormatter.ofPattern("yyyy-M-d"),
            DateTimeFormatter.ofPattern("yyyy-d-M"),
            DateTimeFormatter.ofPattern("M-d-yyyy"),
            DateTimeFormatter.ofPattern("d-M-yyyy"),

            DateTimeFormatter.ofPattern("yyyy/MM/dd"),
            DateTimeFormatter.ofPattern("yyyy/dd/MM"),
            DateTimeFormatter.ofPattern("d/M/yyyy"),
            DateTimeFormatter.ofPattern("d/M/yy")
        );
        for (DateTimeFormatter dtf : dateTimeFormatters) {
            try {
                LocalDate date = LocalDate.parse(string, dtf);
                return Optional.of(date);
            } catch (Exception e) {
            }
        }

        List<String> splt = List.of(string.split(" "));
        if (splt.size()==3 && (splt.get(1).equals("day") || splt.get(1).equals("days")) && splt.get(0).matches("^\\d+$")){
            if (splt.get(2).equals("ago")){
                return Optional.of(LocalDate.now().minusDays(Integer.parseInt(splt.get(0))));
            }
            if (splt.get(2).equals("after")){
                return Optional.of(LocalDate.now().minusDays(Integer.parseInt(splt.get(0))));
            }
        }

        return switch (string) {
            case "today" -> Optional.of(LocalDate.now());
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            default -> Optional.empty();
        };
    }

    public static boolean Task4(String string) {
        return string.matches(".*[~!@#$%^&*|].*");
    }

    public static boolean Task5(String string) {
        return string.matches("^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$");
    }

    public static boolean Task6(String text, String word) {
        return text.matches(".*" + word + ".*");
    }

    public static boolean Task7_1(String string) {
        return string.matches("^[01]{2}0[01]*$");
    }

    public static boolean Task7_2(String string) {
        return string.matches("^0[01]*0$|^1[01]*1$|^0$|^1$");
    }

    public static boolean Task7_3(String string) {
        return string.matches("^[01]{1,3}$");
    }

    public static boolean Task8_1(String string) {
        return string.matches("^[01]([01]{2})*$");
    }

    public static boolean Task8_2(String string) {
        return string.matches("^0([01]{2})*$|^1[01]([01]{2})*$");
    }

    public static boolean Task8_3(String string) {
        Pattern pattern = Pattern.compile("01*");
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
        return (count % 3 == 0);
    }

    public static boolean Task8_4(String string) {
        return string.matches("^(?!(11$|111$))[01]*$");
    }

    public static boolean Task8_5(String string) {
        return string.matches("1(([01]1)*)0{0,1}$");
    }

    public static boolean Task8_6(String string) {
        return string.matches("^0*(010|100|001|00)0*$");
    }

    public static boolean Task8_7(String string) {
        return string.matches("^(10|0)*1{0,1}$");
    }
}
