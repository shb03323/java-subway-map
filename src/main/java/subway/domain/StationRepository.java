package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.view.MessagePrefix.ERROR_PREFIX;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateStationNameLength(station);
        validateStationOverlapped(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 역입니다.\n"));
    }

    private static void validateStationNameLength(Station station) {
        if (station.getName().length() < 2) {
            throw new IllegalArgumentException(ERROR_PREFIX + "2글자 이상의 역이름으로 입력해주세요.\n");
        }
    }

    private static void validateStationOverlapped(Station targetStation) {
        boolean isOverlapped = stations.stream()
                .anyMatch(station -> station.equals(targetStation));
        if (isOverlapped) {
            throw new IllegalArgumentException(ERROR_PREFIX + "이미 등록된 역 이름입니다.\n");
        }
    }
}
