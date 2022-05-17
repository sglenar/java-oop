package com.efimchick.ifmo.collections.countwords;


import java.util.*;

public class Words {

    public String countWords(List<String> lines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : lines) {
            string = string.replaceAll("[^A-Za-zА-Яа-я]", " ").toLowerCase().concat("\n");
            stringBuilder.append(string);
        }
        lines = Arrays.asList(stringBuilder.toString().split("\\s+"));

        Map<String, Integer> map = new HashMap<>();
        for (String str : lines) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        return sortByValue(map).toString()
                .replaceAll("[{}]", "")
                .replaceAll(", ", "\n")
                .replaceAll("=", " - ");
    }
    public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int res = o1.getValue().compareTo(o2.getValue());
                if (res == 0) {
                    return o2.getKey().compareTo(o1.getKey());
                } else {
                    return res;
                }
            }
        });
        Collections.reverse(list);

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getKey().length() >= 4 && entry.getValue() > 9) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}