package baseball;

import baseball.exception.NotValidLengthException;
import baseball.exception.NotValidValueException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class PitchingTest {
    @Test
    public void 입력값_길이_유효_확인() {
        // then
        assertThat(Pitching.validLength("456")).isEqualTo(true);
        assertThat(Pitching.validLength("4567")).isEqualTo(false);
    }

    @Test
    public void 입력값_유효_숫자_확인() {
        // then
        assertThat(Pitching.validValue("457")).isEqualTo(true);
        assertThat(Pitching.validValue("4a7")).isEqualTo(false);
    }

    @Test
    public void 입력값_길이_에러_출력_확인() {
        // when
        Throwable thrown = catchThrowable(() -> Pitching.getPitching("3878"));

        // then
        assertThat(thrown).isInstanceOf(NotValidLengthException.class);
    }

    @Test
    public void 입력값_유효_에러_출력_확인() {
        // when
        Throwable thrown = catchThrowable(() -> Pitching.getPitching("3B8"));

        // then
        assertThat(thrown).isInstanceOf(NotValidValueException.class);
    }

    @Test
    public void 입력값_리스트_출력_확인() {
        // when
        List<Integer> nums = Pitching.getPitching("478");

        // then
        assertThat(nums).contains(4, 7, 8);
    }
}