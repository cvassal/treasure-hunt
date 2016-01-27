package domain.board;

import domain.adventurer.Coordinate;
import domain.board.element.Case;


public abstract class Observer {
    public abstract Case watchForward(Coordinate coordinate);
}
