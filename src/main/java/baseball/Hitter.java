package baseball;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

public class Hitter {
    private List<Integer> stats;
    private static Hitter hitter = new Hitter();

    public Hitter() {
    }

    public static Hitter getHitter() {
        return hitter;
    }

    public List<Integer> getStats() {
        return stats;
    }

    public void generateStats() {
        stats = new ArrayList<>();

        while (stats.size() < Constants.MAX_STATS_LENGTH) {
            int n = Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
            if (!stats.contains(n)) {
                stats.add(n);
            }
        }
    }
}
