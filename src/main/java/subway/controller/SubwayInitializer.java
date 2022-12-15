package subway.controller;

import subway.domain.*;

public class SubwayInitializer {

    public static void init() {
        initStation();
        initLine();
        initSection();
    }

    private static void initStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private static void initLine() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private static void initSection() {
        initLineTwoSection(LineRepository.findByName("2호선"));
        initLineThreeSection(LineRepository.findByName("3호선"));
        initLineSinbundangSection(LineRepository.findByName("신분당선"));
    }

    private static void initLineTwoSection(Line line) {
        SectionRepository.addLine(line);
        SectionRepository.addSection(line, StationRepository.findByName("교대역"), 0);
        SectionRepository.addSection(line, StationRepository.findByName("강남역"), 1);
        SectionRepository.addSection(line, StationRepository.findByName("역삼역"), 2);
    }

    private static void initLineThreeSection(Line line) {
        SectionRepository.addLine(line);
        SectionRepository.addSection(line, StationRepository.findByName("교대역"), 0);
        SectionRepository.addSection(line, StationRepository.findByName("남부터미널역"), 1);
        SectionRepository.addSection(line, StationRepository.findByName("양재역"), 2);
        SectionRepository.addSection(line, StationRepository.findByName("매봉역"), 3);
    }

    private static void initLineSinbundangSection(Line line) {
        SectionRepository.addLine(line);
        SectionRepository.addSection(line, StationRepository.findByName("강남역"), 0);
        SectionRepository.addSection(line, StationRepository.findByName("양재역"), 1);
        SectionRepository.addSection(line, StationRepository.findByName("양재시민의숲역"), 2);
    }
}
