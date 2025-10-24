package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.processor.UserInputCarNameParser;
import racingcar.processor.UserInputValidator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        UserInputValidator userInputValidator = new UserInputValidator();
        UserInputCarNameParser parser = new UserInputCarNameParser();

        RacingGame racingGame = new RacingGame(inputHandler, outputHandler, parser, userInputValidator);
        racingGame.run();
    }
}
