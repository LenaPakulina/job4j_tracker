package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HbmTrackerTest {
    private static HbmTracker tracker = new HbmTracker();

    @AfterAll
    static void afterAll() {
        tracker.close();
    }

    @AfterEach
    void clearData() throws SQLException {
        tracker.findAll().forEach(
                item -> tracker.delete(item.getId())
        );
    }

    @Test
    void whenSaveItemThenCanFindThis() {
        Item item = new Item();
        item.setName("test");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    void whenSaveItemAndCheckItemId() {
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    void whenReplaceThenCheckName() {
        Item item = new Item("Item");
        tracker.add(item);
        int id = item.getId();
        Item newItem = new Item("newItem");
        newItem.setId(id);
        tracker.replace(id, newItem);
        assertThat(tracker.findById(id).getName()).isEqualTo(newItem.getName());
    }

    @Test
    void whenTestFindById() {
        Item item = new Item("Item");
        Item newItem = tracker.add(item);
        assertThat(tracker.findById(newItem.getId())).isEqualTo(item);
    }

    @Test
    void whenTestFindAll() {
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.findAll()).isEqualTo(List.of(first, second));
    }

    @Test
    void whenTestFindByNameCheckSecondItemName() {
        Item first1 = new Item("First");
        Item first2 = new Item("First");
        Item second1 = new Item("Second");
        Item second2 = new Item("Second");
        tracker.add(first1);
        tracker.add(second1);
        tracker.add(second2);
        tracker.add(first2);
        var items = tracker.findAll();
        assertThat(tracker.findByName(second1.getName())).isEqualTo(List.of(second1, second2));
    }

    @Test
    void whenDelete() {
        Item item = new Item();
        item.setName("Item");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }
}