package ru.sbt.bit.ood.patterns.cw2;

import ru.sbt.bit.ood.patterns.cw2.events.Action;
import ru.sbt.bit.ood.patterns.cw2.objects.Door;
import ru.sbt.bit.ood.patterns.cw2.objects.Light;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SmartHome implements Iterable{
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
        }
        for (Door somedoor:
                doors) {
            action.execute(somedoor);
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator(){
            private Iterator lit = lights.iterator();
            private Iterator dit = doors.iterator();

            @Override
            public boolean hasNext() {
                return lit.hasNext() || dit.hasNext();
            }

            @Override
            public Object next() {
                if (lit.hasNext()) return lit.next();
                else return dit.next();
            }
        };
    }
}
