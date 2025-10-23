package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.model.RoundManager;
import racingcar.util.UserInputCarNameParser;
import racingcar.util.UserInputValidator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        RoundManager roundManager = new RoundManager();
        UserInputValidator userInputValidator = new UserInputValidator();
        UserInputCarNameParser parser = new UserInputCarNameParser();

        RacingCar racingCar = new RacingCar(inputHandler, outputHandler, parser, roundManager, userInputValidator);
        racingCar.run();
    }
}
