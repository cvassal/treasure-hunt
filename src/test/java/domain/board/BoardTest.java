package domain.board;

import domain.board.element.Land;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class BoardTest {

    @Test
    public void should_init_a_board_1_x_1_with_land_by_default() throws Exception {
        Board board = new Board(new Size(1, 1));

        assertThat(board.getCase(0, 0)).isExactlyInstanceOf(Land.class);
    }

    @Test
    public void should_not_allow_0_x_0_board() throws Exception {
        assertThat(catchThrowable(() -> new Board(new Size(0, 0))))
                .isInstanceOf(Exception.class)
                .hasMessage("Board size must not be under 1 x 1");
    }
}