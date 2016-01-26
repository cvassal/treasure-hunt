import adventurer.Adventurer;
import adventurer.Coordinate;
import adventurer.Direction;
import board.Board;
import board.element.Case;
import board.element.Land;
import board.element.Mountain;
import board.element.Treasure;
import com.google.common.primitives.Chars;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TreasureHuntTest {

    @Test
    public void should_find_one_treasure() {
        Board board = new Board(new Case[4][4]);
        board.setCase(2, 1, new Land());
        board.setCase(2, 2, new Treasure(1));
        Adventurer rickHunter = Adventurer.builder()
                .direction(Direction.EAST)
                .position(new Coordinate(1, 1))
                .movements(Chars.asList('A', 'D', 'A'))
                .build();
        rickHunter.huntOn(board);

        rickHunter.goHunt();

        assertThat(rickHunter.getPosition()).isEqualTo(new Coordinate(2, 2));
        assertThat(rickHunter.getTreasure()).isEqualTo(1);
    }

    @Test
    public void should_find_be_blocked_by_a_mountain() {
        Board board = new Board(new Case[4][4]);
        board.setCase(1, 0, new Mountain());
        board.setCase(0, 1, new Land());
        Adventurer rickHunter = Adventurer.builder()
                .direction(Direction.EAST)
                .position(new Coordinate(0, 0))
                .movements(Chars.asList('A', 'D', 'A'))
                .build();
        rickHunter.huntOn(board);


        rickHunter.goHunt();

        assertThat(rickHunter.getPosition()).isEqualTo(new Coordinate(0, 1));
    }
}