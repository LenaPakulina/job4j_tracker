package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
        import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {
    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"67", "68"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(67);
    }

    @Test
    void whenValidMixInput() {
        Output output = new StubOutput();
        String[] strs = new String[] {"67", "68", "69"};
        Input in = new MockInput(
                strs
        );
        ValidateInput input = new ValidateInput(output, in);
        for (int i = 0; i < strs.length; i++) {
            int selected = input.askInt("Enter menu:");
            assertThat(selected).isEqualTo(67 + i);
        }
    }

    @Test
    void whenNegativeNumInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-2", "-1", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }
}