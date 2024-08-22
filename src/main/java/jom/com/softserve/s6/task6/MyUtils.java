package jom.com.softserve.s6.task6;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyUtils {
    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .flatMap(Function.identity())
                .filter(Objects::nonNull)
                .filter(s -> s.length() > 1)
                .map(s -> s.replaceAll("\\D", ""))
                .map(s -> s.length() == 10 ? s : s.length() == 7 ? "loc".concat(s) : "err".concat(s))
                .distinct()
                .sorted()
                .collect(Collectors.toMap(
                        e -> e.substring(0, 3),
                        e -> Stream.of(e.substring(3)),
                        Stream::concat
                ));
    }
}
