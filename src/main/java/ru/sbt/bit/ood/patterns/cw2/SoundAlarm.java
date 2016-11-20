package ru.sbt.bit.ood.patterns.cw2;

import ru.sbt.bit.ood.patterns.cw2.objects.Alarm;
import ru.sbt.bit.ood.patterns.cw2.objects.AlarmState;

public class SoundAlarm implements Alarm {

    private AlarmState state;

    public SoundAlarm() {
        state = AlarmState.DEACTIVATED;
    }

    @Override
    public AlarmState getState() {
        return state;
    }

    @Override
    public void activate() {
        state = AlarmState.ACTIVATED;
    }

    @Override
    public void deactivate() {
        state = AlarmState.DEACTIVATED;
    }

    @Override
    public void alarm() {
        if (state == AlarmState.ACTIVATED) {
            System.out.println("Making a loud sound!");
        }
    }

}
