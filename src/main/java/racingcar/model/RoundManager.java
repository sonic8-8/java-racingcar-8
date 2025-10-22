package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.CarInfo;

import java.util.List;

public class RoundManager {
    public void play(List<CarInfo> carInfos) {
        for (CarInfo car : carInfos) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (4 <= random) {
                car.moveForward();
            }
        }
    }
}

