package baseball;

import baseball.exception.NotValidLengthException;
import baseball.exception.NotValidValueException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class PitcherTest {
    @Test
    public void 입력값_길이_유효_확인() {
        // then
        assertThat(Pitcher.validLength("456", Constants.MAX_STATS_LENGTH)).isEqualTo(true);
        assertThat(Pitcher.validLength("4567", Constants.MAX_STATS_LENGTH)).isEqualTo(false);
    }

    @Test
    public void 입력값_유효_숫자_확인() {
        // then
        assertThat(Pitcher.validValues("457")).isEqualTo(true);
        assertThat(Pitcher.validValues("4a7")).isEqualTo(false);
    }

    @Test
    public void 입력값_유일_유부_확인() {
        // then
        assertThat(Pitcher.validUniqueNumber("557")).isEqualTo(false);
        assertThat(Pitcher.validUniqueNumber("467")).isEqualTo(true);
    }

    @Test
    public void 입력값_길이_에러_출력_확인() {
        // when
        Throwable thrown = catchThrowable(() -> Pitcher.getPitching("3878"));

        // then
        assertThat(thrown).isInstanceOf(NotValidLengthException.class);
    }

    @Test
    public void 입력값_유효_에러_출력_확인() {
        // when
        Throwable thrown = catchThrowable(() -> Pitcher.getPitching("3B8"));

        // then
        assertThat(thrown).isInstanceOf(NotValidValueException.class);
    }

    @Test
    public void 입력값_리스트_출력_확인() {
        // when
        List<Integer> nums = Pitcher.getPitching("478");

        // then
        assertThat(nums).contains(4, 7, 8);
    }
}