package ru.sbt.bit.ood.patterns.cw2;

import ru.sbt.bit.ood.patterns.cw2.events.Action;
import ru.sbt.bit.ood.patterns.cw2.objects.Door;
import ru.sbt.bit.ood.patterns.cw2.objects.Light;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
    private final Collection<Light> lights = new ArrayList<>();
    private final Collection<Door> doors = new ArrayList<>();

    public SmartHome() {
    }

    public void addLight(Light light) {
        lights.add(light);
    }

    public void addDoor(Door door) {
        doors.add(door);

    }

    public void turnOffTheLights() {
        for (Light light : lights) {
            light.turnOff();
        }
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public void forEach (Action action) {
        for (Light somelight:
             lights) {
            action.execute (somelight);
            for (Door somedoor:
                 doors) {
                action.execute(somedoor);
            }

        }
    }

}
