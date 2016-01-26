package board;

import adventurer.Coordinate;
import board.element.Case;

public class Board extends Observer {
    private Case[][] boardCases;

    public Board(Case[][] boardCases) {
        this.boardCases = boardCases;
    }

    public void setCase(int x, int y, Case boardCase) {
        boardCases[x][y] = boardCase;
    }

    public Case getCase(int x, int y) {
        return boardCases[x][y];
    }

    @Override
    public Case watchForward(Coordinate coordinate) {
        try {
            return getCase(coordinate.getX(), coordinate.getY());
        } catch (Exception e) {
            System.out.println("End of the board, you won't go there");
            return null;
        }
    }
}
