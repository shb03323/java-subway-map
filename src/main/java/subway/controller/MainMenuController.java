package subway.controller;

import subway.domain.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class MainMenuController {

    private final Map<MainMenu, Controllable> controllers;

    public MainMenuController() {
        this.controllers = new EnumMap<>(MainMenu.class);
        initControllers();
    }

    public void run() {
        OutputView.printMainMenu();
        MainMenu selection = selectMenu();
        while (!selection.equals(MainMenu.QUIT)) {
            progress(selection);
        }
    }

    private void initControllers() {
        controllers.put(MainMenu.STATION_MENU, new StationController());
        controllers.put(MainMenu.LINE_MENU, new LineController());
        controllers.put(MainMenu.SECTION_MENU, new SectionController());
        controllers.put(MainMenu.PRINT_SUBWAY_MENU, new PrintSubwayController());
        controllers.put(MainMenu.QUIT, new QuitSystemController());
    }

    private MainMenu selectMenu() {
        try {
            String command = InputView.inputMenu();
            return MainMenu.from(command);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return selectMenu();
        }
    }

    private void progress(MainMenu selection) {
        controllers.get(selection).process();
    }
}
