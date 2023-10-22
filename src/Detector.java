public abstract class Detector { // En abstrakt klass, kan ej instanseras direkt. Används för att definiera en grundstruktur för andra klasser
    // Protected innebär att den är synlig för andra klasser inom samma paket.
    protected String location;
    protected boolean activated;
    protected boolean systemActivated;


    public Detector (String location, boolean activated, boolean systemActivated){ //Konstruktor för klassen, används för att initialisera objekt av en klass när den skapas.
        //Dvs man ger ett startvärde.
        //Konstruktorn tillåter en att skapa en detektor objekt där man kan ange plats, och om aktiveringsläge etc.
        //Här tilldelar man värdet med nyckelordet this.
        this.location = location;
        this.systemActivated = systemActivated;
        this.activated = activated;
    }

    public void activate(){ //Denna metod används för att aktiver larmet, dvs larmet är redo att gå igång.
    activated = true;
    } //Metod för activate, aktiveringsläge.
    public void deactivate(){ // Denna metod används för att avaktiver larmet, dvs att larmet inte kommer reagera när den är inaktiv.
        activated = false;
    } //Metod för deactivate, avaktiveringsläge.
    public abstract void detect(); // Abstrakt metod som måste implementeras av underklasser. Ger möjligheten att implementera metoden för andra klasser på sitt sätt.

    //GETTERS OCH SETTERS
    //Ett sätt att hämta dessa variabler.
    public abstract String getType();

    public String getLocation(){
        return location;
    }
    public boolean getactivated (){
        return activated;
    }
}