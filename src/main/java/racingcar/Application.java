package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.processor.UserInputCarNameParser;
import racingcar.processor.UserInputValidator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        RoundManager roundManager = new RoundManager();
        UserInputValidator userInputValidator = new UserInputValidator();
        UserInputCarNameParser parser = new UserInputCarNameParser();

        RacingGame racingGame = new RacingGame(inputHandler, outputHandler, parser, roundManager, userInputValidator);
        racingGame.run();
    }
}
