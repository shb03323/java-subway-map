package subway.view;

import java.util.Scanner;

import static subway.view.MessagePrefix.OUTPUT_PREFIX;

public class InputView {

    private static final String INPUT_MENU = "원하는 기능을 선택하세요.";
    private static final String INPUT_STATION_ADD = "등록할 역 이름을 입력하세요.";
    private static final String INPUT_STATION_DELETE = "삭제할 역 이름을 입력하세요.";
    private static final String INPUT_LINE_ADD = "등록할 노선 이름을 입력하세요.";
    private static final String INPUT_STATION_UPPER = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_STATION_LOWER = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_LINE_DELETE = "삭제할 노선 이름을 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMenu() {
        System.out.println(OUTPUT_PREFIX + INPUT_MENU);
        String input = scanner.next();
        System.out.println();
        return input;
    }

    public static String inputStationAdd() {
        System.out.println(OUTPUT_PREFIX + INPUT_STATION_ADD);
        String input = scanner.next();
        System.out.println();
        return input;
    }

    public static String inputStationDelete() {
        System.out.println(OUTPUT_PREFIX + INPUT_STATION_DELETE);
        String input = scanner.next();
        System.out.println();
        return input;
    }

    public static String inputLineAdd() {
        System.out.println(OUTPUT_PREFIX + INPUT_LINE_ADD);
        String input = scanner.next();
        System.out.println();
        return input;
    }

    public static String inputUpperStation() {
        System.out.println(OUTPUT_PREFIX + INPUT_STATION_UPPER);
        String input = scanner.next();
        System.out.println();
        return input;
    }

    public static String inputLowerStation() {
        System.out.println(OUTPUT_PREFIX + INPUT_STATION_LOWER);
        String input = scanner.next();
        System.out.println();
        return input;
    }

    public static String inputLineDelete() {
        System.out.println(OUTPUT_PREFIX + INPUT_LINE_DELETE);
        String input = scanner.next();
        System.out.println();
        return input;
    }
}
