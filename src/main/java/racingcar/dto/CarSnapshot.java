package racingcar.dto;

public record CarSnapshot(String name, int distance) {

    public CarSnapshot(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
}
