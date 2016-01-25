package board;

import board.element.Case;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Board {
    private Case[][] boardCases;

    public void setCase(int x, int y, Case boardCase) {
        boardCases[x][y] = boardCase;
    }

    public Case getCase(int x, int y) {
        return boardCases[x][y];
    }
}
