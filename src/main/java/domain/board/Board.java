package domain.board;

import java.util.List;

import data.boardcase.BoardCase;
import domain.adventurer.Coordinate;
import domain.board.element.Case;
import domain.board.element.Land;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Board extends Observer {
    private Case[][] boardCases;

    public Board(Size size) {
        initBoard(size);
    }

    private void initBoard(Size size) {
        boardCases = new Case[size.getX()][size.getY()];
        for (int x = 0; x <= size.getX() - 1; x++) {
            for (int y = 0; y <= size.getY() - 1; y++) {
                setCase(x, y, new Land());
            }
        }
    }

    public void setCase(int x, int y, Case boardCase) {
        try {
            boardCases[x][y] = boardCase;
        } catch (Exception e) {
            System.out.println("WARN : " + x + ", " + y + " is out of the board, " +
                    "you won't set nothing here, this " + boardCase.getClass().getSimpleName() + " will be ignored");
        }
    }

    public Case getCase(int x, int y) {
        try {
            return boardCases[x][y];
        } catch (Exception e) {
            System.out.println("WARN : End of the board, you won't go there, wait for next move");
            return null;
        }
    }

    public boolean isEmpty() {
        return boardCases == null;
    }

    private void setBoardCase(BoardCase boardCase) {
        Coordinate coordinate = boardCase.getCoordinate();
        setCase(coordinate.getX(), coordinate.getY(), boardCase.getBoardCase());
    }

    public void setCases(List<BoardCase> boardCases) {
        boardCases.forEach(this::setBoardCase);
    }

    @Override
    public Case watchForward(Coordinate coordinate) {
        return getCase(coordinate.getX(), coordinate.getY());
    }
}
