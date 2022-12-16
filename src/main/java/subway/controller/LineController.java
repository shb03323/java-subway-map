package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LineController implements Controllable {

    private final Map<LineMenu, Runnable> lineRunOptions = new EnumMap<>(LineMenu.class);

    public LineController() {
        initRunOptions();
    }

    @Override
    public void runMenu() {
        try {
            OutputView.printLineMenu();
            LineMenu selection = selectMenu();
            progress(selection);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            runMenu();
        }
    }

    private void initRunOptions() {
        lineRunOptions.put(LineMenu.LINE_ADD, this::addLine);
        lineRunOptions.put(LineMenu.LINE_DELETE, this::deleteLine);
        lineRunOptions.put(LineMenu.LINE_SEARCH, this::searchLine);
        lineRunOptions.put(LineMenu.BACK, this::goBack);
    }

    private LineMenu selectMenu() {
        String command = InputView.inputMenu();
        return LineMenu.from(command);
    }

    private void progress(LineMenu lineMenu) {
        lineRunOptions.get(lineMenu).run();
    }

    private void addLine() {
        String lineName = InputView.inputLineAdd();
        String upperStationName = InputView.inputUpperStation();
        String lowerStationName = InputView.inputLowerStation();
        registerData(lineName, upperStationName, lowerStationName);
        OutputView.printLineAddSuccess();
    }

    private void registerData(String lineName, String upperStationName, String lowerStationName) {
        Station upperStation = StationRepository.findByName(upperStationName);
        Station lowerStation = StationRepository.findByName(lowerStationName);
        Line line = new Line(lineName);
        LineRepository.addLine(line);
        SectionRepository.addLine(line, upperStation, lowerStation);
    }

    private void deleteLine() {
        String lineName = InputView.inputLineDelete();
        LineRepository.deleteLineByName(lineName);
        OutputView.printLineDeleteSuccess();
    }

    private void searchLine() {
        List<String> lines = LineRepository.readLines();
        OutputView.printLines(lines);
    }

    private void goBack() {}
}
