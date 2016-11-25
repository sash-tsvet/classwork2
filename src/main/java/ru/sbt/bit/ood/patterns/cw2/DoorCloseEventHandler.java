package ru.sbt.bit.ood.patterns.cw2;

public class DoorCloseEventHandler implements EventHandler {
    private SmartHome home;
    public DoorCloseEventHandler (SmartHome myHome){
        home = myHome;
    }
    @Override
    public void execute(HomeEvent event) {
        if (event instanceof DoorCloseEvent){
            if (((DoorCloseEvent) event).door.getType() == DoorType.ENTRANCE){
                home.turnOffTheLights();
            }
        }
    }
}
