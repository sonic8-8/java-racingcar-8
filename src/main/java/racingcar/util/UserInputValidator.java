package racingcar.util;

import racingcar.exception.GameException;

public class UserInputValidator {
    public void validatePositiverNumber(String userInput) {
        int number;
        try {
            number = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 숫자 형식이어야 합니다.");
        }

        if (number <= 0) {
            throw new GameException("진행 횟수는 0보다 커야합니다.");
        }
    }

    public void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로만 설정할 수 있습니다.");
        }
        if (carName.isEmpty()) {
            throw new GameException("자동차 이름은 1자 이상으로 설정해야 합니다.");
        }
        // TODO: 중복 검증 필요

    }
}
