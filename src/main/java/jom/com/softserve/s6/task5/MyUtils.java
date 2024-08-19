package jom.com.softserve.s6.task5;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MyUtils {
    public static Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null) {
            throw new NullPointerException("The map cannot be null.");
        }
        return map.values().stream()
                .filter(Objects::nonNull)
                .flatMap(stream -> stream.filter(Objects::nonNull)
                        .map(name -> name.replaceAll("\\s+", "").trim()))
                .filter(name -> !name.isEmpty())
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase())
                .distinct()
                .sorted();

    }
}
