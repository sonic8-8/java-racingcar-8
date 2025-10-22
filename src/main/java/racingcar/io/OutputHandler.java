package racingcar.io;

import racingcar.CarInfo;

import java.util.ArrayList;
import java.util.List;

public class OutputHandler {
    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showRoundResult(List<CarInfo> carInfos) {
        for (CarInfo carInfo : carInfos) {
            System.out.print(carInfo.getName() + " : ");
            for (int dist = 0; dist < carInfo.getDistance(); dist++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showGameWinnersFrom(List<CarInfo> carInfos) {
        System.out.print("최종 우승자 : ");

        List<String> winners = new ArrayList<>();

        int maxDistance = 0;
        for (CarInfo carInfo : carInfos) {
            maxDistance = Math.max(maxDistance, carInfo.getDistance());
        }

        for (CarInfo carInfo : carInfos) {
            if (carInfo.getDistance() == maxDistance) {
                winners.add(carInfo.getName());
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