package racingcar;

public class CarInfo {
    private String name;
    private int distance;

    private CarInfo(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static CarInfo of(String name, int distance) {
        return new CarInfo(name, distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        this.distance++;
    }
}