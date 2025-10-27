package racingcar.model.strategy;

public class NeverMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMovable() {
        return false;
    }
}
