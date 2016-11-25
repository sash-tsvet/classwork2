package ru.sbt.bit.ood.patterns.cw2;

import java.io.OutputStream;

public class DoorOpenEventHandler implements EventHandler {
    @Override
    public void execute(HomeEvent event) {
        if (event instanceof DoorOpenEvent){
            System.out.println("Door opened\n");
        }
    }
}
