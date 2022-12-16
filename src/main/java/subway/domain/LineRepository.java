package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static subway.view.MessagePrefix.ERROR_PREFIX;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<String> readLines() {
        return lines.stream()
                .map(Line::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public static void addLine(Line line) {
        validateLineNameLength(line);
        validateLineOverlapped(line);
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        Line line = findByName(name);
        lines.remove(line);
    }

    public static Line findByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 노선입니다.\n"));
    }

    private static void validateLineNameLength(Line line) {
        if (line.getName().length() < 2) {
            throw new IllegalArgumentException(ERROR_PREFIX + "2글자 이상의 노선 이름으로 입력해주세요.\n");
        }
    }

    private static void validateLineOverlapped(Line targetLine) {
        boolean isOverlapped = lines.stream()
                .anyMatch(line -> line.equals(targetLine));
        if (isOverlapped) {
            throw new IllegalArgumentException(ERROR_PREFIX + "이미 등록된 노선 이름입니다.\n");
        }
    }
}
