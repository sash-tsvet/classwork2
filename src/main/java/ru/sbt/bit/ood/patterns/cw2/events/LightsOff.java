package ru.sbt.bit.ood.patterns.cw2.events;

import ru.sbt.bit.ood.patterns.cw2.objects.Light;

public class LightsOff implements Action {
    @Override
    public void execute(Object obj) {
        if (obj instanceof Light){
            ((Light) obj).turnOff();
        }
    }
}
