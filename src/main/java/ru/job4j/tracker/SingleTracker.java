package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static Store memTracker = new MemTracker();
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
        return memTracker.add(item);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public void delete(int id) {
        memTracker.delete(id);
    }

    public static void main(String[] args) {
        SingleTracker sglTracker = SingleTracker.getSingleTracker();
        sglTracker.add(new Item("sdfsdf"));
        sglTracker.add(new Item("sdfsdf"));
        sglTracker.add(new Item("sdfsdf"));
        System.out.println("Size = " + sglTracker.findAll().size());
    }
}
