package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class SectionController implements Controllable {

    private final Map<SectionMenu, Runnable> sectionRunOptions = new EnumMap<>(SectionMenu.class);

    public SectionController() {
        initRunOptions();
    }

    @Override
    public void runMenu() {
        try {
            OutputView.printSectionMenu();
            SectionMenu selection = selectMenu();
            progress(selection);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            runMenu();
        }
    }

    private void initRunOptions() {
        sectionRunOptions.put(SectionMenu.SECTION_ADD, this::addSection);
        sectionRunOptions.put(SectionMenu.SECTION_DELETE, this::deleteSection);
        sectionRunOptions.put(SectionMenu.BACK, this::goBack);
    }

    private SectionMenu selectMenu() {
        String command = InputView.inputMenu();
        return SectionMenu.from(command);
    }

    private void progress(SectionMenu sectionMenu) {
        sectionRunOptions.get(sectionMenu).run();
    }

    private void addSection() {
        String lineName = InputView.inputLine();
        Line line = LineRepository.findByName(lineName);
        String stationName = InputView.inputStation();
        Station station = StationRepository.findByName(stationName);
        int index = InputView.inputSequence();
        SectionRepository.addSection(line, station, index);
    }

    private void deleteSection() {
        String stationName = InputView.inputStationDelete();
        StationRepository.deleteStation(stationName);
        OutputView.printStationDeleteSuccess();
    }

    private void goBack() {}
}
