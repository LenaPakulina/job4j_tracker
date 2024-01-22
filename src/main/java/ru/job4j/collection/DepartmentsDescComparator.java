package ru.job4j.collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int ans = right.split("/")[0].compareTo(left.split("/")[0]);
        return ans == 0 ? left.compareTo(right) : ans;
    }
}
