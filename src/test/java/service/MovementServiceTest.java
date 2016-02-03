package service;

import com.google.common.primitives.Chars;
import domain.adventurer.Adventurer;
import domain.adventurer.Coordinate;
import domain.adventurer.Direction;
import domain.board.Board;
import domain.board.Size;
import domain.board.element.Land;
import domain.board.element.Mountain;
import domain.board.element.Treasure;
import org.junit.Test;

import static domain.adventurer.Direction.EAST;
import static domain.adventurer.Direction.SOUTH;
import static org.assertj.core.api.Assertions.assertThat;

public class MovementServiceTest {

    @Test
    public void adventurer_should_move_right() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(1, 1))
                .direction(Direction.EAST)
                .build();
        MovementService movementService = new MovementService(hunter);

        movementService.setNextPosition();
        movementService.commitMove();

        assertThat(hunter.getPosition().getX()).isEqualTo(2);
    }

    @Test
    public void adventurer_should_move_left() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(2, 1))
                .direction(Direction.WEST)
                .build();
        MovementService movementService = new MovementService(hunter);

        movementService.setNextPosition();
        movementService.commitMove();

        assertThat(hunter.getPosition().getX()).isEqualTo(1);
    }

    @Test
    public void adventurer_should_move_down() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(1, 1))
                .direction(Direction.SOUTH)
                .build();
        MovementService movementService = new MovementService(hunter);

        movementService.setNextPosition();
        movementService.commitMove();


        assertThat(hunter.getPosition().getY()).isEqualTo(2);
    }

    @Test
    public void adventurer_should_move_up() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(1, 2))
                .direction(Direction.NORTH)
                .build();
        MovementService movementService = new MovementService(hunter);

        movementService.setNextPosition();
        movementService.commitMove();

        assertThat(hunter.getPosition().getY()).isEqualTo(1);
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
        MovementService movementService = new MovementService(hunter);

        movementService.lookForwardAndGoIfPossible();

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
        MovementService movementService = new MovementService(hunter);

        movementService.lookForwardAndGoIfPossible();

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
        MovementService movementService = new MovementService(hunter);

        movementService.lookForwardAndGoIfPossible();

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
        MovementService movementService = new MovementService(hunter);

        movementService.lookForwardAndGoIfPossible();

        assertThat(hunter.getPosition()).isEqualTo(new Coordinate(1, 0));
    }

    @Test
    public void should_lock_then_unlock_case() {
        Adventurer adventurer = Adventurer.builder()
                .direction(EAST)
                .position(new Coordinate(1, 3))
                .movements(Chars.asList('A'))
                .build();
        Board board = new Board(new Size(4, 4));
        adventurer.huntOn(board);
        MovementService movementService = new MovementService(adventurer);
        movementService.lockStartCase();

        assertThat(board.getCase(1, 3).isUnlock()).isFalse();
        movementService.lookAndWalkForward();
        assertThat(board.getCase(1, 3).isUnlock()).isTrue();
        assertThat(board.getCase(2, 3).isUnlock()).isFalse();
    }

    @Test
    public void should_wait_for_case_to_be_free() {
        Adventurer nick = Adventurer.builder()
                .name("Nick")
                .direction(EAST)
                .position(new Coordinate(1, 3))
                .movements(Chars.asList('A'))
                .build();
        Adventurer rick = Adventurer.builder()
                .name("Rick")
                .direction(SOUTH)
                .position(new Coordinate(1, 2))
                .movements(Chars.asList('A'))
                .build();
        Board board = new Board(new Size(4, 4));
        nick.huntOn(board);
        rick.huntOn(board);
        MovementService nickMovementService = new MovementService(nick);
        nickMovementService.lockStartCase();
        MovementService rickMovementService = new MovementService(rick);
        nickMovementService.lockStartCase();

        rickMovementService.lookAndWalkForward();
        assertThat(board.getCase(1, 3).isUnlock()).isFalse();
        assertThat(rick.getPosition()).isEqualTo(new Coordinate(1, 2));
        nickMovementService.lookAndWalkForward();
        assertThat(board.getCase(1, 3).isUnlock()).isTrue();
        rickMovementService.lookAndWalkForward();
        assertThat(rick.getPosition()).isEqualTo(new Coordinate(1, 3));
    }
}