package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] aLeft = left.split("\\.");
        String[] aRight = right.split("\\.");
        if (aLeft.length == 0 || aRight.length == 0) {
            return aLeft.length == 0 ? -1 : 1;
        }
        Integer i1 = Integer.parseInt(aLeft[0]);
        Integer i2 = Integer.parseInt(aRight[0]);
        return i1.compareTo(i2);
    }
}