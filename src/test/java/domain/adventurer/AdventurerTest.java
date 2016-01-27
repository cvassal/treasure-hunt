package domain.adventurer;

import domain.board.Board;
import domain.board.Size;
import domain.board.element.Land;
import domain.board.element.Mountain;
import domain.board.element.Treasure;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdventurerTest {

    @Test
    public void adventurer_should_move_right() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(1, 1))
                .direction(Direction.EAST)
                .build();

        hunter.goForward();
        hunter.commitMove();

        assertThat(hunter.getPosition().getX()).isEqualTo(2);
    }

    @Test
    public void adventurer_should_move_left() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(2, 1))
                .direction(Direction.WEST)
                .build();

        hunter.goForward();
        hunter.commitMove();

        assertThat(hunter.getPosition().getX()).isEqualTo(1);
    }

    @Test
    public void adventurer_should_move_down() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(1, 1))
                .direction(Direction.SOUTH)
                .build();

        hunter.goForward();
        hunter.commitMove();

        assertThat(hunter.getPosition().getY()).isEqualTo(2);
    }

    @Test
    public void adventurer_should_move_up() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(1, 2))
                .direction(Direction.NORTH)
                .build();

        hunter.goForward();
        hunter.commitMove();

        assertThat(hunter.getPosition().getY()).isEqualTo(1);
    }

    @Test
    public void should_turn_from_north_to_east() {
        Adventurer hunter = Adventurer.builder().direction(Direction.NORTH).build();

        hunter.turnRight();

        assertThat(hunter.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void should_turn_from_east_to_north() {
        Adventurer hunter = Adventurer.builder().direction(Direction.EAST).build();

        hunter.turnLeft();

        assertThat(hunter.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void should_turn_from_west_to_north() {
        Adventurer hunter = Adventurer.builder().direction(Direction.WEST).build();

        hunter.turnRight();

        assertThat(hunter.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void should_turn_from_north_to_west() {
        Adventurer hunter = Adventurer.builder().direction(Direction.NORTH).build();

        hunter.turnLeft();

        assertThat(hunter.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void should_not_move_because_of_a_mountain() throws Exception {
        Board board = new Board(new Size(2, 1));
        board.setCase(1, 0, new Mountain());
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(0, 0))
                .build();
        hunter.setNextPosition(new Coordinate(1, 0));
        hunter.huntOn(board);

        hunter.lookForward();

        assertThat(hunter.getPosition()).isEqualTo(new Coordinate(0, 0));
    }

    @Test
    public void should_move_because_nothing_block() throws Exception {
        Board board = new Board(new Size(2, 1));
        board.setCase(1, 0, new Land());
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(0, 0))
                .build();
        hunter.setNextPosition(new Coordinate(1, 0));
        hunter.huntOn(board);

        hunter.lookForward();

        assertThat(hunter.getPosition()).isEqualTo(new Coordinate(1, 0));
    }

    @Test
    public void should_move_and_find_a_treasure() throws Exception {
        Board board = new Board(new Size(2, 1));
        board.setCase(1, 0, new Treasure(1));
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(0, 0))
                .build();
        hunter.setNextPosition(new Coordinate(1, 0));
        hunter.huntOn(board);

        hunter.lookForward();

        assertThat(hunter.getPosition()).isEqualTo(new Coordinate(1, 0));
        assertThat(hunter.getTreasure()).isEqualTo(1);
    }

    @Test
    public void should_not_fall_out_of_the_board() throws Exception {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(1, 0))
                .build();
        hunter.setNextPosition(new Coordinate(2, 0));
        hunter.huntOn(new Board(new Size(2, 1)));

        hunter.lookForward();

        assertThat(hunter.getPosition()).isEqualTo(new Coordinate(1, 0));
    }
}