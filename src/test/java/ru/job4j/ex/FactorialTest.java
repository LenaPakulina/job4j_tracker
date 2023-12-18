package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Factorial factorial = new Factorial();
                    factorial.calc(-10);
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void whenAcceptance() {
        Factorial factorial = new Factorial();
        int answer = factorial.calc(5);
        assertThat(answer).isEqualTo(120);
    }
}