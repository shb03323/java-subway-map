package subway.controller;

import subway.domain.Station;
import subway.domain.StationMenu;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class StationController implements Controllable {

    private final Map<StationMenu, Runnable> stationRunOptions = new EnumMap<>(StationMenu.class);

    public StationController() {
        initRunOptions();
    }

    @Override
    public void runMenu() {
        try {
            OutputView.printStationMenu();
            StationMenu selection = selectMenu();
            progress(selection);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            runMenu();
        }
    }

    private void initRunOptions() {
        stationRunOptions.put(StationMenu.STATION_ADD, this::addStation);
        stationRunOptions.put(StationMenu.STATION_DELETE, this::deleteStation);
        stationRunOptions.put(StationMenu.STATION_SEARCH, this::searchStation);
        stationRunOptions.put(StationMenu.BACK, this::goBack);
    }

    private StationMenu selectMenu() {
        String command = InputView.inputMenu();
        return StationMenu.from(command);
    }

    private void progress(StationMenu stationMenu) {
        stationRunOptions.get(stationMenu).run();
    }

    private void addStation() {
        String stationName = InputView.inputStationAdd();
        StationRepository.addStation(new Station(stationName));
    }

    private void deleteStation() {

    }

    private void searchStation() {

    }

    private void goBack() {

    }
}
