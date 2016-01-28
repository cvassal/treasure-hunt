package domain.adventurer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinate {
    private int x;
    private int y;

    public static Coordinate parseFromString(String coordinate) {
        String[] coordinates = coordinate.split("-");
        return new Coordinate(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }

    public void goLeft() {
        setX(changeX(-1));
    }

    public void goRight() {
        setX(changeX(1));
    }

    public void goUp() {
        setY(changeY(-1));
    }

    public void goDown() {
        setY(changeY(1));
    }

    private int changeX(int x) {
        return getX() + x;
    }

    private int changeY(int y) {
        return getY() + y;
    }
}
