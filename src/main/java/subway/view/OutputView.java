package subway.view;

import java.util.List;
import java.util.Map;

import static subway.view.MessagePrefix.INFO_PREFIX;
import static subway.view.MessagePrefix.OUTPUT_PREFIX;

public class OutputView {

    public static void printMainMenu() {
        System.out.println(OUTPUT_PREFIX + "메인 화면\n"
                + "1. 역 관리\n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료\n");
    }

    public static void printStationMenu() {
        System.out.println(OUTPUT_PREFIX + "역 관리 화면\n"
                + "1. 역 등록\n"
                + "2. 역 삭제\n"
                + "3. 역 조회\n"
                + "B. 돌아가기\n");
    }

    public static void printStationDeleteSuccess() {
        System.out.println(INFO_PREFIX + "지하철 역이 삭제되었습니다.\n");
    }

    public static void printStations(List<String> stations) {
        System.out.println(OUTPUT_PREFIX + "역 목록");
        stations.forEach(station -> System.out.println(INFO_PREFIX + station));
        System.out.println();
    }

    public static void printLineMenu() {
        System.out.println(OUTPUT_PREFIX + "노선 관리 화면\n"
                + "1. 노선 등록\n"
                + "2. 노선 삭제\n"
                + "3. 노선 조회\n"
                + "B. 돌아가기\n");
    }

    public static void printLineAddSuccess() {
        System.out.println(INFO_PREFIX + "지하철 노선이 등록되었습니다.\n");
    }

    public static void printLineDeleteSuccess() {
        System.out.println(INFO_PREFIX + "지하철 노선이 삭제되었습니다.\n");
    }

    public static void printLines(List<String> lines) {
        System.out.println(OUTPUT_PREFIX + "노선 목록");
        lines.forEach(line -> System.out.println(INFO_PREFIX + line));
        System.out.println();
    }

    public static void printSectionMenu() {
        System.out.println(OUTPUT_PREFIX + "구간 관리 화면\n"
                + "1. 구간 등록\n"
                + "2. 구간 삭제\n"
                + "B. 돌아가기\n");
    }

    public static void printSectionAddSuccess() {
        System.out.println(INFO_PREFIX + "구간이 등록되었습니다.\n");
    }

    public static void printSectionDeleteSuccess() {
        System.out.println(INFO_PREFIX + "구간이 삭제되었습니다.\n");
    }

    public static void printSubwayLoad(Map<String, List<String>> sections) {
        System.out.println(OUTPUT_PREFIX + "지하철 노선도");
        sections.keySet().forEach(line -> {
            System.out.println(INFO_PREFIX + line);
            System.out.println(INFO_PREFIX + "---");
            sections.get(line).forEach(station -> System.out.println(INFO_PREFIX + station));
            System.out.println();
        });
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
