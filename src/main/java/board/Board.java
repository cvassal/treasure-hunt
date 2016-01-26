package board;

import adventurer.Coordinate;
import board.element.Case;
import board.element.Land;

public class Board extends Observer {
    private Case[][] boardCases;

    public Board(Size size) throws Exception {
        initBoard(size);
    }

    private void initBoard(Size size) throws Exception {
        boardCases = new Case[size.getX()][size.getY()];
        for (int x = 0; x <= size.getX() - 1; x++) {
            for (int y = 0; y <= size.getY() - 1; y++) {
                setCase(x, y, new Land());
            }
        }
    }

    public void setCase(int x, int y, Case boardCase) throws Exception {

        try {
            boardCases[x][y] = boardCase;
        } catch (Exception e) {
            throw new Exception("ERROR : " + x + ", " + y + " is out of the board, you won't set nothing here");
        }
    }

    public Case getCase(int x, int y) {
        try {
            return boardCases[x][y];
        } catch (Exception e) {
            System.out.println("End of the board, you won't go there");
            return null;
        }
    }

    @Override
    public Case watchForward(Coordinate coordinate) {
        return getCase(coordinate.getX(), coordinate.getY());
    }
}
