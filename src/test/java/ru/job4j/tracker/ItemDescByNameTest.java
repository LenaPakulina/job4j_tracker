package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {
    @Test
    void sortTest() {
        List<Item> items = Arrays.asList(
                new Item("One"),
                new Item("Two"),
                new Item("Three"),
                new Item("one"),
                new Item("0"),
                new Item("1"),
                new Item("2")
        );
        List<Item> expected = Arrays.asList(
                new Item("one"),
                new Item("Two"),
                new Item("Three"),
                new Item("One"),
                new Item("2"),
                new Item("1"),
                new Item("0")
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}