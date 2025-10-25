package racingcar;

import racingcar.converter.AttemptCountConverter;
import racingcar.converter.CarsConverter;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.processor.UserInputCarNameParser;
import racingcar.processor.UserInputValidator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        UserInputValidator userInputValidator = new UserInputValidator();
        UserInputCarNameParser userInputCarNameParser = new UserInputCarNameParser();

        AttemptCountConverter attemptCountConverter = new AttemptCountConverter(userInputValidator);
        CarsConverter carsConverter = new CarsConverter(userInputCarNameParser, userInputValidator);

        RacingGame racingGame = new RacingGame(inputHandler, outputHandler, carsConverter, attemptCountConverter);
        racingGame.run();
    }
}
