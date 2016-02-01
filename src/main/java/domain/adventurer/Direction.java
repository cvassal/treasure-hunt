package domain.adventurer;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction fromLetter(String direction) {
        switch (direction) {
            case "N":
                return NORTH;
            case "E":
                return EAST;
            case "S":
                return SOUTH;
            case "O":
                return WEST;
            default:
                throw new RuntimeException(direction + " is not a valid direction");
        }
    }
}
