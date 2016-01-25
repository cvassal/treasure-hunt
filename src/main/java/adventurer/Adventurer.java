package adventurer;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import static adventurer.Direction.*;

@Data
@Builder
public class Adventurer {
    private Coordinate position;
    private Coordinate nextPosition;
    private Direction direction;

    private List<Character> movements;

    private int treasure;

    private Coordinate nextPosition() {
        if (nextPosition == null) {
            nextPosition = new Coordinate(position.getX(), position.getY());
        }
        return nextPosition;
    }

    private Direction changeDirection(int ordinalChange) {
        if (ordinalChange < 0 && direction.ordinal() == 0) {
            return WEST;
        } else if (ordinalChange > 0 && direction.ordinal() == 3) {
            return NORTH;
        }

        return values()[direction.ordinal() + ordinalChange];
    }

    public void goForward() {
        switch (direction) {
            case NORTH:
                nextPosition().goUp();
                break;
            case EAST:
                nextPosition().goRight();
                break;
            case SOUTH:
                nextPosition().goDown();
                break;
            case WEST:
                nextPosition().goLeft();
                break;
        }
        commitMove();
    }

    public void commitMove() {
        position = nextPosition;
    }

    public void turnRight() {
        direction = changeDirection(1);
    }

    public void turnLeft() {
        direction = changeDirection(-1);
    }

    public void goHunt() {
        for (Character movement : movements) {
            switch (movement) {
                case 'A':
                    goForward();
                    break;
                case 'G':
                    turnLeft();
                    break;
                case 'D':
                    turnRight();
                    break;
            }
        }

    }
}
