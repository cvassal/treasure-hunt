import com.google.common.primitives.Chars;
import domain.adventurer.Adventurer;
import domain.adventurer.Coordinate;
import domain.adventurer.Direction;
import domain.board.Board;
import domain.board.Size;
import domain.board.element.Mountain;
import domain.board.element.Treasure;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TreasureHuntTest {

    @Test
    public void should_find_one_treasure() throws Exception {
        Board board = new Board(new Size(4, 4));
        board.setCase(2, 2, new Treasure(1));
        Adventurer rickHunter = Adventurer.builder()
                .name("Rick Hunter")
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
    public void should_find_be_blocked_by_a_mountain() throws Exception {
        Board board = new Board(new Size(4, 4));
        board.setCase(1, 0, new Mountain());
        Adventurer rickHunter = Adventurer.builder()
                .name("Rick Hunter")
                .direction(Direction.EAST)
                .position(new Coordinate(0, 0))
                .movements(Chars.asList('A', 'D', 'A'))
                .build();
        rickHunter.huntOn(board);

        rickHunter.goHunt();

        assertThat(rickHunter.getPosition()).isEqualTo(new Coordinate(0, 1));
    }
}