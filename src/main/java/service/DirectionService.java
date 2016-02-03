package service;

import domain.adventurer.Direction;

public class DirectionService {

    public Direction turnRight(Direction direction) {
        return direction.turnRight();
    }

    public Direction turnLeft(Direction direction) {
        return direction.turnLeft();
    }
}
