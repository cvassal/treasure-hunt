package board.element;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
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
