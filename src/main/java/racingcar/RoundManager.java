package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;

public class RoundManager {
    public void play(List<Car> cars) {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (4 <= random) {
                car.moveForward();
            }
        }
    }
}

