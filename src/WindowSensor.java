import java.util.List;

public class WindowSensor extends Detector{
    public WindowSensor(String location, boolean activated, boolean systemActivated) {
        super(location, false, systemActivated);

    }

    @Override
    public void detect() {
        if (activated && systemActivated) {
                System.out.println("Fönsterdetektorn har detekterat krossat fönster i " + getLocation());
        }

    }

    @Override
    public String getType() {
        return "FÖNSTERDETEKTOR";
    }
}
