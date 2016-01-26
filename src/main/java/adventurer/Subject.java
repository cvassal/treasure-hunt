package adventurer;

import board.Observer;
import board.element.Case;

public class Subject {
    private Observer observer;

    public void huntOn(Observer observer) {
        this.observer = observer;
    }

    public Case watchForward(Coordinate forward) {
        return observer.watchForward(forward);
    }
}
