package domain.adventurer;

import domain.board.Observer;
import domain.board.element.Case;

public class Subject {
    private Observer observer;

    public void huntOn(Observer observer) {
        this.observer = observer;
    }

    public Case getCaseAt(Coordinate caseCoordinate) {
        return observer.watchForward(caseCoordinate);
    }
}
