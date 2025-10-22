package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.model.RoundManager;
import racingcar.util.UserInputCarNameParser;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final UserInputCarNameParser parser;
    private final RoundManager roundManager;

    private List<CarInfo> carInfos = new ArrayList<>();

    public RacingCar(InputHandler inputHandler, OutputHandler outputHandler, UserInputCarNameParser parser, RoundManager roundManager) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.parser = parser;
        this.roundManager = roundManager;
    }

    public void run() {
        outputHandler.askCarNames();
        String userInput = inputHandler.getCarNamesFromUser();

        List<String> carNames = parser.parse(userInput);
        for (String carName : carNames) {
            carInfos.add(CarInfo.of(carName, 0));
        }

        outputHandler.askAttemptCount();
        int count = inputHandler.getAttemptCountFromUser();

        for (int round = 0; round < count; round++) {
            roundManager.play(carInfos);
            outputHandler.showRoundResult(carInfos);
        }

        outputHandler.showGameWinnersFrom(carInfos);
    }
}
