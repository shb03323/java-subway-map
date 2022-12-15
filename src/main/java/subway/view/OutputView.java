package subway.view;

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

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
