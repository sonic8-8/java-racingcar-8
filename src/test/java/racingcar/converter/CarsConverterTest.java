package racingcar.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.processor.UserInputCarNameParser;
import racingcar.processor.UserInputValidator;

import static org.assertj.core.api.Assertions.*;

class CarsConverterTest {
    @DisplayName("사용자 입력을 일급 컬렉션 Cars 객체로 변환한다.")
    @Test
    void convertCarsFrom() {
        // given
        UserInputCarNameParser parser = new UserInputCarNameParser();
        UserInputValidator validator = new UserInputValidator();
        CarsConverter carsConverter = new CarsConverter(parser, validator);

        String userInput = "carA,carB,carC";

        // when
        Cars cars = carsConverter.convertCarsFrom(userInput);

        // then
        assertThat(cars.snapshot())
                .extracting("name", "distance")
                .containsExactly(
                        tuple("carA", 0),
                        tuple("carB", 0),
                        tuple("carC", 0)
                );
    }

    @DisplayName("중복된 자동차 이름 입력 시 예외가 발생한다.")
    @Test
    void convertCarsFrom_withDuplicates() {
        // given
        UserInputCarNameParser parser = new UserInputCarNameParser();
        UserInputValidator validator = new UserInputValidator();
        CarsConverter carsConverter = new CarsConverter(parser, validator);

        String userInput = "carA,carA,carB";

        // when then
        assertThatThrownBy(() -> carsConverter.convertCarsFrom(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 중복이 있습니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    @Test
    void convertCarsFrom_withLongName() {
        // given
        UserInputCarNameParser parser = new UserInputCarNameParser();
        UserInputValidator validator = new UserInputValidator();
        CarsConverter carsConverter = new CarsConverter(parser, validator);

        String userInput = "car1000,carA,carB";

        // when then
        assertThatThrownBy(() -> carsConverter.convertCarsFrom(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로만 설정할 수 있습니다.");
    }
}