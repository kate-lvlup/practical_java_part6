package jom.com.softserve.s6.task6;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    public static Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        Map<String, Set<String>> map = new TreeMap<>();

        for (Stream<String> stream : list) {
            stream.forEach(phone -> {
                if (phone == null) {
                    return;
                }
                String cleanPhone = phone.replaceAll("\\D", "").trim();
                if (cleanPhone.isEmpty()) {
                    return;
                }
                String key;
                if (cleanPhone.length() >= 10) {
                    key = cleanPhone.substring(0, 3);
                    cleanPhone = cleanPhone.substring(3);
                } else if (cleanPhone.length() > 7) {
                    key = cleanPhone.substring(0, cleanPhone.length() - 7);
                    cleanPhone = cleanPhone.substring(cleanPhone.length() - 7);
                } else {
                    key = "err";
                }

                if (cleanPhone.length() == 7 && key.equals("err")) {
                    key = "loc";
                }

                map.computeIfAbsent(key, k -> new TreeSet<>()).add(cleanPhone);
            });
        }

        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()));
    }
}
