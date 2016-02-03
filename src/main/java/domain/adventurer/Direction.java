package domain.adventurer;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;

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
    };

    private final String directionLetter;
    private static final Map<String, Direction> LOOKUP = Maps.uniqueIndex(
            Arrays.asList(Direction.values()),
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
}
