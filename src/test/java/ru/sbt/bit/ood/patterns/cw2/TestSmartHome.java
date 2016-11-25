package ru.sbt.bit.ood.patterns.cw2;

import org.junit.Test;

import java.util.Collection;
import static junit.framework.TestCase.assertEquals;

public class TestSmartHome {

    @Test
    public void testTurnOffTheLights() {
        // setup
        SimpleLight testLight = createAndTurnOnTheLight();
        SmartHome home = createSmartHomeWithSingleLight(testLight);
        // exercise
        home.turnOffTheLights();
        // assert
        assertLightsAreOff(home.getLights());
    }

    private SmartHome createSmartHomeWithSingleLight(SimpleLight testLight) {
        SmartHome home = new SmartHome();
        home.addLight(testLight);
        return home;
    }

    private SimpleLight createAndTurnOnTheLight() {
        SimpleLight testLight = new SimpleLight(LightLocation.LIVING_ROOM);
        testLight.turnOn();
        return testLight;
    }

    private void assertLightsAreOff(Collection<Light> lights) {
        for (Light light : lights) {
            assertEquals(LightState.OFF, light.getState());
        }
    }

    private void assertLightsAreOn(Collection<Light> lights) {
        for (Light light : lights) {
            assertEquals(LightState.ON, light.getState());
        }
    }

    @Test
    public void testTurnOffTheLightsOnDoorClose() {
        // setup
        SmartHome home = new SmartHome();
        DoorCloseEventHandler eventHandler = new DoorCloseEventHandler(home);
        SimpleLight testLight = createAndTurnOnTheLight();
        home.addLight(testLight);
        SimpleDoor door = new SimpleDoor(DoorType.ENTRANCE, eventHandler);
        // assert
        assertLightsAreOn(home.getLights());
        // exercise
        door.close();
        // assert
        assertLightsAreOff(home.getLights());
    }

}
