package domain.board.element;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Treasure implements Case {
    private int quantity;

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
}
