package subway.domain;

import java.util.HashMap;
import java.util.Map;

public class SectionRepository {

    private static final Map<Line, Section> sections = new HashMap<>();

    public static void addSection(Line line, Station station, int index) {
        Section section = sections.get(line);
        section.addSection(station, index);
    }

    public static void addLine(Line line, Station upperStation, Station lowerStation) {
        Section section = new Section();
        section.addSection(upperStation, 0);
        section.addSection(lowerStation, 1);
        sections.put(line, section);
    }

    public static void deleteSection(Line line, Station station) {
        Section section = sections.get(line);
        section.deleteSection(station);
    }
}
