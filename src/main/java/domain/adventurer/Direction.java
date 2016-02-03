package domain.adventurer;

import java.util.Map;

import static com.google.common.collect.Maps.uniqueIndex;
import static java.util.EnumSet.allOf;

public enum Direction {
    NORTH("N") {
        @Override
        public Direction turnLeft() {
            return WEST;
        }

        @Override
        public Direction turnRight() {
            return EAST;
        }

        @Override
        public void advance(Coordinate coordinate) {
            coordinate.goUp();
        }
    },
    EAST("E") {
        @Override
        public Direction turnLeft() {
            return NORTH;
        }

        @Override
        public Direction turnRight() {
            return SOUTH;
        }

        @Override
        public void advance(Coordinate coordinate) {
            coordinate.goRight();
        }
    },
    SOUTH("S") {
        @Override
        public Direction turnLeft() {
            return EAST;
        }

        @Override
        public Direction turnRight() {
            return WEST;
        }

        @Override
        public void advance(Coordinate coordinate) {
            coordinate.goDown();
        }
    },
    WEST("O") {
        @Override
        public Direction turnLeft() {
            return SOUTH;
        }

        @Override
        public Direction turnRight() {
            return NORTH;
        }

        @Override
        public void advance(Coordinate coordinate) {
            coordinate.goLeft();
        }
    };

    private final String directionLetter;
    private static final Map<String, Direction> LOOKUP = uniqueIndex(
            allOf(Direction.class),
            Direction::getDirectionLetter
    );

    Direction(String directionLetter) {
        this.directionLetter = directionLetter;
    }

    public static Direction fromLetter(String direction) {
        return LOOKUP.get(direction);
    }

    public String getDirectionLetter() {
        return directionLetter;
    }

    public abstract Direction turnLeft();

    public abstract Direction turnRight();

    public abstract void advance(Coordinate coordinate);
}
