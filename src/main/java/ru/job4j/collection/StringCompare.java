package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int ans = 0;
        int index = 0;
        while (ans == 0 && index < Math.min(left.length(), right.length())) {
            ans = Character.compare(left.charAt(index), right.charAt(index));
            index++;
        }
        if (ans == 0 && left.length() != right.length()) {
            ans = left.length() < right.length() ? -1 : 1;
        }
        return ans;
    }
}