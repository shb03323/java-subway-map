package subway.domain;

import java.util.Arrays;

import static subway.view.MessagePrefix.ERROR_PREFIX;

public enum StationMenu {

    STATION_ADD("1"),
    STATION_DELETE("2"),
    STATION_SEARCH("3"),
    BACK("B");

    private final String command;

    StationMenu(String command) {
        this.command = command;
    }

    public static StationMenu from(String command) {
        return Arrays.stream(StationMenu.values())
                .filter(stationMenu -> stationMenu.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "선택할 수 없는 기능입니다."));
    }
}
