package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.model.RoundManager;
import racingcar.util.UserInputCarNameParser;
import racingcar.util.UserInputValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final UserInputCarNameParser parser;
    private final RoundManager roundManager;
    private final UserInputValidator validator;

    private List<CarInfo> carInfos = new ArrayList<>();

    public RacingCar(InputHandler inputHandler, OutputHandler outputHandler, UserInputCarNameParser parser, RoundManager roundManager, UserInputValidator validator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.parser = parser;
        this.roundManager = roundManager;
        this.validator = validator;
    }

    public void run() {
        outputHandler.askCarNames();
        String userInput = inputHandler.getUserInput();

        List<String> carNames = parser.parse(userInput);
        for (String carName : carNames) {
            validator.validateCarNameLength(carName);
            carInfos.add(CarInfo.of(carName, 0));
        }

        outputHandler.askAttemptCount();
        String numberCandidate = inputHandler.getUserInput();
        validator.validatePositiverNumber(numberCandidate);
        int number = Integer.parseInt(numberCandidate);

        outputHandler.showExecutionResultMessage();

        for (int round = 0; round < number; round++) {
            roundManager.play(carInfos);
            outputHandler.showRoundResult(carInfos);
        }

        outputHandler.showGameWinnersFrom(carInfos);
    }
}
