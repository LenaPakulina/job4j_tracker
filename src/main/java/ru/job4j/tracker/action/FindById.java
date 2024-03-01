package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.Output;

public class FindById implements UserAction {
    private final Output output;

    public FindById(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        output.println("=== Вывод заявки по id ===");
        int id = input.askInt("Введите id: ");
        Item item = memTracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
