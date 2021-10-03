package baseball;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

public class Hitter {
    public static List<Integer> generateHitter() {
        List<Integer> hitter= new ArrayList<>();

        while (hitter.size() < Constants.MAX_STATS_LENGTH) {
            int n = Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
            if (!hitter.contains(n)) {
                hitter.add(n);
            }
        }

        return hitter;
    }
}
