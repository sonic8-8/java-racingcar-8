package racingcar.io;

import racingcar.dto.CarSnapshot;

import java.util.List;

public class OutputHandler {
    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showExecutionResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void showRoundResult(List<CarSnapshot> carSnapshots) {
        for (CarSnapshot carSnapshot : carSnapshots) {
            System.out.println(carSnapshot.name() + " : " + "-".repeat(carSnapshot.distance()));
        }
        System.out.println();
    }

    public void showGameWinnersFrom(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.print("최종 우승자 : " + winners);
    }
}