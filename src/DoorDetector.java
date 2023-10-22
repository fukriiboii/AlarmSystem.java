public class DoorDetector extends Detector{
    public DoorDetector (String location, boolean activated, boolean systemActivated){
        super(location, false, systemActivated);

    }
    @Override
    public void detect() {
        if (activated && systemActivated){
            System.out.println("Dörrdetektorn har detekterar bruten dörr i " + getLocation());
        }


    }

    @Override
    public String getType() {
        return "DÖRRDETEKTOR";
    }
}
