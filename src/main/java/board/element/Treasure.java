package board.element;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
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
}
