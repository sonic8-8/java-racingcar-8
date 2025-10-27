package racingcar.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputValidatorTest {
    @DisplayName("시도 횟수에 문자가 포함될 경우 예외가 발생한다.")
    @Test
    void validatePositiverNumber_notNumber() {
        // given
        String userInput = "3번";
        UserInputValidator validator = new UserInputValidator();

        // when then
        assertThatThrownBy(() -> validator.validatePositiverNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 숫자 형식이어야 합니다.");
    }

    @DisplayName("시도 횟수가 음수일 경우 예외가 발생한다.")
    @Test
    void validatePositiverNumber_withNegative() {
        // given
        String userInput = "-1";
        UserInputValidator validator = new UserInputValidator();

        // when then
        assertThatThrownBy(() -> validator.validatePositiverNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("진행 횟수는 0보다 커야합니다.");
    }

    @DisplayName("시도 횟수가 0일 경우 예외가 발생한다.")
    @Test
    void validatePositiverNumber_withZero() {
        // given
        String userInput = "0";
        UserInputValidator validator = new UserInputValidator();

        // when then
        assertThatThrownBy(() -> validator.validatePositiverNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("진행 횟수는 0보다 커야합니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과할 경우 예외가 발생한다.")
    @Test
    void validateCarNameLength_over() {
        // given
        String carName = "car100";
        UserInputValidator validator = new UserInputValidator();

        // when then
        assertThatThrownBy(() -> validator.validateCarNameLength(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로만 설정할 수 있습니다.");
    }

    @DisplayName("자동차 이름이 비어있을 경우 예외가 발생한다.")
    @Test
    void validateCarNameLength_withEmpty() {
        // given
        String carName = "";
        UserInputValidator validator = new UserInputValidator();

        // when then
        assertThatThrownBy(() -> validator.validateCarNameLength(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상으로 설정해야 합니다.");
    }

    @DisplayName("자동차 이름에 공백이 포함될 경우 예외가 발생한다.")
    @Test
    void validateCarNameLength_withBlank() {
        // given
        String carName = "ca r";
        UserInputValidator validator = new UserInputValidator();

        // when then
        assertThatThrownBy(() -> validator.validateCarNameLength(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백을 넣을 수 없습니다.");
    }

    @DisplayName("자동차 이름 목록에 중복이 있을 경우 예외가 발생한다.")
    @Test
    void validateDuplicateCarNames_withDuplicates() {
        // given
        List<String> cars = List.of("carA", "carA", "carB");
        UserInputValidator validator = new UserInputValidator();

        // when then
        assertThatThrownBy(() -> validator.validateDuplicateCarNames(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 중복이 있습니다.");
    }
}