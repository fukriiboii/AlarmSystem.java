public class SprinklerSystem extends Detector {

    public SprinklerSystem(String location, boolean activated, boolean systemActivated) {
        super(location, false, systemActivated);
    }

    @Override
    public void detect() {
        if (systemActivated && activated){
            System.out.println("Sprinklern är aktiverad i " + getLocation());
        }

    }

    @Override
    public String getType() {
        return "SPRINKLER";
    }
}
