package domain.adventurer;

import domain.board.element.Case;
import domain.board.element.Treasure;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static domain.adventurer.Direction.*;

@Data
@Builder
public class Adventurer extends Subject {
    private Coordinate position;
    private Coordinate nextPosition;
    private Direction direction;
    private String name = "John DOE";

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

    public void lookAndWalkForward() {
        goForward();
        lookForward();
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
    }

    public void lookForward() {
        Case caseForward = watchForward(nextPosition());

        if (caseForward != null && caseForward.isCrossable()) {
            if (caseForward.isContainingTreasure()) {
                treasure += ((Treasure) caseForward).getQuantity();
            }
            commitMove();
        } else {
            rollBackMove();
        }
    }

    private void rollBackMove() {
        nextPosition = position;
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
                    lookAndWalkForward();
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

    @Override
    public String toString() {
        return "Hunter : " + name +
                " on position X : " + position.getX() +
                ", Y : " + position.getY() +
                " have " + treasure + " treasure(s)";
    }
}
