package ru.job4j.tracker.action;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

class FindByIdTest {
    @DisplayName("Поиск созданного элемента.")
    @Test
    public void whenItemWasFindSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);

        Item item = new Item(1, "Item");
        tracker.add(item);
        UserAction findByIdAction = new FindById(output);

        when(input.askInt(any(String.class))).thenReturn(item.getId());

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + "Заявка с введенным id: " + item.getId() + " найдена." + ln
        );
    }

    @DisplayName("Поиск несуществующего элемента.")
    @Test
    void whenItemWasFindNotExistsIdThenWrong() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);

        int id = 100;
        UserAction findByIdAction = new FindById(output);

        when(input.askInt(any(String.class))).thenReturn(id);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + "Заявка с введенным id: " + id + " не найдена." + ln
        );
    }
}