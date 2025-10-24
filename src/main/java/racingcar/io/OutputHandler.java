package racingcar.io;

import racingcar.model.Car;

import java.util.ArrayList;
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

    public void showRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int dist = 0; dist < car.getDistance(); dist++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showGameWinnersFrom(List<Car> cars) {
        System.out.print("최종 우승자 : ");

        List<String> winners = new ArrayList<>();

        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }

        for (String winner : winners) {
            if (winner.equals(winners.getLast())) {
                System.out.println(winner);
                break;
            }
            System.out.print(winner + ", ");
        }
    }
}