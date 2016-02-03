package domain.board.element;

import lombok.Data;

@Data
public class Treasure implements Case {
    private int quantity;
    private boolean isLock;

    public Treasure(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean isCrossable() {
        return true;
    }

    @Override
    public boolean isContainingTreasure() {
        return true;
    }

    public int takeTreasure() {
        int quantityToTake = quantity;
        quantity = 0;
        return quantityToTake;
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
