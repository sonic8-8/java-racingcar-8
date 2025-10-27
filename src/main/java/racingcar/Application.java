package racingcar;

import racingcar.converter.AttemptCountConverter;
import racingcar.converter.CarsConverter;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.model.strategy.MoveStrategy;
import racingcar.model.strategy.RandomMoveStrategy;
import racingcar.processor.UserInputCarNameParser;
import racingcar.processor.UserInputValidator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        UserInputValidator userInputValidator = new UserInputValidator();
        UserInputCarNameParser userInputCarNameParser = new UserInputCarNameParser();
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        AttemptCountConverter attemptCountConverter = new AttemptCountConverter(userInputValidator);
        CarsConverter carsConverter = new CarsConverter(userInputCarNameParser, userInputValidator);

        RacingGame racingGame = new RacingGame(inputHandler, outputHandler, carsConverter, attemptCountConverter, moveStrategy);
        racingGame.run();
    }
}
