package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("사용자에게 입력받은 자동차 이름으로 자동차 객체를 생성한다.")
    @Test
    void create_car() {
        // given
        String name = "pobi";
        int initialDistance = 0;

        // when
        Car car = Car.of(name, initialDistance);

        // then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("moveForward 메서드는 자동차의 거리를 1만큼 증가시킨다.")
    @Test
    void moveForward() {
        // given
        Car car = Car.of("pobi", 0);

        // when
        car.moveForward();

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }
}