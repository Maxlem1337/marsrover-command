package be.cegeka.marsrover;

import be.cegeka.marsrover.acl.MarsRoverCommunication;
import be.cegeka.marsrover.domain.Location;
import be.cegeka.marsrover.domain.MarsRover;
import be.cegeka.marsrover.donttouch.MarsPlateau;
import be.cegeka.marsrover.donttouch.MarsRoverCommunicationAPI;
import be.cegeka.marsrover.stub.MarsPlateauStub;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static be.cegeka.marsrover.acl.MarsRoverCommunication.MINIMUM_COMMAND_COUNT;
import static be.cegeka.marsrover.domain.Orientation.NORTH;
import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverQueueingTest {

    private MarsRoverCommunicationAPI api;
    private MarsPlateau marsPlateau = new MarsPlateauStub();

    @Before
    public void setUp() throws Exception {
        this.marsPlateau = new MarsPlateauStub();
        this.api = new MarsRoverCommunication(marsPlateau);
    }

    @Test
    public void whenNotEnoughCommandsReceived_shouldNotExecuteCommands() {
        UUID marsRoverId = marsPlateau.deployMarsRover(new Location(2, 2), NORTH);
        MINIMUM_COMMAND_COUNT = 3;

        api.sendMarsRoverCommand(marsRoverId, "M");
        api.sendMarsRoverCommand(marsRoverId, "M");

        MarsRover marsRover = marsPlateau.lookupMarsRover(marsRoverId);
        assertThat(marsRover.getLocation()).isEqualTo(new Location(2, 2));
        assertThat(marsRover.getOrientation()).isEqualTo(NORTH);
    }

    @Test
    public void whenEnoughCommandsReceived_shouldExecuteCommands() {
        UUID marsRoverId = marsPlateau.deployMarsRover(new Location(2, 2), NORTH);
        MINIMUM_COMMAND_COUNT = 3;

        api.sendMarsRoverCommand(marsRoverId, "M");
        api.sendMarsRoverCommand(marsRoverId, "M");
        api.sendMarsRoverCommand(marsRoverId, "M");

        MarsRover marsRover = marsPlateau.lookupMarsRover(marsRoverId);
        assertThat(marsRover.getLocation()).isEqualTo(new Location(2, 5));
        assertThat(marsRover.getOrientation()).isEqualTo(NORTH);
    }

}