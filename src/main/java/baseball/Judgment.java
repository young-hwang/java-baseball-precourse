package baseball;

import java.util.ArrayList;
import java.util.List;

public class Judgment {
    public Judgment() {
    }

    public JudgmentResult runJudge(List<Integer> hitter, List<Integer> pitching) {
        JudgmentResult judgementResult = new JudgmentResult();
        judgementResult.setStrike(strikeCount(hitter, pitching));
        judgementResult.setBall(ballCount(hitter, pitching));
        return judgementResult;
    }

    public int strikeCount(List<Integer> hitter, List<Integer> pitching) {
        int strike = 0;
        for (int i = 0; i < Constants.MAX_STATS_LENGTH; i++) {
            if (hitter.get(i) == pitching.get(i))
                strike++;
        }
        return strike;
    }

    public int ballCount(List<Integer> hitter, List<Integer> pitching) {
        int ball = 0;
        for (int i = 0; i < Constants.MAX_STATS_LENGTH; i++) {
            if (hitter.get(i) != pitching.get(i) && hitter.contains(pitching.get(i)))
                ball++;
        }
        return ball;
    }
}
