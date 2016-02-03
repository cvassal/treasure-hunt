package domain.board.element;

public interface Case {

    boolean isCrossable();

    boolean isContainingTreasure();

    void lock();

    void unlock();

    boolean isUnlock();
}
