package ru.sbt.bit.ood.patterns.cw2.events;

import ru.sbt.bit.ood.patterns.cw2.ObservableObject;
import ru.sbt.bit.ood.patterns.cw2.objects.Door;
import ru.sbt.bit.ood.patterns.cw2.objects.DoorType;

import java.util.EventListener;

public class ProxyDoor implements Door {

    private Door door;
    private HomeEventListener eventListener;

    public ProxyDoor(Door door) {
        this.door = door;
    }

    public void setEventListener(HomeEventListener eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    public void open() {
        this.door.open();
        this.eventListener.onEvent(new DoorOpenEvent(door));
    }

    @Override
    public void close() {
        this.door.close();
        this.eventListener.onEvent(new DoorCloseEvent(door));
    }

    @Override
    public boolean isOpen() {
        return this.door.isOpen();
    }

    @Override
    public DoorType getType() {
        return this.door.getType();
    }
}
