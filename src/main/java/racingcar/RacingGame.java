package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.processor.UserInputCarNameParser;
import racingcar.processor.UserInputValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final UserInputCarNameParser parser;
    private final UserInputValidator validator;

    public RacingGame(InputHandler inputHandler, OutputHandler outputHandler, UserInputCarNameParser parser, UserInputValidator validator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.parser = parser;
        this.validator = validator;
    }

    public void run() {
        outputHandler.askCarNames();
        String userInput = inputHandler.getUserInput();

        List<String> carNames = parser.parse(userInput);

        // TODO: 메서드 추출
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            validator.validateCarNameLength(carName);
            carList.add(Car.of(carName, 0));
        }
        Cars cars = Cars.of(carList);
        // -----

        outputHandler.askAttemptCount();
        String numberCandidate = inputHandler.getUserInput();
        validator.validatePositiverNumber(numberCandidate);
        int number = Integer.parseInt(numberCandidate);

        outputHandler.showExecutionResultMessage();

        for (int round = 0; round < number; round++) {
            cars.playRound();
            outputHandler.showRoundResult(cars.snapshot());
        }

        outputHandler.showGameWinnersFrom(cars.findWinners());
    }
}
