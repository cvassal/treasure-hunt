package board.element;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Treasure extends Case {
    private int quantity;

    @Override
    boolean isCrossable() {
        return true;
    }
}
