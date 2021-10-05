package baseball;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mockStatic;

class JudgmentTest {
    private Judgment judgment;
    private List<Integer> hitter;

    @BeforeEach
    public void setUp() {
        judgment = new Judgment();
        List<Integer> hitter = Hitter.generateHitter();
    }

    @Test
    public void 스트라이크_개수_체크() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            // given
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(8, 3, 5);
            List<Integer> hitter = Hitter.generateHitter();

            // when
            List<Integer> pitching1  = new ArrayList<>();
            pitching1.add(4);
            pitching1.add(3);
            pitching1.add(6);

            List<Integer> pitching2  = new ArrayList<>();
            pitching2.add(4);
            pitching2.add(3);
            pitching2.add(5);

            List<Integer> pitching3  = new ArrayList<>();
            pitching3.add(8);
            pitching3.add(3);
            pitching3.add(5);
            // then
            assertThat(judgment.strikeCount(hitter, pitching1)).isEqualTo(1);
            assertThat(judgment.strikeCount(hitter, pitching2)).isEqualTo(2);
            assertThat(judgment.strikeCount(hitter, pitching3)).isEqualTo(3);
        }
    }

    @Test
    public void 볼_개수_체크() {
        try (final MockedStatic<Randoms> mockrandoms = mockStatic(Randoms.class)) {
            // given
            mockrandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(8, 3, 5);
            List<Integer> hitter = Hitter.generateHitter();

            // when
            List<Integer> pitching1  = new ArrayList<>();
            pitching1.add(4);
            pitching1.add(8);
            pitching1.add(6);

            List<Integer> pitching2  = new ArrayList<>();
            pitching2.add(3);
            pitching2.add(4);
            pitching2.add(5);

            List<Integer> pitching3  = new ArrayList<>();
            pitching3.add(3);
            pitching3.add(5);
            pitching3.add(8);

            List<Integer> pitching4  = new ArrayList<>();
            pitching4.add(8);
            pitching4.add(3);
            pitching4.add(5);
            // then
            assertThat(judgment.ballCount(hitter, pitching1)).isEqualTo(1);
            assertThat(judgment.ballCount(hitter, pitching2)).isEqualTo(1);
            assertThat(judgment.ballCount(hitter, pitching3)).isEqualTo(3);
            assertThat(judgment.ballCount(hitter, pitching4)).isEqualTo(0);
        }
    }

    @Test
    public void 심판_결과_객체_값_체크() {

        try (final MockedStatic<Randoms> mockrandoms = mockStatic(Randoms.class)) {
            // given
            mockrandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(8, 3, 5);

            List<Integer> hitter = Hitter.generateHitter();

            List<Integer> pitching1  = new ArrayList<>();
            pitching1.add(5);
            pitching1.add(3);
            pitching1.add(6);

            // when
            JudgmentResult judgmentResult = judgment.runJudge(hitter, pitching1);

            // then
            assertThat(judgmentResult.getStrike()).isEqualTo(1);
            assertThat(judgmentResult.getBall()).isEqualTo(1);
        }
    }
}