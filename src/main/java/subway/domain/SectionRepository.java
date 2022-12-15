package subway.domain;

import java.util.HashMap;
import java.util.Map;

public class SectionRepository {

    private static final Map<Line, Section> sections = new HashMap<>();

    public static void addSection(Line line, Station station, int index) {
        Section section = sections.get(line);
        section.addSection(station, index);
    }

    public static void addLine(Line line) {
        sections.put(line, new Section());
    }
}
