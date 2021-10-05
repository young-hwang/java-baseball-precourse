package baseball;

import baseball.exception.DuplicateNumberException;
import baseball.exception.NotValidLengthException;
import baseball.exception.NotValidValueException;

import java.util.*;
import java.util.regex.Pattern;

public class Pitcher {
    public static List<Integer> getPitching(String numbers) {
        if (!validLength(numbers, Constants.MAX_STATS_LENGTH)) {
            throw new NotValidLengthException(String.format(Constants.ERROR_LENGTH, Constants.MAX_STATS_LENGTH));
        }
        if (!validValues(numbers)) {
            throw new NotValidValueException(Constants.ERROR_VALUE);
        }
        if (!validUniqueNumber(numbers)) {
            throw new DuplicateNumberException(Constants.ERROR_DUPLICATE_VALUE);
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

    public static boolean validUniqueNumber(String numbers) {
        Set<String> nums = new HashSet<String>(Arrays.asList(numbers.split("")));
        return nums.size() == Constants.MAX_STATS_LENGTH;
    }

    public static boolean validValues(String numbers) {
        return Pattern.matches("[1-9]+", numbers);
    }

    public static boolean validRetryValue(String numbers) {
        return Pattern.matches("[1-2]+", numbers);
    }
    public static boolean validLength(String numbers, int length) {
        Pattern pattern = Pattern.compile(".{" + length + "}");
        return pattern.matcher(numbers).matches();
    }

    public static String getNumber(String number) {
        if (!validLength(number, Constants.GAME_CONTINUE_LENGTH)) {
            throw new NotValidLengthException(String.format(Constants.ERROR_LENGTH, Constants.GAME_CONTINUE_LENGTH));
        }
        if (!validRetryValue(number)) {
            throw new NotValidValueException(Constants.ERROR_RETRY_VALUE);
        }
        return number;
    }
}
