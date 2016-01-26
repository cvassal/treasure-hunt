package board.element;

public class Mountain implements Case {

    @Override
    public boolean isCrossable() {
        return false;
    }

    @Override
    public boolean isContainingTreasure() {
        return false;
    }
}
