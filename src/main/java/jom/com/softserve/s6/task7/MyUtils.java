package jom.com.softserve.s6.task7;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public static Stream<Integer> duplicateElements(Stream<Integer> stream) {
        Map<Integer, Long> elementCounts =
                stream.filter(e -> e != null)
                        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return elementCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted();
    }

}
