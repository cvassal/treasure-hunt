package domain.adventurer;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Adventurer extends Subject {

    private Coordinate position;

    private Coordinate nextPosition;

    private Direction direction;

    private String name = "John DOE";

    private List<Character> movements;

    private int treasure;

    public Coordinate getNextPosition() {
        if (nextPosition == null) {
            nextPosition = new Coordinate(position.getX(), position.getY());
        }
        return nextPosition;
    }

    public void addToTreasure(int quantity) {
        treasure += quantity;
    }

    @Override
    public String toString() {
        return "Hunter : " + name +
                " on position X : " + position.getX() +
                ", Y : " + position.getY() +
                " have " + treasure + " treasure(s)";
    }
}
