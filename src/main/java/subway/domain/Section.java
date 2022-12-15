package subway.domain;

import java.util.ArrayList;
import java.util.List;

import static subway.view.MessagePrefix.ERROR_PREFIX;

public class Section {

    private final List<Station> stations;

    public Section() {
        this.stations = new ArrayList<>();
    }

    public void addSection(Station station, int index) {
        validateIndex(index);
        validateStationOverlapped(station);
        stations.add(index, station);
    }

    public void deleteSection(Station station) {
        validateStationNotExist(station);
        stations.remove(station);
    }

    private void validateIndex(int index) {
        if (index > stations.size()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "노선의 범위를 벗어난 순서를 입력하셨습니다.");
        }
    }

    private void validateStationOverlapped(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구간에 입력한 역이 존재합니다.");
        }
    }

    private void validateStationNotExist(Station station) {
        if (!stations.contains(station)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구간에 입력한 역이 존재하지 않습니다.");
        }
    }

    private void validateSectionLength() {
        if (stations.size() <= 2) {
            throw new IllegalArgumentException(ERROR_PREFIX + "최소한의 구간이라 삭제가 불가능합니다.");
        }
    }
}
