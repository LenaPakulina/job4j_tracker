package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        Integer i1 = Integer.parseInt(left.split("\\.")[0]);
        Integer i2 = Integer.parseInt(right.split("\\.")[0]);
        return i1.compareTo(i2);
    }
}