package board;

import adventurer.Coordinate;
import board.element.Case;


public abstract class Observer {
    public abstract Case watchForward(Coordinate coordinate);
}
