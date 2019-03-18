package be.cegeka.marsrover;

import be.cegeka.marsrover.domain.Location;
import be.cegeka.marsrover.domain.MarsRover;
import org.junit.Test;

import static be.cegeka.marsrover.domain.Orientation.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverUnitTest {

    @Test
    public void moveNorth() {
        MarsRover marsRover = new MarsRover(new Location(0, 0), NORTH);

        marsRover.move();

        assertThat(marsRover.getLocation()).isEqualTo(new Location(0, 1));
        assertThat(marsRover.getOrientation()).isEqualTo(NORTH);
    }

    @Test
    public void moveSouth() {
        MarsRover marsRover = new MarsRover(new Location(0, 0), SOUTH);

        marsRover.move();

        assertThat(marsRover.getLocation()).isEqualTo(new Location(0, -1));
        assertThat(marsRover.getOrientation()).isEqualTo(SOUTH);
    }

    @Test
    public void moveEast() {
        MarsRover marsRover = new MarsRover(new Location(0, 0), EAST);

        marsRover.move();

        assertThat(marsRover.getLocation()).isEqualTo(new Location(1, 0));
        assertThat(marsRover.getOrientation()).isEqualTo(EAST);
    }

    @Test
    public void moveWest() {
        MarsRover marsRover = new MarsRover(new Location(0, 0), WEST);

        marsRover.move();

        assertThat(marsRover.getLocation()).isEqualTo(new Location(-1, 0));
        assertThat(marsRover.getOrientation()).isEqualTo(WEST);
    }

    @Test
    public void turnLeft() {
        MarsRover marsRover = new MarsRover(new Location(0, 0), WEST);

        marsRover.turnLeft();

        assertThat(marsRover.getLocation()).isEqualTo(new Location(0, 0));
        assertThat(marsRover.getOrientation()).isEqualTo(SOUTH);
    }

    @Test
    public void turnRight() {
        MarsRover marsRover = new MarsRover(new Location(0, 0), WEST);

        marsRover.turnRight();

        assertThat(marsRover.getLocation()).isEqualTo(new Location(0, 0));
        assertThat(marsRover.getOrientation()).isEqualTo(NORTH);
    }


}
