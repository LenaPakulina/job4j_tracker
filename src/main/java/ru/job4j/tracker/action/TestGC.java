package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;

import java.util.List;

public class TestGC implements UserAction {
    private final Output out;

    public TestGC(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "TestGC";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== TestGC ===");
        for (int j = 0; j < 10; j++) {
            long addStartTime = System.currentTimeMillis();
            for (int i = 0; i < 400000; i++) {
                memTracker.add(new Item("Заявка № " + i));
            }
            long addEndTime = System.currentTimeMillis();

            long deleteStartTime = System.currentTimeMillis();
            List<Item> allItems = memTracker.findAll();
            List<Integer> collect = allItems.stream()
                    .map(Item::getId).toList();
            for (Integer integer : collect) {
                memTracker.delete(integer);
            }
            long deleteEndTime = System.currentTimeMillis();
            out.println(String.format("%d. Добавление: %d, Удаление: %d",
                    (j + 1), (addEndTime - addStartTime), (deleteEndTime - deleteStartTime)));
        }
        out.println("=== Завершение TestGC ===");
        return true;
    }
}
