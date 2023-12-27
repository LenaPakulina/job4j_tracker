package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public final class SingleTracker {
    private static Tracker tracker = new Tracker();
    private static SingleTracker singleTracker = null;

    private SingleTracker() {
    }

    public static SingleTracker getSingleTracker() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }

    public static void main(String[] args) {
        SingleTracker sglTracker = SingleTracker.getSingleTracker();
        sglTracker.add(new Item("sdfsdf"));
        sglTracker.add(new Item("sdfsdf"));
        sglTracker.add(new Item("sdfsdf"));
        System.out.println("Size = " + sglTracker.findAll().size());
    }
}
