package racingcar;

import racingcar.converter.AttemptCountConverter;
import racingcar.converter.CarsConverter;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.model.Cars;

public class RacingGame {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final CarsConverter carsConverter;
    private final AttemptCountConverter attemptCountConverter;

    private Cars cars;
    private int attemptCount;

    public RacingGame(InputHandler inputHandler, OutputHandler outputHandler, CarsConverter carsConverter, AttemptCountConverter attemptCountConverter) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.carsConverter = carsConverter;
        this.attemptCountConverter = attemptCountConverter;
    }

    public void run() {
        initialize();

        playRounds();

        showWinners();
    }

    private void initialize() {
        cars = getCarsFromUser();
        attemptCount = getAttemptCountFromUser();
    }

    private Cars getCarsFromUser() {
        outputHandler.askCarNames();
        String carNamesCandidate = inputHandler.getUserInput();
        return carsConverter.convertCarsFrom(carNamesCandidate);
    }

    private int getAttemptCountFromUser() {
        outputHandler.askAttemptCount();
        String attemptCountCandidate = inputHandler.getUserInput();
        return attemptCountConverter.convertAttemptCountFrom(attemptCountCandidate);
    }

    private void playRounds() {
        outputHandler.showExecutionResultMessage();
        for (int round = 0; round < attemptCount; round++) {
            cars.playRound();
            outputHandler.showRoundResult(cars.snapshot());
        }
    }

    private void showWinners() {
        outputHandler.showGameWinnersFrom(cars.findWinners());
    }
}
