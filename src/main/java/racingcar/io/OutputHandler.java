package racingcar.io;

public class OutputHandler {
    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    // TODO: 각 자동차의 이동 거리 상태를 관리할 객체 만들기
    public void showRoundResult() {
    }

    // TODO: 자동차 객체 리스트의 이동 거리를 확인 후 최종 우승자를 구한다
    public void showGameWinnersFrom() {
        System.out.print("최종 우승자 : ");
    }
}
