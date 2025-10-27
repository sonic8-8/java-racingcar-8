package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarSnapshot;
import racingcar.model.strategy.AlwaysMoveStrategy;
import racingcar.model.strategy.NeverMoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class CarsTest {
    @DisplayName("주입된 전략이 이동이라면 자동차가 1만큼 전진한다.")
    @Test
    void playRound_move() {
        // given
        Car carA = Car.of("carA", 0);
        Car carB = Car.of("carB", 0);
        Car carC = Car.of("carC", 0);
        Cars cars = Cars.of(List.of(carA, carB, carC));

        AlwaysMoveStrategy alwaysMove = new AlwaysMoveStrategy();

        // when
        cars.playRound(alwaysMove);

        // then
        assertThat(cars.snapshot())
                .extracting("name", "distance")
                .containsExactly(
                        tuple("carA", 1),
                        tuple("carB", 1),
                        tuple("carC", 1)
                );
    }

    @DisplayName("주입된 전략이 멈춤이라면 자동차가 멈춘다.")
    @Test
    void playRound_stop() {
        // given
        Car carA = Car.of("carA", 0);
        Car carB = Car.of("carB", 0);
        Car carC = Car.of("carC", 0);
        Cars cars = Cars.of(List.of(carA, carB, carC));

        NeverMoveStrategy neverMove = new NeverMoveStrategy();

        // when
        cars.playRound(neverMove);

        // then
        assertThat(cars.snapshot())
                .extracting("name", "distance")
                .containsExactly(
                        tuple("carA", 0),
                        tuple("carB", 0),
                        tuple("carC", 0)
                );
    }

    @DisplayName("자동차의 현재 상태 리스트를 CarSnapshot 리스트로 반환한다.")
    @Test
    void snapshot() {
        // given
        Car carA = Car.of("carA", 0);
        Car carB = Car.of("carB", 0);
        Car carC = Car.of("carC", 0);
        Cars cars = Cars.of(List.of(carA, carB, carC));

        // when
        List<CarSnapshot> snapshot = cars.snapshot();

        // then
        assertThat(snapshot)
                .extracting("name", "distance")
                .containsExactly(
                        tuple("carA", 0),
                        tuple("carB", 0),
                        tuple("carC", 0)
                );
    }

    @DisplayName("findWinners 메서드는 가장 멀리까지 이동한 자동차를 우승으로 처리한다.")
    @Test
    void findWinners() {
        // given
        Car carA = Car.of("carA", 5);
        Car carB = Car.of("carB", 3);
        Car carC = Car.of("carC", 1);
        Cars cars = Cars.of(List.of(carA, carB, carC));

        // when
        List<String> winners = cars.findWinners();

        // then
        assertThat(winners).containsExactly("carA");
    }

    @DisplayName("가장 멀리까지 이동한 자동차가 여러 대라면 공동 우승으로 처리한다.")
    @Test
    void findWinners_multipleWinners() {
        // given
        Car carA = Car.of("carA", 5);
        Car carB = Car.of("carB", 5);
        Car carC = Car.of("carC", 1);
        Cars cars = Cars.of(List.of(carA, carB, carC));

        // when
        List<String> winners = cars.findWinners();

        // then
        assertThat(winners).containsExactly("carA", "carB");
    }
}