package baseball;

import nextstep.utils.Console;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class GameController {
    private Judgment judgment;
    private ConsolePrint consolePrint;

    public GameController() {
        judgment = new Judgment();
        consolePrint = new ConsolePrint();
    }

    public void play() {
        List<Integer> hitter = Hitter.generateHitter();
        fight(hitter);
        consolePrint.printSuccess();
        continuous();
    }

    private void continuous() {
        String value = retryInput();
        if (value.equals(Constants.GAME_CONTINUE))
            play();
        if  (value.equals(Constants.GAME_END))
            return;
    }

    private void fight(List<Integer> hitter) {
        try {
            consolePrint.printInputNumber();
            JudgmentResult judgmentResult = judgment.runJudge(hitter, Pitcher.getPitching(Console.readLine()));
            consolePrint.printCount(judgmentResult);
            if (judgmentResult.getStatus() == GameStatus.SUCCESS) return;
            fight(hitter);
        } catch (RuntimeException e) {
             e.printStackTrace();
             fight(hitter);
        }
    }

    private String retryInput() {
        try {
            consolePrint.printRetry();
            return Pitcher.getNumber(Console.readLine());
        } catch (RuntimeException e) {
            e.printStackTrace();
            return retryInput();
        }
    }
}
