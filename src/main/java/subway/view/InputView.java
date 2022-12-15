package subway.view;

import java.util.Scanner;

import static subway.view.MessagePrefix.OUTPUT_PREFIX;

public class InputView {

    private static final String INPUT_MENU = "원하는 기능을 선택하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMenu() {
        System.out.println(OUTPUT_PREFIX + INPUT_MENU);
        return scanner.next();
    }
}
