package be.cegeka.marsrover.domain;

import org.junit.Test;

import static be.cegeka.marsrover.domain.Orientation.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OrientationTest {


    @Test
    public void turnLeft() {
        assertThat(NORTH.left()).isEqualTo(WEST);
        assertThat(WEST.left()).isEqualTo(SOUTH);
        assertThat(SOUTH.left()).isEqualTo(EAST);
        assertThat(EAST.left()).isEqualTo(NORTH);
    }

    @Test
    public void turnRight() {
        assertThat(NORTH.right()).isEqualTo(EAST);
        assertThat(EAST.right()).isEqualTo(SOUTH);
        assertThat(SOUTH.right()).isEqualTo(WEST);
        assertThat(WEST.right()).isEqualTo(NORTH);
    }
}