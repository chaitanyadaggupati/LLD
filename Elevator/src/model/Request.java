package model;

import model.enums.Direction;
import model.enums.Location;

public class Request {
    public Integer currentFloor;
    public Integer desiredFloor;
    public Direction direction;
    public Location location;

    public Request(Integer currentFloor, Integer desiredFloor, Direction direction, Location location) {
        this.currentFloor = currentFloor;
        this.desiredFloor = desiredFloor;
        this.direction = direction;
        this.location = location;
    }
}
