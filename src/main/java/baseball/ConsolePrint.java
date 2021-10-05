package baseball;

import com.sun.javafx.binding.StringFormatter;

import java.util.NoSuchElementException;

public class ConsolePrint {
    public void printInputNumber() {
        System.out.println(Constants.PRINT_INPUT_NUMBER);
    }

    public void printCount(JudgmentResult judgmentResult) {
        String value = "";
        if (judgmentResult.getStrike() > 0) {
            value += String.format(Constants.PRINT_STRIKE_COUNT, judgmentResult.getStrike());
        }
        if (judgmentResult.getStrike() > 0 && judgmentResult.getBall() > 0) {
            value += " ";
        }
        if (judgmentResult.getBall() > 0) {
            value += String.format(Constants.PRINT_BALL_COUNT, judgmentResult.getBall());
        }
        if (judgmentResult.getStrike() <= 0 && judgmentResult.getBall() <= 0) {
            value += Constants.PRINT_NOTHING;
        }
        System.out.println(value);
    }

    public void printRetry() {
        System.out.println(Constants.PRINT_RETRY_MESSAGE);
    }
    public void printSuccess() {
        System.out.println(Constants.PRINT_SUCCESS_MESSAGE);
    }
}
