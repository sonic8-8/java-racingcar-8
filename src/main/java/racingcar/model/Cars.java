package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarSnapshot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public void playRound() {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (4 <= random) {
                car.moveForward();
            }
        }
    }

    public List<CarSnapshot> snapshot() {
        return cars.stream()
                .map(car -> new CarSnapshot(car.getName(), car.getDistance()))
                .toList();
    }

    public String findWinners() {
        int maxDistance = cars.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .orElseThrow(IllegalArgumentException::new)
                .getDistance();

        List<Car> winners = cars.stream()
                .filter(car -> maxDistance == car.getDistance())
                .toList();

        return winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }
}
