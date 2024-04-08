package ru.job4j.tracker.action;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

class DeleteTest {
    @DisplayName("Удаление созданного элемента.")
    @Test
    public void whenItemWasDeleteSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);

        tracker.add(new Item("Delete item"));
        UserAction deleteAction = new Delete(output);

        when(input.askInt(any(String.class))).thenReturn(1);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Заявка удалена успешно." + ln
        );
    }

    @DisplayName("Удаление несуществующего элемента.")
    @Test
    void whenItemWasDeleteNotExistsIdThenWrong() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);

        UserAction deleteAction = new Delete(output);
        when(input.askInt(any(String.class))).thenReturn(100);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Ошибка удаления заявки." + ln
        );
    }
}