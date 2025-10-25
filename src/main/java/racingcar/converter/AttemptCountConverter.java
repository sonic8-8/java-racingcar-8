package racingcar.converter;

import racingcar.processor.UserInputValidator;

public class AttemptCountConverter {
    private final UserInputValidator validator;

    public AttemptCountConverter(UserInputValidator validator) {
        this.validator = validator;
    }

    public int convertAttemptCountFrom(String userInput) {
        validator.validatePositiverNumber(userInput);
        return Integer.parseInt(userInput);
    }
}
