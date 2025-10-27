package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.converter.AttemptCountConverter;
import racingcar.converter.CarsConverter;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.model.strategy.AlwaysMoveStrategy;
import racingcar.processor.UserInputCarNameParser;
import racingcar.processor.UserInputValidator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    private final PrintStream originalOutputStream = System.out;
    private final InputStream originalInputStream = System.in;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOutputStream);
        System.setIn(originalInputStream);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("사용자 입력이 정상적일 경우, 게임이 올바르게 실행된다.")
    @Test
    void run() {
        // given
        AlwaysMoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        UserInputValidator userInputValidator = new UserInputValidator();
        UserInputCarNameParser userInputCarNameParser = new UserInputCarNameParser();

        AttemptCountConverter attemptCountConverter = new AttemptCountConverter(userInputValidator);
        CarsConverter carsConverter = new CarsConverter(userInputCarNameParser, userInputValidator);

        RacingGame racingGame = new RacingGame(inputHandler, outputHandler, carsConverter, attemptCountConverter, alwaysMoveStrategy);

        String carNames = "carA,carB";
        String attemptCount = "3";
        String lineSeparator = System.lineSeparator();
        setInput(carNames + lineSeparator + attemptCount);

        // when
        racingGame.run();

        // then
        assertThat(outputStream.toString()).isEqualTo(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + lineSeparator +
                        "시도할 횟수는 몇 회인가요?" + lineSeparator +
                        lineSeparator +
                        "실행 결과" + lineSeparator +
                        "carA : -" + lineSeparator +
                        "carB : -" + lineSeparator +
                        lineSeparator +
                        "carA : --" + lineSeparator +
                        "carB : --" + lineSeparator +
                        lineSeparator +
                        "carA : ---" + lineSeparator +
                        "carB : ---" + lineSeparator +
                        lineSeparator +
                        "최종 우승자 : carA, carB"
        );
    }

    @DisplayName("5자를 초과하는 이름 입력 시 IllegalArgumentException을 발생시키고 프로그램을 종료한다.")
    @Test
    void run_withInvalidUserInput() {
        // given
        AlwaysMoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        UserInputValidator userInputValidator = new UserInputValidator();
        UserInputCarNameParser userInputCarNameParser = new UserInputCarNameParser();

        AttemptCountConverter attemptCountConverter = new AttemptCountConverter(userInputValidator);
        CarsConverter carsConverter = new CarsConverter(userInputCarNameParser, userInputValidator);

        RacingGame racingGame = new RacingGame(inputHandler, outputHandler, carsConverter, attemptCountConverter, alwaysMoveStrategy);

        String carNames = "car100,carA";
        setInput(carNames);

        // when then
        assertThatThrownBy(racingGame::run)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로만 설정할 수 있습니다.");
    }
}