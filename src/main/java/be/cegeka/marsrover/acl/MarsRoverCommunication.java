package be.cegeka.marsrover.acl;

import be.cegeka.marsrover.domain.MarsRover;
import be.cegeka.marsrover.donttouch.MarsPlateau;
import be.cegeka.marsrover.donttouch.MarsRoverCommunicationAPI;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class MarsRoverCommunication implements MarsRoverCommunicationAPI {

    public static int MINIMUM_COMMAND_COUNT = 5;

    private final MarsPlateau marsPlateau;

    @Override
    public void sendMarsRoverCommand(UUID marsRoverId, String command, String... args) {
        MarsRover marsRover = marsPlateau.lookupMarsRover(marsRoverId);
        switch (command) {
            case "M":
                marsRover.move();
                break;
            case "L":
                marsRover.turnLeft();
                break;
            case "R":
                marsRover.turnRight();
                break;
        }
    }
}
