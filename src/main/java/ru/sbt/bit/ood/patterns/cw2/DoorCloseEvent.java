package ru.sbt.bit.ood.patterns.cw2;

public class DoorCloseEvent implements HomeEvent {
    Door door;
    public DoorCloseEvent (Door myDoor) { door = myDoor;}

    public Door getDoor() {
        return door;
    }
}
