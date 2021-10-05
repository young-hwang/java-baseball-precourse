package baseball;

import baseball.exception.NotValidLengthException;
import baseball.exception.NotValidValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pitching {
    public static List<Integer> getPitching(String numbers) {
        if (!validLength(numbers)) {
            throw new NotValidLengthException("[ERROR] 길이는 3자리 입니다.");
        }
        if (!validValue(numbers)) {
            throw new NotValidValueException("[ERROR] 숫자가 아닌 값이 있습니다.");
        }

        return convertList(numbers);
    }

    private static List<Integer> convertList(String numbers) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            nums.add(Character.getNumericValue(numbers.charAt(i)));
        }
        return nums;
    }

    public static boolean validValue(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) < '0' || numbers.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean validLength(String numbers) {
        return numbers.length() == Constants.MAX_STATS_LENGTH ? true : false;
    }
}
