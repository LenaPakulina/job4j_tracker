package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        System.out.println("8. Date. Отображение даты:");
        LocalDateTime dateTime = item.getCreated();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = dateTime.format(formatter);
        System.out.println(currentDateTimeFormat);
        System.out.println("10. toString [#310018]:");
        System.out.println(item);
    }
}
