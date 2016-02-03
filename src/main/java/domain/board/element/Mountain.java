package domain.board.element;

public class Mountain implements Case {

    @Override
    public boolean isCrossable() {
        return false;
    }

    @Override
    public boolean isContainingTreasure() {
        return false;
    }

    @Override
    public void lock() {
    }

    @Override
    public void unlock() {
    }

    @Override
    public boolean isUnlock() {
        return false;
    }
}
