package ru.job4j.tracker.action;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameTest {
    @DisplayName("Поиск созданного элемента.")
    @Test
    public void whenItemWasFindSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);

        Item item = new Item(1, "Item");
        tracker.add(item);
        UserAction findByNameAction = new FindByName(output);

        when(input.askStr(any(String.class))).thenReturn(item.getName());

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявок по имени ===" + ln
                        + "Заявки с именем: " + item.getName() + " найдены." + ln
        );
    }

    @DisplayName("Поиск несуществующего элемента.")
    @Test
    void whenItemWasFindNotExistsIdThenWrong() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);

        String name = "Item";
        UserAction findByNameAction = new FindByName(output);

        when(input.askStr(any(String.class))).thenReturn(name);

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявок по имени ===" + ln
                        + "Заявки с именем: " + name + " не найдены." + ln
        );
    }
}