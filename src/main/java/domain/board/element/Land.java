package domain.board.element;

public class Land implements Case {

    private boolean isLock;

    @Override
    public boolean isCrossable() {
        return true;
    }

    @Override
    public boolean isContainingTreasure() {
        return false;
    }

    @Override
    public void lock() {
        isLock = true;
    }

    @Override
    public void unlock() {
        isLock = false;
    }

    @Override
    public boolean isUnlock() {
        return !isLock;
    }
}
