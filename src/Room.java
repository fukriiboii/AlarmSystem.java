import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<Detector> detectors;
    public List<MotionDetector> motionDetectors;
    private List<SmokeDetector> smokeDetectors;
    private List<WindowSensor> windowSensors;
    private List<DoorDetector> doorDetectors;
    private List<SprinklerSystem> sprinklerSystems;

    public Room(String name) {
        this.name = name;
        this.detectors = new ArrayList<>();
        this.motionDetectors = new ArrayList<>();
        this.smokeDetectors = new ArrayList<>();
        this.windowSensors = new ArrayList<>();
        this.doorDetectors = new ArrayList<>();
        this.sprinklerSystems = new ArrayList<>();
    }


    public void addMotionDetector(MotionDetector motionDetector) {
        motionDetectors.add(motionDetector);
    }

    public void addSmokeDetector(SmokeDetector smokeDetector) {
        smokeDetectors.add(smokeDetector);
    }
    public void addSprinklerSystem(SprinklerSystem sprinklerSystem){
        sprinklerSystems.add(sprinklerSystem);
    }

    public void addWindowSensor(WindowSensor windowSensor) {
        windowSensors.add(windowSensor);
    }

    public void addDoorDetector(DoorDetector doorDetector) {
        doorDetectors.add(doorDetector);
    }

    public void activateDetectors() {
        for (Detector detector : detectors) {
            detector.activate();
        }
        for (MotionDetector motionDetector : motionDetectors) {
            motionDetector.activate();
        }
        for (SmokeDetector smokeDetector : smokeDetectors) {
            smokeDetector.activate();
        }
        for (WindowSensor windowSensor : windowSensors) {
            windowSensor.activate();
        }
        for (DoorDetector doorDetector : doorDetectors) {
            doorDetector.activate();
        }
        for (SprinklerSystem sprinklerSystem : sprinklerSystems){
            sprinklerSystem.activate();
        }
    }

    public void deactivateDetectors() {
        for (Detector detector : detectors) {
            detector.deactivate();
        }
        for (MotionDetector motionDetector : motionDetectors) {
            motionDetector.deactivate();
        }
        for (SmokeDetector smokeDetector : smokeDetectors) {
            smokeDetector.activate();
        }
        for (WindowSensor windowSensor : windowSensors) {
            windowSensor.deactivate();
        }
        for (DoorDetector doorDetector : doorDetectors) {
            doorDetector.deactivate();
        }
        for (SprinklerSystem sprinklerSystem : sprinklerSystems){
            sprinklerSystem.deactivate();
        }
    }
    public List<SprinklerSystem> getSprinklerSystems(){
        return sprinklerSystems;
    }
    public List<SmokeDetector> getSmokeDetectors(){
        return smokeDetectors;
    }
    public List<MotionDetector> getMotionDetectors(){
        return motionDetectors;
    }
    public List<DoorDetector> getDoorDetectors(){
        return doorDetectors;
    }
    public List<WindowSensor> getWindowSensors(){
        return windowSensors;
    }

    public String getName() {
        return name;
    }
}
