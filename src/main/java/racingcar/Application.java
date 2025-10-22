package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.model.RoundManager;
import racingcar.util.CarNameValidator;
import racingcar.util.UserInputCarNameParser;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        RoundManager roundManager = new RoundManager();
        CarNameValidator carNameValidator = new CarNameValidator();

        UserInputCarNameParser parser = new UserInputCarNameParser(carNameValidator);

        RacingCar racingCar = new RacingCar(inputHandler, outputHandler, parser, roundManager);
        racingCar.run();
    }
}
