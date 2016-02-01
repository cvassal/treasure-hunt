package domain.board.element;

public class Land implements Case {

    @Override
    public boolean isCrossable() {
        return true;
    }

    @Override
    public boolean isContainingTreasure() {
        return false;
    }
}
