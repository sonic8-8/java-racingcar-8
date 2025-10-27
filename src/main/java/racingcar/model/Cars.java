package racingcar.model;

import racingcar.dto.CarSnapshot;
import racingcar.model.strategy.MoveStrategy;

import java.util.Comparator;
import java.util.List;

public class Cars {
    List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public void playRound(MoveStrategy moveStrategy) {
        cars.stream()
                .filter(car -> moveStrategy.isMovable())
                .forEach(Car::moveForward);
    }

    public List<CarSnapshot> snapshot() {
        return cars.stream()
                .map(car -> new CarSnapshot(car.getName(), car.getDistance()))
                .toList();
    }

    public List<String> findWinners() {
        int maxDistance = cars.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .orElseThrow(IllegalArgumentException::new)
                .getDistance();

        return cars.stream()
                .filter(car -> maxDistance == car.getDistance())
                .map(Car::getName)
                .toList();
    }
}
