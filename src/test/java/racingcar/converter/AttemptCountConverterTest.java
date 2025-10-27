package racingcar.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.processor.UserInputValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptCountConverterTest {
    @DisplayName("사용자 입력을 숫자로 변환한다.")
    @Test
    void convertAttemptCountFrom() {
        // given
        UserInputValidator validator = new UserInputValidator();
        AttemptCountConverter converter = new AttemptCountConverter(validator);

        String userInput = "5";

        // when
        int attemptCount = converter.convertAttemptCountFrom(userInput);

        // then
        assertThat(attemptCount).isEqualTo(5);
    }

    @DisplayName("음수일 경우 예외가 발생한다.")
    @Test
    void convertAttemptCountFrom_withNegative() {
        // given
        UserInputValidator validator = new UserInputValidator();
        AttemptCountConverter converter = new AttemptCountConverter(validator);

        String userInput = "-1";

        // when
        assertThatThrownBy(() -> converter.convertAttemptCountFrom(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("진행 횟수는 0보다 커야합니다.");
    }

    @DisplayName("시도 횟수에 문자가 포함될 경우 예외가 발생한다.")
    @Test
    void convertAttemptCountFrom_NotNumber() {
        // given
        UserInputValidator validator = new UserInputValidator();
        AttemptCountConverter converter = new AttemptCountConverter(validator);

        String userInput = "3번";

        // when then
        assertThatThrownBy(() -> converter.convertAttemptCountFrom(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 숫자 형식이어야 합니다.");
    }
}