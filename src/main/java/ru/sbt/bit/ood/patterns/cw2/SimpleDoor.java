package ru.sbt.bit.ood.patterns.cw2;

public class SimpleDoor implements Door {
    private boolean isOpen = false;
    private final DoorType doorType;
    private final EventHandler handler;

    public SimpleDoor(DoorType doorType, EventHandler handler) {
        this.doorType = doorType;
        this.handler = handler;
    }

    @Override
    public void open() {
        isOpen = true;
    }

    @Override
    public void close() {
        isOpen = false;
        handler.execute(new DoorCloseEvent(this));
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public DoorType getType() {
        return doorType;
    }
}
