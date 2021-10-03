package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HitterTest {
    private Hitter hitter;

    @Test
    public void 숫자_길이_확인() {
        // given
        // when
        List<Integer> hitter = Hitter.generateHitter();
        // then
        assertThat(hitter.size()).isEqualTo(3);
    }

    @RepeatedTest(10)
    @Test
    public void 숫자_중복_생성_확인() {
        // given
        // when
        List<Integer> hitter = Hitter.generateHitter();
        // then
        assertThat(hasDuplicateNumber(hitter)).isEqualTo(false);
    }

    private boolean hasDuplicateNumber(List<Integer> stats) {
        List<Integer> duplicate = new ArrayList<>();

        for (int i = 0; i < stats.size() - 1; i++) {
            int n = stats.get(i);
            List<Integer> subList = stats.subList(i + 1, stats.size());
            if (subList.contains(n)) {
                duplicate.add(n);
            };
        }
        return duplicate.size() > 0 ? true : false;
    }
}