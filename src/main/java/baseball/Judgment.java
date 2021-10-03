package baseball;

import java.util.ArrayList;
import java.util.List;

public class Judgment {
    private int strikeCount;
    private int ballCount;

    public Judgment() {
    }

    public int getStrikeCount(List<Integer> hitter, List<Integer> pitching) {
        int strikeCount = 0;
        for (int i = 0; i < Constants.MAX_STATS_LENGTH; i++) {
            if (hitter.get(i) == pitching.get(i))
                strikeCount++;
        }
        return strikeCount;
    }

    public int getBallCount(List<Integer> hitter, List<Integer> pitching) {
        int ballCount = 0;
        for (int i = 0; i < Constants.MAX_STATS_LENGTH; i++) {
            if (hitter.get(i) != pitching.get(i) && hitter.contains(pitching.get(i)))
                ballCount++;
        }
        return ballCount;
    }
}
