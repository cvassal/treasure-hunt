package adventurer;

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

        assertThat(hunter.getPosition().getX()).isEqualTo(2);
    }

    @Test
    public void adventurer_should_move_left() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(2, 1))
                .direction(Direction.WEST)
                .build();

        hunter.goForward();

        assertThat(hunter.getPosition().getX()).isEqualTo(1);
    }

    @Test
    public void adventurer_should_move_down() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(1, 1))
                .direction(Direction.SOUTH)
                .build();

        hunter.goForward();

        assertThat(hunter.getPosition().getY()).isEqualTo(2);
    }

    @Test
    public void adventurer_should_move_up() {
        Adventurer hunter = Adventurer.builder()
                .position(new Coordinate(1, 2))
                .direction(Direction.NORTH)
                .build();

        hunter.goForward();

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
}