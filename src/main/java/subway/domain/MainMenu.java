package subway.domain;

import java.util.Arrays;

import static subway.view.MessagePrefix.ERROR_PREFIX;

public enum MainMenu {

    STATION_MENU("1"),
    LINE_MENU("2"),
    SECTION_MENU("3"),
    PRINT_SUBWAY_MENU("4"),
    QUIT("Q");


    private final String command;

    MainMenu(String command) {
        this.command = command;
    }

    public static MainMenu from(String command) {
        return Arrays.stream(MainMenu.values())
                .filter(mainMenu -> mainMenu.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "선택할 수 없는 기능입니다."));
    }
}
