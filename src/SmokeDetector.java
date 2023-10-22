public class SmokeDetector extends Detector {
    public SmokeDetector(String location, boolean activated, boolean systemActivated) { //Konstruktor som gör de möjligt att skapa en objekt av SmokeDetector klassen.
        super(location, activated, systemActivated); //Refererar till den överordnade klassen, dvs Detektor klassen. Man anropar överordnade klassens konstruktor.

    }

    @Override
    public void detect() { //Överskriver den abstrakta metoden från detektor klassen hit. Här kan man implementera som man önskar.
        if (activated && systemActivated) {
            System.out.println("Rökdetektorn har detekterat rök i " + getLocation());
        }
    }

    @Override
    public String getType() {
        return "RÖKDETEKTOR";
    }
}
