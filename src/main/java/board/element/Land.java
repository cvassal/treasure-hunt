package board.element;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Land extends Case {

    public boolean isCrossable() {
        return true;
    }
}
