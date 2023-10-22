import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class CentralUnit {
    private boolean systemActivated;
    private List<Room> rooms;
    private Scanner scanner;

    public CentralUnit(List<Room> rooms) {
        this.rooms = rooms;
        this.systemActivated = false;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    } //Metodd för att kunna läggaa till rum i listan.

    public void activateSystem() {
        if (!systemActivated) {
            for (Room room : rooms) {
                room.activateDetectors();
            }
            systemActivated = true;
            System.out.println("Systemet är aktiverat.");
        } else {
            System.out.println("Systemet är redan aktiverat.");
        }
    }

    public void deactivateSystem() {
        if (systemActivated) {
            for (Room room : rooms) {
                room.deactivateDetectors();

            }
            systemActivated = false;
            System.out.println("Systemet är inaktiverat.");
        } else {
            System.out.println("Systemet är redan inaktiverat.");
        }
    }

    public void resetSystem() {
        if (systemActivated) {
            for (Room room : rooms) {
                room.deactivateDetectors();
            }
            systemActivated = false;
            System.out.println("Systemet är återställt.");
        } else {
            System.out.println("Systemet är redan inaktiverat.");
        }
    }

    public void showConnectedDevices() {

        for (Room room : rooms) { //Datatyp, varabel, samling: Går igenom varje element i Listan.
            System.out.println("Rum: " + room.getName());
            System.out.println("Anslutna detektorer:");
            for (DoorDetector doorDetector : room.getDoorDetectors()) {
                String status = doorDetector.getactivated() ? "Aktiverad" : "Avaktiverad";
                System.out.println("- " + doorDetector.getType() + " (" + status + ")");
            }
            for (WindowSensor windowSensor : room.getWindowSensors()) {
                String status = windowSensor.getactivated() ? "Aktiverad" : "Avaktiverad";
                System.out.println("- " + windowSensor.getType() + " (" + status + ")");
            }
            for (MotionDetector motionDetector : room.getMotionDetectors()) {
                String status = motionDetector.getactivated() ? "Aktiverad" : "Avaktiverad";
                System.out.println("- " + motionDetector.getType() + " (" + status + ")");
            }
            for (SprinklerSystem sprinklerSystem : room.getSprinklerSystems()) {
                String status = sprinklerSystem.getactivated() ? "Aktiverad" : "Avaktiverad";
                System.out.println("- " + sprinklerSystem.getType() + " (" + status + ")");
            }
            for (SmokeDetector smokeDetector : room.getSmokeDetectors()) {
                String status = smokeDetector.getactivated() ? "Aktiverad" : "Avaktiverad";
                System.out.println("- " + smokeDetector.getType() + " (" + status + ")");
            }
            System.out.println("--------");
        }
    }

    public void simulateEvent() {
        scanner = new Scanner(System.in);

        if (systemActivated) {
            System.out.println("Vänligen välj en händelsetyp:");
            System.out.println("1. Brand");
            System.out.println("2. Inbrott");
            System.out.println("3. Rörelse");

            if (scanner.hasNextInt()) {//Kontrollerar om det är en heltal innan den fortsätter.

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        simulateFireEvent();
                        break;
                    case 2:
                        simulateBreakInEvent();
                        break;
                    case 3:
                        simulateMotionEvent();
                        break;
                    default:
                        System.out.println("Ogiltigt val. Försök igen.");
                }
            } else {
                System.out.println("Systemet är inte aktiverat. Kan inte simulera händelse.");
                scanner.close();
            }
        }
    }

    private void simulateFireEvent() {
        Random random = new Random(); //RandomObjekt
        Room randomRoom;
        //Do-While-Loop används för att slumpa ett rumm och kontrollera om rummet är POOL. Om det är POOL fortsäter loopen.

        do {
            int randomRoomIndex = random.nextInt(rooms.size()); //Skapar ett index bland rummen.
            randomRoom = rooms.get(randomRoomIndex);
        } while (randomRoom.getName().equalsIgnoreCase("POOL")); // Upprepa tills ett rum som inte är POOL slumpas

        System.out.println("Simulerar brand i: " + randomRoom.getName());

        List<SmokeDetector> smokeDetectors = randomRoom.getSmokeDetectors(); //Hämtar rökdetektorn från de slumpade rummet.
        if (!smokeDetectors.isEmpty()) { //Kontrollerar om listan inte är tom.
            SmokeDetector randomSmokeDetector = smokeDetectors.get(random.nextInt(smokeDetectors.size())); // Hämtar den slumpade rökdetektorn.

            randomSmokeDetector.detect(); //Anropar detect metoden.

            if (randomSmokeDetector.getactivated()) { //Ifall rökdetektorn aktiveras, aktiveras sprinkler.
                for (SprinklerSystem sprinklerSystem : randomRoom.getSprinklerSystems()) {
                    sprinklerSystem.detect(); //Anropar detect metoden.
                }
            }
        } else {
            System.out.println("Ingen rökdetektor i rummet, sprinklersystemet kan inte aktiveras.");
        }
    }



    private void simulateBreakInEvent() {
        Random random = new Random(); //Skapar en Randomobjekt.
        Room randomRoom; //Deklarerar en variabel av typen Room utan något värde.

        // Slumpa ett rum tills det inte är poolområdet
        do {
            int randomRoomIndex = random.nextInt(rooms.size());//Genererar ett slumpmässigt heltal mellan 0 och antal rum.
            randomRoom = rooms.get(randomRoomIndex); //Hämtar rummet från listan.
        } while (randomRoom.getName().equalsIgnoreCase("POOL")); //Jämför namnet med POOL.

        System.out.println("Simulerar inbrottshändelse: " + randomRoom.getName());

        int detectorType = random.nextInt(2);//Heltalen representerar typ av detektor.

        if (detectorType == 0 && !randomRoom.getWindowSensors().isEmpty()) { //Om detectortype är 0 ska en fönsterdetector aktiveras. och kontrollerar om rummet har fönstersensor.
            // Slumpa en fönstersensor från listan av fönstersensorer i rummet
            WindowSensor randomWindowSensor = randomRoom.getWindowSensors().get(random.nextInt(randomRoom.getWindowSensors().size()));
            // Aktivera den slumpade fönstersensorn genom att anropa dess detect-metod
            randomWindowSensor.detect();
        } else if (detectorType == 1 && !randomRoom.getDoorDetectors().isEmpty()) {// Om detectortype är 1 ska en dörrdetector aktiveras.
            DoorDetector randomDoorDetector = randomRoom.getDoorDetectors().get(random.nextInt(randomRoom.getDoorDetectors().size()));
            randomDoorDetector.detect();
        }
    }


    private void simulateMotionEvent() {
        Random random = new Random();
        int randomRoomIndex;
        Room randomRoom;

        // Slumpa ett rum med minst en rörelsedetektor
        do {
            // Slumpa ett index för ett rum från listan av rum
            randomRoomIndex = random.nextInt(rooms.size());

            // Hämta det slumpade rummet från listan beroende på slumpade indexet.
            randomRoom = rooms.get(randomRoomIndex);
            // Upprepa tills ett rum med minst en rörelsedetektor hittas
        } while (randomRoom.getMotionDetectors().isEmpty());

        System.out.println("Simulerar rörelse i rum: " + randomRoom.getName());

        // Hämta rörelsedetektorer från det slumpade rummet
        List<MotionDetector> motionDetectors = randomRoom.getMotionDetectors();

        // Slumpa en rörelsedetektor från listan av rörelsedetektorer
        MotionDetector randomMotionDetector = motionDetectors.get(random.nextInt(motionDetectors.size()));

        // Simulera rörelsehändelse med den slumpade rörelsedetektorn
        randomMotionDetector.detect();
    }

}


