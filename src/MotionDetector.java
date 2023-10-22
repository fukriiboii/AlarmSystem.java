public class MotionDetector extends Detector{
    public MotionDetector(String location, boolean activated, boolean systemActivated){
        super(location, false, systemActivated);
    }


    @Override
    public void detect() {
        if (activated && systemActivated) {
            System.out.println("Rörelse detekterat i " + getLocation());
        }

    }

    @Override
    public String getType() {
        return "RÖRELSEDETEKTOR";
    }
}
