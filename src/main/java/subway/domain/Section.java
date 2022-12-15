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
        stations.add(index, station);
    }

    private void validateIndex(int index) {
        if (index > stations.size()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "노선의 범위를 벗어난 순서를 입력하셨습니다.");
        }
    }
}