package racingcar.converter;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.processor.UserInputCarNameParser;
import racingcar.processor.UserInputValidator;

import java.util.List;

public class CarsConverter {

    private final UserInputCarNameParser parser;
    private final UserInputValidator validator;

    public CarsConverter(UserInputCarNameParser parser, UserInputValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public Cars convertCarsFrom(String userInput) {
        List<String> carNames = parser.parse(userInput);

        List<Car> carList = carNames.stream()
                .map(carName -> {
                    validator.validateCarNameLength(carName);
                    return Car.of(carName, 0);
                })
                .toList();

        return Cars.of(carList);
    }
}
