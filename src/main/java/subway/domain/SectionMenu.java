package subway.domain;

import java.util.Arrays;

import static subway.view.MessagePrefix.ERROR_PREFIX;

public enum SectionMenu {

    SECTION_ADD("1"),
    SECTION_DELETE("2"),
    BACK("B");

    private final String command;

    SectionMenu(String command) {
        this.command = command;
    }

    public static SectionMenu from(String command) {
        return Arrays.stream(SectionMenu.values())
                .filter(sectionMenu -> sectionMenu.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "선택할 수 없는 기능입니다."));
    }
}
