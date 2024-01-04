package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("el.pakulina@yandex.ru", "Elena Pakulina");
        map.put("el.pakulina@yandex.ru", "Rita Pakulina");
        map.put("El.pakulina@yandex.ru", "ELENA Pakulina");
        map.put("moli@america.com", "John Winston Lennon");
        map.put("sara@ldsd.com", "Sarah Hall");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
