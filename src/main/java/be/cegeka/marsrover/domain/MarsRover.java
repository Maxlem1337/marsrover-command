package be.cegeka.marsrover.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MarsRover {

    @EqualsAndHashCode.Include
    private final UUID id;

    private Location location;
    private Orientation orientation;

    public MarsRover(Location location, Orientation orientation) {
        this.id = UUID.randomUUID();
        this.location = location;
        this.orientation = orientation;
    }

    public void move() {
        this.location = new Location(location.getX()+orientation.getOffsetX(), location.getY()+orientation.getOffsetY());
    }

    public void turnLeft() {
        this.orientation = orientation.left();
    }

    public void turnRight() {
        this.orientation = orientation.right();
    }
}
