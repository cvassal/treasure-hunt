package data.boardcase;

import domain.adventurer.Coordinate;
import domain.board.element.Case;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BoardCase {
    private Coordinate coordinate;

    private Case boardCase;
}
