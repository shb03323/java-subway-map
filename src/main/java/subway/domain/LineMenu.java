package subway.domain;

import java.util.Arrays;

import static subway.view.MessagePrefix.ERROR_PREFIX;

public enum LineMenu {

    LINE_ADD("1"),
    LINE_DELETE("2"),
    LINE_SEARCH("3"),
    BACK("B");

    private final String command;

    LineMenu(String command) {
        this.command = command;
    }

    public static LineMenu from(String command) {
        return Arrays.stream(LineMenu.values())
                .filter(lineMenu -> lineMenu.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "선택할 수 없는 기능입니다."));
    }
}
