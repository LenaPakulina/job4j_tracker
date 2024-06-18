package ru.job4j.algorithm.pointers;

// https://leetcode.com/problems/partition-labels/

import java.util.*;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        int start = 0;
        int lastCurrIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            lastCurrIndex = Math.max(lastIndex.get(s.charAt(i)), lastCurrIndex);
            if (lastCurrIndex == i) {
                result.add(i - start + 1);
                start = i + 1;
                lastCurrIndex = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
