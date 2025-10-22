package racingcar.util;

public class CarNameValidator {
    public void validate(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }

        // TODO: 이름에 공백이 들어갈 경우 재입력
        if (carName.isEmpty()) {
        }

        // TODO: 이름 중복일 경우 재입력
    }

    // TODO: 시도할 횟수가 0인 경우 재입력, Validator를 2개로 나눌지 1개로 할 지 생각해보기
}
