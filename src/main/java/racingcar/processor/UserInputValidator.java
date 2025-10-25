package racingcar.processor;

import java.util.HashSet;
import java.util.List;

public class UserInputValidator {
    public void validatePositiverNumber(String userInput) {
        int number;
        try {
            number = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 숫자 형식이어야 합니다.");
        }

        if (number <= 0) {
            throw new IllegalArgumentException("진행 횟수는 0보다 커야합니다.");
        }
    }

    public void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로만 설정할 수 있습니다.");
        }
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상으로 설정해야 합니다.");
        }

        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백을 넣을 수 없습니다.");
        }
    }

    public void validateDuplicateCarNames(List<String> carNames) {
        HashSet<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 있습니다.");
        }
    }
}
