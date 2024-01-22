package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> ans = new LinkedHashSet<>();
        for (String value : departments) {
            StringBuilder start = new StringBuilder();
            for (String element : value.split("/")) {
                ans.add(start + element);
                start.append(element).append("/");
            }
        }
        return new ArrayList<>(ans);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}
