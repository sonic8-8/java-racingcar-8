package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class UserInputCarNameParser {
    public List<String> parse(String userInput) {
        return Arrays.stream(userInput.split(",")).toList();
    }
}
