package subway.controller;

import subway.domain.SectionRepository;
import subway.view.OutputView;

public class PrintSubwayController implements Controllable {

    @Override
    public void runMenu() {
        OutputView.printSubwayLoad(SectionRepository.getSubwayLoad());
    }
}
