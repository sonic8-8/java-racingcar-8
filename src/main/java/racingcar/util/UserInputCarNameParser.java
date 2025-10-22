package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInputCarNameParser {
    private final CarNameValidator validator;

    public UserInputCarNameParser(CarNameValidator validator) {
        this.validator = validator;
    }

    public List<String> parse(String userInput) {
        if (userInput.contains(",")) {
            String[] split = userInput.split(",");

            for (String carName : split) {
                validator.validate(carName);
            }

            return Arrays.stream(split).toList();
        }

        List<String> carNames = new ArrayList<>();
        carNames.add(userInput);
        return carNames;
    }
}
