package racingcar.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputCarNameParserTest {
    @DisplayName("사용자 입력을 쉼표를 기준으로 파싱한다.")
    @Test
    void parse() {
        // given
        String userInput = "carA,carB,carC";
        UserInputCarNameParser parser = new UserInputCarNameParser();

        // when
        List<String> carNames = parser.parse(userInput);

        // then
        assertThat(carNames)
                .containsExactly("carA", "carB", "carC");
    }

    @DisplayName("자동차 이름이 하나만 입력될 경우 리스트에 하나만 담아 반환한다.")
    @Test
    void parse_singleName() {
        // given
        String userInput = "carA";
        UserInputCarNameParser parser = new UserInputCarNameParser();

        // when
        List<String> carNames = parser.parse(userInput);

        // then
        assertThat(carNames)
                .containsExactly("carA");
    }

    @DisplayName("사용자 입력에 빈 문자열이 포함되더라도 포함하여 파싱한다.")
    @Test
    void parse_withEmpty() {
        // given
        String userInput = "carA,,carB";
        UserInputCarNameParser parser = new UserInputCarNameParser();

        // when
        List<String> carNames = parser.parse(userInput);

        // then
        assertThat(carNames)
                .containsExactly("carA", "", "carB");
    }
}