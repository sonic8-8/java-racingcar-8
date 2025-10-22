package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class RacingCar {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingCar(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        outputHandler.askCarNames();
        String userInput = inputHandler.getCarNamesFromUser();

        // TODO: 파싱 후 자동차 이동 거리를 관리할 객체에 추가하기

        // TODO: 횟수 진행
        // round 진행을 담당할 객체가 필요한 듯

        // TODO: 우승자 출력
        // round 진행을 담당한 객체에게 우승자를 묻고 가져오기
        outputHandler.showGameWinnersFrom();
    }
}
